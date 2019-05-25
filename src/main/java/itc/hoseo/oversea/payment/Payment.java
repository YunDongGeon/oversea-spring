package itc.hoseo.oversea.payment;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class Payment {
	private Long buy_id;
	private String buyerEmail;
	private String subsName; 
	private String subsPhone;
	private Timestamp subsDate;
	private int prodId;
	private String prodKind;
	private String prodTitle;
	private int buyPrice;
	private byte buyAmount;
	private String prodImage;
	private Timestamp buyDate;
	private String payment;
	private String sanction;	
}
