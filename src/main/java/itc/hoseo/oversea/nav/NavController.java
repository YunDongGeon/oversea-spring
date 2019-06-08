package itc.hoseo.oversea.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/overseaDestiList")
	public String destiList() {
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
