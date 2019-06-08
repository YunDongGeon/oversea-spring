package itc.hoseo.oversea.nav;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.collect.ImmutableList;

import itc.hoseo.oversea.destination.Destination;

@Controller
public class NavController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	@GetMapping("/overseaDestiList")
	public String destiList(ModelMap m, Destination dest) {
		List<Destination> destList = ImmutableList.of(
				new Destination("Hong Kong","홍콩",100.0f), 
				new Destination("Bang Kook","방콕",200.0f)); 
		
		m.put("destList" , destList);
		
		if(dest != null && StringUtils.isEmpty(dest.getDestiName()) == false) {
			m.put("destList", destList.stream()
				.filter(d -> {
					return d.getDestiKorName().contains(dest.getDestiName()) ||
							d.getDestiName().contains(dest.getDestiName());
				}).collect(Collectors.toList()));
		}
		
		
		
		return "shop/overseaDestiList";
	}
	@GetMapping("/overseaSupport")
	public String support() {
		return "support/overseaQnaList";
	}
	@GetMapping("/overseaExchange")
	public String exchange() {
		return "exchange/overseaExchangeInfoIbk";
	}
}
