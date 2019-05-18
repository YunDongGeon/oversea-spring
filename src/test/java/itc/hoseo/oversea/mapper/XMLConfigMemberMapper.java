package itc.hoseo.oversea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import itc.hoseo.oversea.member.Member;

public interface XMLConfigMemberMapper {
	public Member addMember(Member member);	
	public Member getMemberName(String email);	
	public Member getMemberCount();	
}
