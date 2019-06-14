package itc.hoseo.oversea.destination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itc.hoseo.oversea.member.Member;

@Service
public class DestinationService {

	@Autowired
	private DestinationRepository destiRepository;
	
	public List<Destination> getDesti() {
		return destiRepository.getDesti();
	}
	
	public String getKorName(Destination desti) {
		return destiRepository.getKorName(desti);
	}
}
