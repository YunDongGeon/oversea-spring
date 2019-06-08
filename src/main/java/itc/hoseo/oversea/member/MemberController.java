package itc.hoseo.oversea.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@PostMapping("/overseaJoin")
	public String join(Member m) {
		if(service.addMember(m)) {			
			return "redirect:/";
		}
		return "redirect:/overseaJoin";
	}
}
