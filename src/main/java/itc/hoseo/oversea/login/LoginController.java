package itc.hoseo.oversea.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import itc.hoseo.oversea.member.Member;
import itc.hoseo.oversea.member.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/overseaFindId")
	public String findId() {
		return "loginMenu/overseaFindId";
	}
	@GetMapping("/overseaFindPasswd")
	public String findPw() {
		return "loginMenu/overseaFindPasswd";
	}	
	@GetMapping("overseaLoginForm")
	public String login() {
		return "navMenu/overseaLoginForm";
	}	
	@PostMapping("overseaLoginForm")
	public String loginById(Member m, HttpSession session) {
		if(service.isValidUser(m)) {
			m = service.getMember(m);
			session.setAttribute("mem", m);			
			return "redirect:/";
		}
		return "redirect:navMenu/overseaLoginForm";
	}
	@GetMapping("overseaUserForm")
	public String userFrom() {
		return "userMenu/overseaUserForm";
	}
	@GetMapping("overseaLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/overseaJoinForm")
	public String join() {
		return "loginMenu/overseaJoinForm";
	}
}
