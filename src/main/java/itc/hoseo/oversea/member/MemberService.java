package itc.hoseo.oversea.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepo;
	
	public boolean inserMember(Member member) {
		return memberRepo.insertMember(member);
	}
	
	public boolean emailCheck(String email) {
		return memberRepo.emailCheck(email) > 0 ? true : false;
	}
	
	public boolean loginCheck(String email, String passwd) {
		return memberRepo.loginCheck(email, passwd) == 2 ? true : false;
	}
	
	public String findId(Member member) {
		return memberRepo.findId(member); 
	}
	public List<Member> list() {
		return memberRepo.list();
	}
}
