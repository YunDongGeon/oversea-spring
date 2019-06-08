package itc.hoseo.oversea.exchange;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExchangeController {
	
	@GetMapping("/overseaExchangeIbk")
	public String ibk() {
		return "exchange/overseaExchangeInfoIbk";
	}
	
	@GetMapping("/overseaExchangeKb")
	public String kb() {
		return "exchange/overseaExchangeInfoKb";
	}
	
	@GetMapping("/overseaExchangeNh")
	public String nh() {
		return "exchange/overseaExchangeInfoNh";
	}
	
	@GetMapping("/overseaExchangeSh")
	public String sh() {
		return "exchange/overseaExchangeInfoSh";
	}
	
	@GetMapping("/overseaExchangeWoori")
	public String woori() {
		return "exchange/overseaExchangeInfoWoori";
	}
}
