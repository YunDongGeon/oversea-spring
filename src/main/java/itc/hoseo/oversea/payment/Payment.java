package itc.hoseo.oversea.payment;

import java.sql.Timestamp;

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
	public Long getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(Long buy_id) {
		this.buy_id = buy_id;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getSubsName() {
		return subsName;
	}
	public void setSubsName(String subsName) {
		this.subsName = subsName;
	}
	public String getSubsPhone() {
		return subsPhone;
	}
	public void setSubsPhone(String subsPhone) {
		this.subsPhone = subsPhone;
	}
	public Timestamp getSubsDate() {
		return subsDate;
	}
	public void setSubsDate(Timestamp subsDate) {
		this.subsDate = subsDate;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdKind() {
		return prodKind;
	}
	public void setProdKind(String prodKind) {
		this.prodKind = prodKind;
	}
	public String getProdTitle() {
		return prodTitle;
	}
	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public byte getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(byte buyAmount) {
		this.buyAmount = buyAmount;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	public Timestamp getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Timestamp buyDate) {
		this.buyDate = buyDate;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getSanction() {
		return sanction;
	}
	public void setSanction(String sanction) {
		this.sanction = sanction;
	}	
	
	
	
}
