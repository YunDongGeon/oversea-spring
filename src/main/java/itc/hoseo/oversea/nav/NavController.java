package itc.hoseo.oversea.nav;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.collect.ImmutableList;

import itc.hoseo.oversea.destination.Destination;
import itc.hoseo.oversea.destination.DestinationService;
import itc.hoseo.oversea.member.MemberService;

@Controller
public class NavController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
			
	@GetMapping("/overseaExchange")
	public String exchange() {
		return "exchange/overseaExchangeInfoIbk";
	}
}
