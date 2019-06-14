package itc.hoseo.oversea.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
}
