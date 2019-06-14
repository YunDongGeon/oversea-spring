package itc.hoseo.oversea.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {
	@Autowired
	SupportService service;
	
	@GetMapping("/overseaSupport")
	public String qnaList(ModelMap m, Support support) {	
		support.setStart(0);
		support.setEnd(5);
		List<Support> qnaList = service.getQnaArticles(support);
			
		m.put("qnaList", qnaList);		
		
		return "support/overseaQnaList";
	}
	
}
