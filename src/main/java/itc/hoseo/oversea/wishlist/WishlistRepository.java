package itc.hoseo.oversea.wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WishlistRepository {
	public void insertWishList(Wishlist wishlist) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			if (wishlist.getProd_image() == null) {
//				conn = getConnection();
				sql = "insert into wishlist (wisher, prod_id, prod_kind, prod_title, prod_com, prod_price) "
						+ "values (?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, wishlist.getWisher());
				pstmt.setInt(2, wishlist.getProd_id());
				pstmt.setString(3, wishlist.getProd_kind());
				pstmt.setString(4, wishlist.getProd_title());
				pstmt.setString(5, wishlist.getProd_com());
				pstmt.setInt(6, wishlist.getProd_price());

				pstmt.executeUpdate();
			} else {
//				conn = getConnection();
				sql = "insert into wishlist (wisher, prod_id, prod_kind, prod_title, prod_image, prod_com, prod_price) "
						+ "values (?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, wishlist.getWisher());
				pstmt.setInt(2, wishlist.getProd_id());
				pstmt.setString(3, wishlist.getProd_kind());
				pstmt.setString(4, wishlist.getProd_title());
				pstmt.setString(5, wishlist.getProd_image());
				pstmt.setString(6, wishlist.getProd_com());
				pstmt.setInt(7, wishlist.getProd_price());

				pstmt.executeUpdate();
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
	}

	public int getListCount(String wisher) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from wishlist where wisher=?");
			pstmt.setString(1, wisher);
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

	public int getWishlistCount(int prod_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from wishlist where prod_id=?");
			pstmt.setInt(1, prod_id);
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

	public List<Wishlist> getWishlist(String wisher) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Wishlist wishlist = null;
		String sql = "";
		List<Wishlist> lists = null;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select * from wishlist where wisher = ?");

			pstmt.setString(1, wisher);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Wishlist>();

			while (rs.next()) {
				wishlist = new Wishlist();

				wishlist.setWishlist_id(rs.getInt("wishlist_id"));
				wishlist.setProd_id(rs.getInt("prod_id"));
				wishlist.setProd_kind(rs.getString("prod_kind"));
				wishlist.setProd_title(rs.getString("prod_title"));
				wishlist.setProd_image(rs.getString("prod_image"));
				wishlist.setProd_com(rs.getString("prod_com"));
				wishlist.setProd_price(rs.getInt("prod_price"));

				lists.add(wishlist);
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

	public void deleteList(int wishlist_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("delete from  wishlist where wishlist_id=?");
			pstmt.setInt(1, wishlist_id);

			pstmt.executeUpdate();
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

	public void deleteAll(String wisher) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("delete from wishlist where wisher=?");
			pstmt.setString(1, wisher);

			pstmt.executeUpdate();
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

}
