package itc.hoseo.oversea.destination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
	private String destiName;
	private String destiKorName;
	private float destiMoney;
	
}
