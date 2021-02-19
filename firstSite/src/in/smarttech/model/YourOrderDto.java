package in.smarttech.model;


public class YourOrderDto {
	private String fname;
	private String lname;
	private String phone;
	private String address;
	private int qty;
	private String modelno;
	private String size;
	private String other;
	private String paymode;
	private int custid;
	private int pno;
	private int tcost;
	private byte[] pimg;
	private byte[] cimg;
	
	
	public byte[] getPimg() {
		return pimg;
	}
	public void setPimg(byte[] pimg) {
		this.pimg = pimg;
	}
	public byte[] getCimg() {
		return cimg;
	}
	public void setCimg(byte[] cimg) {
		this.cimg = cimg;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getModelno() {
		return modelno;
	}
	public void setModelno(String modelno) {
		this.modelno = modelno;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	public int getTcost() {
		return tcost;
	}
	public void setTcost(int tcost) {
		this.tcost = tcost;
	}
	
	
}
