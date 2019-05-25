package itc.hoseo.oversea.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/overseaFindId")
	public String findId() {
		return "loginMenu/overseaFindId";
	}
	@GetMapping("/overseaFindPasswd")
	public String findPw() {
		return "loginMenu/overseaFindPasswd";
	}
	@GetMapping("/overseaJoinForm")
	public String join() {
		return "loginMenu/overseaJoinForm";
	}
}
