package itc.hoseo.oversea.destination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DestinationRepository {
	public List<Destination> getDesti() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Destination> destiList = null;
        try {
//            conn = getConnection();
                        
            pstmt = conn.prepareStatement("select * from destination order by destiKorName");
            rs = pstmt.executeQuery();
            
            destiList = new ArrayList<Destination>();
	        if (rs.next()) {	
	            do {
	            	Destination desti = new Destination();
	            	
	            	desti.setDestiName(rs.getString("destiName"));
	            	desti.setDestiKorName(rs.getString("destiKorName"));
	            	
	            	destiList.add(desti);
	            } while (rs.next()); 
	        }
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return destiList;
	}

	public String getKorName(String destiName) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String destiKorName = null;
        try {
//            conn = getConnection();
                        
            pstmt = conn.prepareStatement("select destiKorName from destination where destiName=?");
            pstmt.setString(1, destiName);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
				destiKorName = rs.getString("destiKorName");
			}
           
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return destiKorName;
	}

	public List<Destination> getCheapDesti() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Destination> destiList = null;
        try {
//            conn = getConnection();
                        
            pstmt = conn.prepareStatement("select * from destination order by destiMoney limit 3");
            rs = pstmt.executeQuery();
            
            destiList = new ArrayList<Destination>();
	        if (rs.next()) {	
	            do {
	            	Destination desti = new Destination();
	            	
	            	desti.setDestiName(rs.getString("destiName"));
	            	desti.setDestiKorName(rs.getString("destiKorName"));
	            	desti.setDestiMoney(rs.getFloat("destiMoney"));
	            	
	            	destiList.add(desti);
	            } while (rs.next()); 
	        }
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return destiList;
	}
}
