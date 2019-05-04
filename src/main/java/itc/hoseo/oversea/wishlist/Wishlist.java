package itc.hoseo.oversea.wishlist;

public class Wishlist {
	private int wishlist_id;
	private String wisher;
	private int prod_id;
	private String prod_kind;
	private String prod_image;
	private String prod_com;
	private int prod_price;
	
	public String getProd_com() {
		return prod_com;
	}
	public void setProd_com(String prod_com) {
		this.prod_com = prod_com;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_kind() {
		return prod_kind;
	}
	public void setProd_kind(String prod_kind) {
		this.prod_kind = prod_kind;
	}
	private String prod_title;
	public int getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
	}
	public String getWisher() {
		return wisher;
	}
	public void setWisher(String wisher) {
		this.wisher = wisher;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_title() {
		return prod_title;
	}
	public void setProd_title(String prod_title) {
		this.prod_title = prod_title;
	}
	public String getProd_image() {
		return prod_image;
	}
	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}
	
}
