package itc.hoseo.oversea.member;

import lombok.Data;

@Data
public class Member {
	private String name;
	private String email;
	private String passwd;
	private String phone;
	private String birth;
	private String zipcode;
	private String addr;
}
