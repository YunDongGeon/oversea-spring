package itc.hoseo.oversea.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepositoty;
	
	public boolean addMember(Member member) {
		return memberRepositoty.addMember(member)==1;
	}
	public String getMemberName(String email) {		
		String memName = memberRepositoty.getMemberName(email);		
		return memName;
	};
	
	public boolean isValidUser(Member m) {
		return memberRepositoty.getMember(m) != null;
	}
	
	public List<Member> getAllMember(){
		return memberRepositoty.getAllMember();
	}
	public int getMemberCount() {
		return memberRepositoty.getMemberCount();
	};
	public boolean updateMember(Member member) {		
		return memberRepositoty.updateMember(member) == 1;
	};
	public boolean delMember(Member member) {
		return memberRepositoty.delMember(member) == 1;
	};
		
}
