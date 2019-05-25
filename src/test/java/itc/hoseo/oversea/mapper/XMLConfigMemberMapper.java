package itc.hoseo.oversea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import itc.hoseo.oversea.member.Member;

public interface XMLConfigMemberMapper {
	public int addMember(Member member);	
	public String getMemberName(String email);	
	public int getMemberCount();	
}
