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
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
	
	public int addMember(Member member);
	public Member getMember(Member m);
	public String getMemberName(String email);
	public List<Member> getAllMember();
	public int getMemberCount();
	public int updateMember(Member member);
	public int delMember(Member member);
		
}
