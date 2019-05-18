package itc.hoseo.oversea;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import itc.hoseo.oversea.mapper.XMLConfigMemberMapper;
import itc.hoseo.oversea.member.Member;

public class MybatisXMLConfigTest {
	private SqlSessionFactory sessionFactory;
	
	@Before
	public void init() throws Exception{
		final String ddl = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/schema.sql").toURI()))
				.stream()
				.collect(Collectors.joining("\n"));
		
		//final String data = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/data.sql").toURI()))
		//		.stream()
		//		.collect(Collectors.joining());
				
		try(Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
				Statement stmt = con.createStatement();) {			
			stmt.execute(ddl);
		//	stmt.execute(data);
		}
		
		sessionFactory =  new SqlSessionFactoryBuilder().build(
				Resources.getResourceAsStream("mybatis/mybatis-config.xml"));
		
	}
	
	@Test
	public void test() throws Exception {
		try(SqlSession session = sessionFactory.openSession()){
			XMLConfigMemberMapper memberMapper = session.getMapper(XMLConfigMemberMapper.class);
			Member mem = new Member();
			mem.setName("관리자"); 
			mem.setEmail("admin"); 
			mem.setPasswd("admin"); 
			mem.setPhone("01000000000"); 
			mem.setBirth("00000000");
			mem.setZipcode("00000"); 
			mem.setAddr("서울");
			memberMapper.addMember(mem);
			assertEquals(1, memberMapper.getMemberCount());
//			assertEquals("관리자", memberMapper.getMemberName("admin"));
		}
	}
}
