package itc.hoseo.oversea.member;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	
	@Autowired
	DataSource ds;
	JdbcTemplate template;
		
	public boolean insertMember(Member member){
		StringBuffer sb = new StringBuffer(member.getPh1());
		sb.append(member.getPh2());
		sb.append(member.getPh3());
		String phone = sb.toString();
		return template.update("insert into user values(?,?,?,?,?,?,?,?)",
				member.getName(), member.getEmail(), member.getPasswd(), phone, member.getBirth(),
				member.getZipcode(), member.getAddr1(), member.getAddr2())==1?true : false;
	}
		 
	public int emailCheck(String email){
		int rst = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
//			   conn = getConnection();
			String sql = "select * from user where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
		    rs = ps.executeQuery();
		    if(rs.next()){
		    	rst = 1;
		    }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return rst;
	}
		 
	public int loginCheck(String email, String passwd){
		int rst = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
//			   conn = getConnection();
			String sql = "select * from user where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()){
				String DBpass = rs.getString("passwd");
				if((DBpass.trim()).equals((passwd.trim()))){
					rst=2;  
				}else{
					rst=1;  
				}
			}  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (ps != null)
				try {
					ps.close();
					} catch (SQLException ex) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException ex) {
					}
		}
		return rst;
	}
		 
	public String findId(Member member){
		String email = null;
		String phone = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer(member.getPh1());
		sb.append(member.getPh2());
		sb.append(member.getPh3());
		phone = sb.toString();
		try{
//				   conn = getConnection();
			String sql = "select email from user where name=? and phone=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, phone);
			rs = ps.executeQuery();
			while(rs.next()){
				email = rs.getString("email");
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}	
		return email;
	}
		
	public String findPw(Member member){
		String pw = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer(member.getPh1());
		sb.append(member.getPh2());
		sb.append(member.getPh3());
		String phone = sb.toString();
		try{
//				   conn = getConnection();
			String sql = "select passwd from user where email=? and name=? and phone=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getEmail());
			ps.setString(2, member.getName());
			ps.setString(3, phone);
			rs = ps.executeQuery();
			while(rs.next()){
				pw = rs.getString("passwd");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return pw;
	}
		
	public String getName(String email, String pw) {
		String getName = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
//				conn = getConnection();
			String sql = "select name from user where email=? and passwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pw);
			rs = ps.executeQuery();
				
			while(rs.next()){
				getName = rs.getString("name");
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return getName;
	}
	public Member getMember(String email) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
//	    	    	 conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from user where email = ?");
	        pstmt.setString(1, email);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	member =  new Member();
	        	member.setEmail(rs.getString("email"));
	        	member.setPasswd(rs.getString("passwd"));
	        	member.setName(rs.getString("name"));
	        	member.setPh1(rs.getString("Phone").substring(0, 3));
	        	member.setPh2(rs.getString("Phone").substring(3, 7));
	        	member.setPh3(rs.getString("Phone").substring(7, 11));
	        	member.setBirth(rs.getString("birth"));
	        	member.setZipcode(rs.getString("zipcode"));
	        	member.setAddr1(rs.getString("addr1"));
	        	member.setAddr2(rs.getString("addr2")); 
	        }
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if (rs != null) 
				try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) 
				try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) 
				try { conn.close(); } catch(SQLException ex) {}
	    }
		return member;
	}
	public int editMember(String phone, String zipcode, String addr1, String addr2, String email) throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int rs = 0;
	    try {
//	        	 conn = getConnection();
	    	String sql = "UPDATE user "
	    			+ "SET phone=?, zipcode=?, addr1=?, addr2=? "
		       		+ "where email=?";
		
	    	pstmt = conn.prepareStatement(sql);
	    	pstmt.setString(1, phone);
	    	pstmt.setString(2, zipcode);
	    	pstmt.setString(3, addr1);
		    pstmt.setString(4, addr2);
		    pstmt.setString(5, email);
		
		    rs = pstmt.executeUpdate();

	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }finally {
	    	if (pstmt != null) 
	    		try { pstmt.close(); } catch(SQLException ex) {}
	    	if (conn != null) 
	    		try { conn.close(); } catch(SQLException ex) {}
	    }
	    return rs;
	}
	public List<Member> list() {
		return new JdbcTemplate(ds).query("SELECT * FROM member;", new BeanPropertyRowMapper(Member.class));
	}
}
