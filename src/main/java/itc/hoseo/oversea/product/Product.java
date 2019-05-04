package itc.hoseo.oversea.product;

import java.sql.Timestamp;

public class Product {
	private int prodId;
	private String prodDesti;
	private String prodKind;
	private String prodTitle;
	private int prodPrice;
	private int prodCount;
	private String prodCom;
	private String prodImgName;
	private String prodImgRealName;
	private String prodContent;
	private Timestamp regDate;
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdDesti() {
		return prodDesti;
	}
	public void setProdDesti(String prodDesti) {
		this.prodDesti = prodDesti;
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
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdCount() {
		return prodCount;
	}
	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	public String getProdCom() {
		return prodCom;
	}
	public void setProdCom(String prodCom) {
		this.prodCom = prodCom;
	}
	public String getProdImgName() {
		return prodImgName;
	}
	public void setProdImgName(String prodImgName) {
		this.prodImgName = prodImgName;
	}
	public String getProdImgRealName() {
		return prodImgRealName;
	}
	public void setProdImgRealName(String prodImgRealName) {
		this.prodImgRealName = prodImgRealName;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
}
