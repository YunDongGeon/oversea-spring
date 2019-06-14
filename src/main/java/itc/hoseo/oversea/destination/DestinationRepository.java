package itc.hoseo.oversea.destination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DestinationRepository {
	public List<Destination> getDesti();
	public String getKorName(Destination desti);
}
