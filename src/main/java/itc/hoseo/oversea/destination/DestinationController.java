package itc.hoseo.oversea.destination;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.collect.ImmutableList;

@Controller
public class DestinationController {
	@Autowired
	DestinationService service;
	
	@GetMapping("/overseaDestiList")
	public String destiList(ModelMap m, Destination dest) {
		List<Destination> destList = service.getDesti();  
		
		m.put("destList" , destList);
		
		if(dest != null && StringUtils.isEmpty(dest.getDestiName()) == false) {
			m.put("destList", destList.stream().filter(d -> {
					return d.getDestiKorName().contains(dest.getDestiName()) ||
							d.getDestiName().contains(dest.getDestiName());
				}).collect(Collectors.toList()));
		}
		return "shop/overseaDestiList";
	}
}
