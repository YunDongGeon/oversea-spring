package itc.hoseo.oversea.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
	@Autowired
	SupportRepository supportRepositoty;
	
	public List<Support> getQnaArticles(Support support) {
		return supportRepositoty.getQnaArticles(support);
	}
	public int getQnaArticleCount(Support support) {
		int count = supportRepositoty.getQnaArticleCount(support);
		return count;
	}
	public Support getQnaArticleContent(Support support) {
		return supportRepositoty.getQnaArticleContent(support);
	}}
