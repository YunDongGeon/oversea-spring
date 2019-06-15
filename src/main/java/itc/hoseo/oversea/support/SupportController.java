package itc.hoseo.oversea.support;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SupportController {
	@Autowired
	SupportService service;
	
	@RequestMapping(path = "overseaSupport", method = RequestMethod.GET)
	public String qnaList(ModelMap m, Support support) {		
		m.put("qnaList", service.getQnaArticles(support));
		m.put("qnaCount", service.getQnaArticleCount(support));
		return "support/overseaQnaList";
	}
	@GetMapping("/overseaQnaCont")
	public String qnaCont(ModelMap m, Support support) {
		service.incQnaReadCount(support);
		m.put("qnaCont", service.getQnaArticleContent(support));
		return "support/overseaQnaCont";
	}
	@GetMapping("/overseaQnaWrite")
	public String qnaWrite(Support support) {
		return "support/overseaQnaWriteForm";
	}
	@PostMapping("/addQna")
	public String addQna(Support support) {		
		int number = 0;
		int reStep = support.getReStep();
		int reLevel = support.getReLevel();
		if (service.getMaxNum(support) > 0) {
			number = service.getMaxNum(support);
			number += 1;
		}else {
			number = 1;
		}
		if (support.getNum()!=0) {
			service.incQnaRe(support);
			support.setReStep(reStep+1);
			support.setReLevel(reLevel+1);
		}else {
			support.setRef(number);
			support.setReStep(0);
			support.setReLevel(0);
		}				
		support.setRegDate(new Timestamp(System.currentTimeMillis()));
		service.insertQnaArticle(support);
		return "redirect:/overseaSupport";
	}
	
}
