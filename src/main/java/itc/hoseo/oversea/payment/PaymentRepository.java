package itc.hoseo.oversea.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
	public List<String> getAccount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> accountList = null;
		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select * from bank");
			rs = pstmt.executeQuery();

			accountList = new ArrayList<String>();

			while (rs.next()) {
				String account = new String(
						rs.getString("account") + " " + rs.getString("bank") + " " + rs.getString("name"));
				accountList.add(account);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return accountList;
	}

	public void insertBuy(String buyerEmail, String subsName, String subsPhone, int prod_id, String prod_kind,
			String prod_title, String prod_image, int buy_price, int buy_amount, String payment, String subs_date)
			throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Timestamp reg_date = null;
		String sql = "";
		String maxDate = " ";
		String number = "";
		String todayDate = "";
		String compareDate = "";
		long buyId = 0;
		int nowCount;
		int salesCount;
		try {
//			conn = getConnection();
			reg_date = new Timestamp(System.currentTimeMillis());
			todayDate = reg_date.toString();
			compareDate = todayDate.substring(0, 4) + todayDate.substring(5, 7) + todayDate.substring(8, 10);

			pstmt = conn.prepareStatement("select max(buy_id) from buy");

			rs = pstmt.executeQuery();
			rs.next();
			if (rs.getLong(1) > 0) {
				Long val = new Long(rs.getLong(1));
				maxDate = val.toString().substring(0, 8);
				number = val.toString().substring(8);
				if (compareDate.equals(maxDate)) {
					if ((Integer.parseInt(number) + 1) < 10000)
						buyId = Long.parseLong(maxDate + (Integer.parseInt(number) + 1 + 10000));
					else
						buyId = Long.parseLong(maxDate + (Integer.parseInt(number) + 1));
				} else {
					compareDate += "00001";
					buyId = Long.parseLong(compareDate);
				}
			} else {
				compareDate += "00001";
				buyId = Long.parseLong(compareDate);
			}
			conn.setAutoCommit(false);

			sql = "insert into buy (buy_id, buyerEmail, subsName, subsPhone, prod_id, prod_kind,";
			sql += "prod_title, buy_price, buy_amount, prod_image, buy_date, payment, subs_date)";
			sql += " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, buyId);
			pstmt.setString(2, buyerEmail);
			pstmt.setString(3, subsName);
			pstmt.setString(4, subsPhone);
			pstmt.setInt(5, prod_id);
			pstmt.setString(6, prod_kind);
			pstmt.setString(7, prod_title);
			pstmt.setInt(8, buy_price);
			pstmt.setInt(9, buy_amount);
			pstmt.setString(10, prod_image);
			pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(12, payment);
			pstmt.setString(13, subs_date);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select prod_count from prod where prod_id=?");
			pstmt.setInt(1, prod_id);
			rs = pstmt.executeQuery();
			rs.next();

			nowCount = rs.getInt(1) - buy_amount;

			sql = "update prod set prod_count=? where prod_id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, nowCount);
			pstmt.setInt(2, prod_id);

			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select prod_sales from prod where prod_id=?");
			pstmt.setInt(1, prod_id);
			rs = pstmt.executeQuery();
			rs.next();

			salesCount = rs.getInt(1) + buy_amount;

			sql = "update prod set prod_sales=? where prod_id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, salesCount);
			pstmt.setInt(2, prod_id);

			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	public int getListCount(String buyerEmail) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from buy where buyerEmail=?");
			pstmt.setString(1, buyerEmail);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public int getListCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from buy");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public List<Payment> getBuyList(String buyerEmail) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Payment buy = null;
		String sql = "";
		List<Payment> lists = null;

		try {
//			conn = getConnection();

			sql = "select * from buy where buyerEmail = ? order by buy_date desc";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, buyerEmail);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Payment>();

			while (rs.next()) {
				buy = new Payment();

				buy.setBuy_id(rs.getLong("buy_id"));
				buy.setProdId(rs.getInt("prod_id"));
				buy.setProdTitle(rs.getString("prod_title"));
				buy.setBuyPrice(rs.getInt("buy_price"));
				buy.setBuyAmount(rs.getByte("buy_amount"));
				buy.setProdImage(rs.getString("prod_image"));
				buy.setSanction(rs.getString("sanction"));

				lists.add(buy);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return lists;
	}

	public List<Payment> getBuyList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Payment buy = null;
		String sql = "";
		List<Payment> lists = null;

		try {
//			conn = getConnection();

			sql = "select * from buy order by buy_date desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Payment>();

			while (rs.next()) {
				buy = new Payment();

				buy.setBuy_id(rs.getLong("buy_id"));
				buy.setBuyerEmail(rs.getString("buyerEmail"));
				buy.setSubsName(rs.getString("subsName"));
				buy.setSubsPhone(rs.getString("subsPhone"));
				buy.setSubsDate(rs.getTimestamp("subsDate"));
				buy.setProdId(rs.getInt("prod_id"));
				buy.setProdTitle(rs.getString("prod_title"));
				buy.setBuyPrice(rs.getInt("buy_price"));
				buy.setBuyAmount(rs.getByte("buy_amount"));
				buy.setProdImage(rs.getString("prod_image"));
				buy.setBuyDate(rs.getTimestamp("buy_date"));
				buy.setPayment(rs.getString("payment"));
				buy.setSanction(rs.getString("sanction"));

				lists.add(buy);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return lists;
	}
}
