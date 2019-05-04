package itc.hoseo.oversea.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {
	public void insertProd(Product prod) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			conn = getConnection();

			if (prod.getProdImgName() == null) {
				pstmt = conn.prepareStatement("insert into prod(prod_desti, prod_kind, prod_title, prod_price, "
						+ "prod_count, prod_com, prod_content, reg_date)" + " values (?,?,?,?,?,?,?,?)");
				pstmt.setString(1, prod.getProdDesti());
				pstmt.setString(2, prod.getProdKind());
				pstmt.setInt(3, prod.getProdPrice());
				pstmt.setInt(4, prod.getProdCount());
				pstmt.setString(5, prod.getProdCom());
				pstmt.setString(6, prod.getProdContent());
				pstmt.setTimestamp(7, prod.getRegDate());

				pstmt.executeUpdate();
			} else {
				pstmt = conn
						.prepareStatement("insert into prod(prod_desti, prod_kind, prod_title, prod_price, prod_count, "
								+ "prod_com, prod_imgName, prod_imgRealName, prod_content, reg_date)"
								+ " values (?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, prod.getProdDesti());
				pstmt.setString(2, prod.getProdKind());
				pstmt.setString(3, prod.getProdTitle());
				pstmt.setInt(4, prod.getProdPrice());
				pstmt.setInt(5, prod.getProdCount());
				pstmt.setString(6, prod.getProdCom());
				pstmt.setString(7, prod.getProdImgName());
				pstmt.setString(8, prod.getProdImgRealName());
				pstmt.setString(9, prod.getProdContent());
				pstmt.setTimestamp(10, prod.getRegDate());

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

	public int getProdCount(String prod_kind) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			String sql1 = "select count(*) from prod";
			String sql2 = "select count(*) from prod prod_kind=?";
			if (prod_kind.equals("all")) {
				pstmt = conn.prepareStatement(sql1);
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, prod_kind);
			}
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
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

	public int getProdDestiCount(String prod_desti, String prod_kind) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			String sql1 = "select count(*) from prod where prod_desti=?";
			String sql2 = "select count(*) from prod where prod_desti=? and prod_kind=?";
			if (prod_kind.equals("all")) {
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, prod_desti);
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, prod_desti);
				pstmt.setString(2, prod_kind);
			}
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
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

	public int getProdAmount(int prod_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select prod_count from prod where prod_id=?");
			pstmt.setInt(1, prod_id);

			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
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

	public List<Product> getProds(String prod_kind) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> prodList = null;

		try {
//			conn = getConnection();

			String sql1 = "select * from prod order by reg_date desc";
			String sql2 = "select * from prod ";
			sql2 += "where prod_kind = ? order by reg_date desc";

			if (prod_kind.equals("all")) {
				pstmt = conn.prepareStatement(sql1);
				rs = pstmt.executeQuery();
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, prod_kind);
				rs = pstmt.executeQuery();
			}

			if (rs.next()) {
				prodList = new ArrayList<Product>();
				do {
					Product prod = new Product();

					prod.setProdId(rs.getInt("prod_id"));
					prod.setProdKind(rs.getString("prod_kind"));
					prod.setProdTitle(rs.getString("prod_title"));
					prod.setProdPrice(rs.getInt("prod_price"));
					prod.setProdCount(rs.getShort("prod_count"));
					prod.setProdCom(rs.getString("prod_com"));
					prod.setProdImgName(rs.getString("prod_imgName"));
					prod.setProdImgRealName(rs.getString("prod_imgRealName"));
					prod.setRegDate(rs.getTimestamp("reg_date"));

					prodList.add(prod);
				} while (rs.next());
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
		return prodList;
	}

	public List<Product> getBestSeller() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> prodList = null;

		try {
//			conn = getConnection();

			String sql1 = "select * from prod order by prod_sales desc limit 4";

			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				prodList = new ArrayList<Product>();
				do {
					Product prod = new Product();

					prod.setProdId(rs.getInt("prod_id"));
					prod.setProdKind(rs.getString("prod_kind"));
					prod.setProdTitle(rs.getString("prod_title"));
					prod.setProdPrice(rs.getInt("prod_price"));
					prod.setProdCount(rs.getShort("prod_count"));
					prod.setProdCom(rs.getString("prod_com"));
					prod.setProdImgName(rs.getString("prod_imgName"));
					prod.setProdImgRealName(rs.getString("prod_imgRealName"));
					prod.setRegDate(rs.getTimestamp("reg_date"));

					prodList.add(prod);
				} while (rs.next());
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
		return prodList;
	}

	public List<Product> getDestiProds(int start, int end, String prod_desti, String prod_kind,
			String prod_align) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> prodList = null;

		try {
//			conn = getConnection();
			String allSql1 = "select * from prod where prod_desti=? order by reg_date desc limit ?,?";
			String allSql2 = "select * from prod where prod_desti=? order by prod_sales desc limit ?,?";
			String allSql3 = "select * from prod where prod_desti=? order by prod_price asc limit ?,?";
			String allSql4 = "select * from prod where prod_desti=? order by prod_price desc limit ?,?";
			String kindSql1 = "select * from prod where prod_desti=? and prod_kind = ? order by reg_date desc limit ?,?";
			String kindSql2 = "select * from prod where prod_desti=? and prod_kind = ? order by prod_sales desc limit ?,?";
			String kindSql3 = "select * from prod where prod_desti=? and prod_kind = ? order by prod_price desc limit ?,?";
			String kindSql4 = "select * from prod where prod_desti=? and prod_kind = ? order by prod_price desc limit ?,?";

			if (prod_kind.equals("all")) {
				if (prod_align.equals("new")) {
					pstmt = conn.prepareStatement(allSql1);
					pstmt.setString(1, prod_desti);
					pstmt.setInt(2, start - 1);
					pstmt.setInt(3, end);
				} else if (prod_align.equals("popular")) {
					pstmt = conn.prepareStatement(allSql2);
					pstmt.setString(1, prod_desti);
					pstmt.setInt(2, start - 1);
					pstmt.setInt(3, end);
				} else if (prod_align.equals("lowPrice")) {
					pstmt = conn.prepareStatement(allSql3);
					pstmt.setString(1, prod_desti);
					pstmt.setInt(2, start - 1);
					pstmt.setInt(3, end);
				} else if (prod_align.equals("highPrice")) {
					pstmt = conn.prepareStatement(allSql4);
					pstmt.setString(1, prod_desti);
					pstmt.setInt(2, start - 1);
					pstmt.setInt(3, end);
				}
			} else {
				if (prod_align.equals("new")) {
					pstmt = conn.prepareStatement(kindSql1);
					pstmt.setString(1, prod_desti);
					pstmt.setString(2, prod_kind);
					pstmt.setInt(3, start - 1);
					pstmt.setInt(4, end);
				} else if (prod_align.equals("popular")) {
					pstmt = conn.prepareStatement(kindSql2);
					pstmt.setString(1, prod_desti);
					pstmt.setString(2, prod_kind);
					pstmt.setInt(3, start - 1);
					pstmt.setInt(4, end);
				} else if (prod_align.equals("lowPrice")) {
					pstmt = conn.prepareStatement(kindSql3);
					pstmt.setString(1, prod_desti);
					pstmt.setString(2, prod_kind);
					pstmt.setInt(3, start - 1);
					pstmt.setInt(4, end);
				} else if (prod_align.equals("highPrice")) {
					pstmt = conn.prepareStatement(kindSql4);
					pstmt.setString(1, prod_desti);
					pstmt.setString(2, prod_kind);
					pstmt.setInt(3, start - 1);
					pstmt.setInt(4, end);
				}

			}
			rs = pstmt.executeQuery();

			if (rs.next()) {
				prodList = new ArrayList<Product>();
				do {
					Product prod = new Product();

					prod.setProdId(rs.getInt("prod_id"));
					prod.setProdKind(rs.getString("prod_kind"));
					prod.setProdTitle(rs.getString("prod_title"));
					prod.setProdPrice(rs.getInt("prod_price"));
					prod.setProdCount(rs.getShort("prod_count"));
					prod.setProdCom(rs.getString("prod_com"));
					prod.setProdImgName(rs.getString("prod_imgName"));
					prod.setProdImgRealName(rs.getString("prod_imgRealName"));
					prod.setRegDate(rs.getTimestamp("reg_date"));

					prodList.add(prod);
				} while (rs.next());
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
		return prodList;
	}

	public List<Product> getSearchProds(String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> prodList = null;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select * from prod where prod_title like '%" + keyword + "%'");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				prodList = new ArrayList<Product>();
				do {
					Product prod = new Product();

					prod.setProdId(rs.getInt("prod_id"));
					prod.setProdKind(rs.getString("prod_kind"));
					prod.setProdTitle(rs.getString("prod_title"));
					prod.setProdPrice(rs.getInt("prod_price"));
					prod.setProdCount(rs.getShort("prod_count"));
					prod.setProdCom(rs.getString("prod_com"));
					prod.setProdImgName(rs.getString("prod_imgName"));
					prod.setProdImgRealName(rs.getString("prod_imgRealName"));
					prod.setRegDate(rs.getTimestamp("reg_date"));

					prodList.add(prod);
				} while (rs.next());
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
		return prodList;
	}

	public int getSearchProdsCount(String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from prod where prod_title like '%" + keyword + "%'");
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

	public Product getProd(int prodId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product prod = null;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("select * from prod where prod_id = ?");
			pstmt.setInt(1, prodId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
//				prod = new ProductDataBean();

				prod.setProdId(rs.getInt("prod_id"));
				prod.setProdDesti(rs.getString("prod_desti"));
				prod.setProdKind(rs.getString("prod_kind"));
				prod.setProdTitle(rs.getString("prod_title"));
				prod.setProdPrice(rs.getInt("prod_price"));
				prod.setProdCount(rs.getInt("prod_count"));
				prod.setProdCom(rs.getString("prod_com"));
				prod.setProdImgName(rs.getString("prod_imgName"));
				prod.setProdImgRealName(rs.getString("prod_imgRealName"));
				prod.setProdContent(rs.getString("prod_content"));
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
		return prod;
	}

	public void updateProd(Product prod, int prodId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;

		try {
//			conn = getConnection();

			if (prod.getProdImgName() == null) {
				sql = "update prod set prod_kind=?, prod_title=?, prod_price=?";
				sql += ", prod_count=?, prod_com=?, prod_content=?";
				sql += " where prod_id=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, prod.getProdKind());
				pstmt.setString(2, prod.getProdTitle());
				pstmt.setInt(3, prod.getProdPrice());
				pstmt.setInt(4, prod.getProdCount());
				pstmt.setString(5, prod.getProdCom());
				pstmt.setString(6, prod.getProdContent());
				pstmt.setInt(7, prodId);

				pstmt.executeUpdate();
			} else {
				sql = "update prod set prod_kind=?, prod_title=?, prod_price=?";
				sql += ", prod_count=?, prod_com=?, prod_imgName=?";
				sql += ", prod_imgRealName=?, prod_content=?";
				sql += " where prod_id=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, prod.getProdKind());
				pstmt.setString(2, prod.getProdTitle());
				pstmt.setInt(3, prod.getProdPrice());
				pstmt.setInt(4, prod.getProdCount());
				pstmt.setString(5, prod.getProdCom());
				pstmt.setString(6, prod.getProdImgName());
				pstmt.setString(7, prod.getProdImgRealName());
				pstmt.setString(8, prod.getProdContent());
				pstmt.setInt(9, prodId);

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

	public void deleteProd(int prodId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			conn = getConnection();

			pstmt = conn.prepareStatement("delete from prod where prod_id=?");
			pstmt.setInt(1, prodId);

			pstmt.executeUpdate();

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
	}
}
