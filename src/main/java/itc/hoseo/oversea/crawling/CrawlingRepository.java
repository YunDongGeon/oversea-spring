//package itc.hoseo.oversea.crawling;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class CrawlingRepository {
//	public static void getCurrencyRate(String cc, int i, String ccs) throws IOException {
//		String URL = "https://finance.yahoo.com/quote/" + cc + "KRW=X?p=" + cc;
//		Document doc = Jsoup.connect(URL).get();
//		Elements elem = doc.select("span[class=\"Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)\"]");
//		Elements elem2 = doc.select("span[data-reactid=\"36\"]");
//		Elements elem3 = doc.select("span[data-reactid=\"38\"]");
//		String str = elem.text();
//		String str2 = elem2.text();
//		String str3 = elem3.text();
//		str2 = str2.substring(7);
//		String money[] = new String[10];
//		String change[] = new String[10];
//		String change_time[] = new String[10];
//		money[i] = str;
//		change[i] = str2;
//		change_time[i] = str3;
//		CrawlingRepository dbpro = CrawlingRepository.getInstance();
//		dbpro.updatecrawling(cc, money[i], change[i], change_time[i]);
//		System.out.println(money[i]);
//		System.out.println(change[i]);
//		System.out.println(change_time[i]);
//
//	}
//
//	public int updatecrawling(String ccs, String money, String change, String change_time) throws IOException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql;
//		float d = 0;
//		int rs = 0;
//		money = money.replace(",", "");
//
//		try {
////			conn = getConnection();
//
//			d = Float.parseFloat(money);
//			conn.setAutoCommit(false);
//			sql = "update crawling set `money`=?, `change`=?, `change_time`=? where `nation`=?";
//			if (ccs.equals("JPY") || ccs.equals("VND")) {
//				d = d * 100;
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setFloat(1, d);
//				pstmt.setString(2, change);
//				pstmt.setString(3, change_time);
//				pstmt.setString(4, ccs);
//				rs = pstmt.executeUpdate();
//			} else {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setFloat(1, d);
//				pstmt.setString(2, change);
//				pstmt.setString(3, change_time);
//				pstmt.setString(4, ccs);
//				rs = pstmt.executeUpdate();
//			}
//			sql = "update destination set destiMoney=? where destiCountry=?";
//			if (ccs.equals("JPY") || ccs.equals("VND")) {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setFloat(1, d);
//				pstmt.setString(2, ccs);
//				rs = pstmt.executeUpdate();
//			} else {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setFloat(1, d);
//				pstmt.setString(2, ccs);
//				rs = pstmt.executeUpdate();
//			}
//			conn.setAutoCommit(true);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			if (pstmt != null)
//				try {
//					pstmt.close();
//				} catch (SQLException ex) {
//				}
//			if (conn != null)
//				try {
//					conn.close();
//				} catch (SQLException ex) {
//				}
//		}
//		return rs;
//	}
//
//	public void main() throws Exception {
//
//		String ccs = "USD,JPY,CNY,EUR,HKD,CAD,SGD,THB,PHP,VND";
//		String[] ccList = ccs.split(",");
//
//		final long timeInterval = 60000;
//		Runnable runnable = new Runnable() {
//			public void run() {
//				while (true) {
//					for (int i = 0; i < ccList.length; i++) {
//						try {
//							getCurrencyRate(ccList[i], i, ccs);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					try {
//						Thread.sleep(timeInterval);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		Thread thread = new Thread(runnable);
//		thread.start();
//	}
//}
