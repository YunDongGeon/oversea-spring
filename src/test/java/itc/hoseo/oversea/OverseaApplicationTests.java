package itc.hoseo.oversea;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import itc.hoseo.oversea.member.Member;
import itc.hoseo.oversea.member.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OverseaApplicationTests {
	@Autowired
	MemberService memService;	
	@Test
	public void test() throws Exception{		
		assertEquals("관리자", memService.getMemberName("admin"));
	}
}
