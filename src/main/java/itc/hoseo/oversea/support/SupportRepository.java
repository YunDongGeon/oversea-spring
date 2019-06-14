package itc.hoseo.oversea.support;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportRepository {
	public boolean insertQnaArticle(Support support);
	public int getQnaArticleCount(Support support);
	public List<Support> getQnaArticles(Support support);
	public Support getQnaArticle(Support support);
	public Support updateGetQnaArticle(Support support);
	public boolean updateQnaArticle(Support support);
}
