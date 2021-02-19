package in.smarttech.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Part;

public class Model {
	
	//Admin Variables
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//Customer Variables
	private int custid;
	private String cname;
	private String cphone;
	private String cemail;
	private String cpassword;
	
	//Product Variables
	private int pno;
	private String pname;
	private String catagory;
	private String pdetails;
	private int pcost;
	byte[] pimg;
	private Part img;
	
	//Cart Variables
	private int qty;
	
	
	//Order Variables
	private String fname;
	private String lname;
	private String address;
	private String modelno;
	private String size;
	private String other;
	private Part cimg;
	private String paymode;
	private int tcost;
	private byte[] imgs;
	
	//Status Variable
	private String ostatus;
	
	
	
	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public byte[] getImgs() {
		return imgs;
	}

	public void setImgs(byte[] imgs) {
		this.imgs = imgs;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Part getCimg() {
		return cimg;
	}

	public void setCimg(Part cimg) {
		this.cimg = cimg;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public int getTcost() {
		return tcost;
	}

	public void setTcost(int tcost) {
		this.tcost = tcost;
	}

	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	//Image Retrive
	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public String getPdetails() {
		return pdetails;
	}

	public void setPdetails(String pdetails) {
		this.pdetails = pdetails;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public byte[] getPimg() {
		return pimg;
	}

	public void setPimg(byte[] pimg) {
		this.pimg = pimg;
	}

	PreparedStatement pstmt = null;
	static Connection con = null;
	ResultSet result =null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//Static Method for connection
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstwebsite","root","root123");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	//Loading the drivers
	public Model() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstwebsite","root","root123");
			System.out.println("Driver Loaded Successfully..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean signUp() {
		try {
			String s1="select email from admin where name=?";
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
			
			if(result.next()==true) {
				return false;
			}
			else {
				String s = "insert into admin(name, email, phone, password) values(?, ?, ?, ?)";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, phone);
				pstmt.setString(4, password);
				
				int x = pstmt.executeUpdate();
				if(x>0) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean login() {
		try {
			String s= "select * from admin where email =? and password=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			result = pstmt.executeQuery();
			
			if(result.next()==true) {
				return true;
			}
			else {
				return false;
			}
	
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean addProduct() {
		try {
			String s = "select pno from product where pno =?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, pno);
			result = pstmt.executeQuery();
			if(result.next()==true) {
				return false;
			}
			else {
				String s1 = "insert into product(pno, pname, catagory, pdetails, pcost, pimg) values(?, ?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(s1);
				pstmt.setInt(1, pno);
				pstmt.setString(2, pname);
				pstmt.setString(3, catagory);
				pstmt.setString(4, pdetails);
				pstmt.setInt(5, pcost);
				InputStream i = img.getInputStream();
				pstmt.setBlob(6, i);
				
				int up = pstmt.executeUpdate();
				if(up>=1) {
					return true;
				}
				else {
					return false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean remove() {
		try {
			String s = "select * from product where pno = ?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, pno);
			
			result = pstmt.executeQuery();
			if(result.next()==true) {
				String delete = "delete from product where pno = ?";
				pstmt = con.prepareStatement(delete);
				pstmt.setInt(1, pno);
				int x = pstmt.executeUpdate();
				
				if(x>=1) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateProduct() {
		try {
			String s = "select pno from product where pno =?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, pno);
			result = pstmt.executeQuery();
			if(result.next()==true) {
				String s1 = "update product set pname=?, catagory=?, pdetails =?, pcost=?, pimg=? where pno =?";
				pstmt = con.prepareStatement(s1);
				
				pstmt.setString(1, pname);
				pstmt.setString(2, catagory);
				pstmt.setString(3, pdetails);
				pstmt.setInt(4, pcost);
				InputStream i = img.getInputStream();
				pstmt.setBlob(5, i);
				pstmt.setInt(6, pno);
				int up = pstmt.executeUpdate();
				if(up>=1) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean adminProfile() {
		try {
			String sql = "select * from admin where email =? and password =?";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			result = pstmt.executeQuery();
			if(result.next()) {
				 name=result.getString("name");
				 phone = result.getString("phone");
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			
		}
		return false;
	}

	public boolean RegisterCustomer() {
		try {
			String sql_check = "select * from customer where custid=?";
			pstmt = con.prepareStatement(sql_check);
			pstmt.setInt(1, custid);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				return false;
			}
			else {
				String sql_add = "insert into customer(custid, cname, cphone, cemail, cpassword)"
						+ "values (?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql_add);
				pstmt.setInt(1, custid);
				pstmt.setString(2, cname);
				pstmt.setString(3, cphone);
				pstmt.setString(4, cemail);
				pstmt.setString(5, cpassword);
				
				int update = pstmt.executeUpdate();
				if(update>=1) {
					return true;
				}
				else {
					return false;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public boolean customerLogin() {
		try {
			String sql =" select * from customer where cemail=? and cpassword=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cemail);
			pstmt.setString(2, cpassword);
			
			result = pstmt.executeQuery();
			
			if(result.next()) {
				custid = result.getInt("custid");
				cphone = result.getString("cphone");
				cname = result.getString("cname");
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean forgetPassCustomer() {
		try {
			String change = "select cemail,cphone from customer where cemail =?";
			pstmt = con.prepareStatement(change);
			pstmt.setString(1, cemail);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				cphone = result.getString("cphone");
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean changeCustomerPassword() {
		try {
			String change = "select * from customer where cemail=?";
			pstmt = con.prepareStatement(change);
			pstmt.setString(1, cemail);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				String update = "update customer set cpassword =? where cemail=?";
				pstmt =con.prepareStatement(update);
				pstmt.setString(1, cpassword);
				pstmt.setString(2, cemail);
				
				int cu = pstmt.executeUpdate();
				if(cu>=1) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean getProductDetails() {
		try {
			String sql ="select * from product where pno =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pno);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean getImage() {
		try
		{
		String sql="SELECT * FROM product where pno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, pno);
		
		ResultSet res = pstmt.executeQuery();
		if(res.next())
		{
			pimg = res.getBytes("pimg");
			pcost = res.getInt("pcost");
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean cartLogin() {
		try {
			String sql =" select * from customer where cemail=? and cpassword=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cemail);
			pstmt.setString(2, cpassword);
			
			result = pstmt.executeQuery();
			
			if(result.next()) {
				custid = result.getInt("custid");
				cphone = result.getString("cphone");
				cname = result.getString("cname");
				
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean addCart() {
		try {
			String s = "insert into cart(custid, pno, qty, tcost) values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			pstmt.setInt(3, qty);
			pstmt.setInt(4, tcost);
			int x = pstmt.executeUpdate();
			if(x>=1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean getCartImage() {
		try
		{
		String sql="SELECT * FROM product where pno=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, pno);
		ResultSet res = pstmt.executeQuery();
		if(res.next())
		{
			pimg = res.getBytes("pimg");
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean checkoutLogin() {
		try {
			String sql =" select * from customer where cemail=? and cpassword=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cemail);
			pstmt.setString(2, cpassword);
			
			result = pstmt.executeQuery();
			
			if(result.next()) {
				custid = result.getInt("custid");
				cphone = result.getString("cphone");
				cname = result.getString("cname");
				
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public String getCheckoutCatagory() {
		try {
			String check ="select catagory, pcost from product where pno =?";
			pstmt = con.prepareStatement(check);
			pstmt.setInt(1, pno);
			result = pstmt.executeQuery();
			if(result.next()) {
				catagory = result.getString("catagory");
				pcost = result.getInt("pcost");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return catagory;
	}

	public boolean placeProduct() {
		try {
			String check = "select * from firstwebsite.order where custid =? and pno =?";
			pstmt = con.prepareStatement(check);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			result = pstmt.executeQuery();
			if(result.next()) {
				//Duplicate Product
				String update = "update firstwebsite.order set fname=?, lname=?, phone=?, address=?, qty=?, modelno=?, "
						+ "size=?, other=?, cimg=?, paymode=?, pimg=?, tcost=? where custid=? and pno=?";
				
				pstmt= con.prepareStatement(update);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, phone);
				pstmt.setString(4, address);
				pstmt.setInt(5, qty);
				if(modelno!=null  && cimg.getSize()==0) {
					pstmt.setString(6, modelno);
					pstmt.setString(7, null);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setBytes(11, pimg);
					pstmt.setInt(12, tcost);
					pstmt.setInt(13, custid);
					pstmt.setInt(14, pno);
					int x = pstmt.executeUpdate();
					//System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
						
					}
					else {
						return false;
					}
				}
				else if(modelno!=null  && size==null && other==null && cimg.getSize()!=0){
					pstmt.setString(6, modelno);
					pstmt.setString(7, null);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setBytes(11, null);
					pstmt.setInt(12, tcost);
					pstmt.setInt(13, custid);
					pstmt.setInt(14, pno);
					int x = pstmt.executeUpdate();
					//System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}//Update End
			else {
				//First Purchase
				String query = "insert into firstwebsite.order(fname,lname,phone,address,qty,modelno,size,other,cimg,paymode,custid,pno,pimg,tcost)"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, phone);
				pstmt.setString(4, address);
				pstmt.setInt(5, qty);
				if(modelno!=null  && cimg.getSize()==0) {
					pstmt.setString(6, modelno);
					pstmt.setString(7, null);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setInt(11, custid);
					pstmt.setInt(12, pno);
					pstmt.setBytes(13, pimg);
					pstmt.setInt(14, tcost);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else if(modelno!=null  && size==null && other==null && cimg.getSize()!=0){
					pstmt.setString(6, modelno);
					pstmt.setString(7, null);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setInt(11, custid);
					pstmt.setInt(12, pno);
					pstmt.setBytes(13, null);
					pstmt.setInt(14, tcost);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean placeProductTshirt() {
		try {
			String check = "select * from firstwebsite.order where custid =? and pno =?";
			pstmt = con.prepareStatement(check);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				String update = "update firstwebsite.order set fname=?, lname=?, phone=?, address=?, qty=?, modelno=?, "
						+ "size=?, other=?, cimg=?, paymode=?, pimg=?, tcost=? where custid=? and pno=?";
				
				pstmt = con.prepareStatement(update);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, phone);
				pstmt.setString(4, address);
				pstmt.setInt(5, qty);
				if(size!=null  && cimg.getSize()==0) {
					pstmt.setString(6, null);
					pstmt.setString(7, size);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setBytes(11, pimg);
					pstmt.setInt(12, tcost);
					pstmt.setInt(13, custid);
					pstmt.setInt(14, pno);
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else if(modelno==null  && size!=null && other==null && cimg.getSize()!=0){
					pstmt.setString(6, null);
					pstmt.setString(7, size);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setBytes(11, null);
					pstmt.setInt(12, tcost);
					pstmt.setInt(13, custid);
					pstmt.setInt(14, pno);
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
				
			}//update end
			else {
				String query = "insert into firstwebsite.order(fname,lname,phone,address,qty,modelno,size,other,cimg,paymode,custid,pno,pimg,tcost)"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, phone);
				pstmt.setString(4, address);
				pstmt.setInt(5, qty);
				if(size!=null  && cimg.getSize()==0) {
					pstmt.setString(6, null);
					pstmt.setString(7, size);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setInt(11, custid);
					pstmt.setInt(12, pno);
					pstmt.setBytes(13, pimg);
					pstmt.setInt(14, tcost);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else if(modelno==null  && size!=null && other==null && cimg.getSize()!=0){
					pstmt.setString(6, null);
					pstmt.setString(7, size);
					pstmt.setString(8, null);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setInt(11, custid);
					pstmt.setInt(12, pno);
					pstmt.setBytes(13, null);
					pstmt.setInt(14, tcost);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}//old end
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public boolean getProductPrice() {
		try {
			String getPrice = "select pcost from product where pno =?";
			pstmt = con.prepareStatement(getPrice);
			pstmt.setInt(1, pno);
			result = pstmt.executeQuery();
			if(result.next()) {
				pcost = result.getInt("pcost");
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean placeProductOther() {
		try {
			String check = "select * from firstwebsite.order where custid =? and pno =?";
			pstmt = con.prepareStatement(check);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				String update = "update firstwebsite.order set fname=?, lname=?, phone=?, address=?, qty=?, modelno=?, "
						+ "size=?, other=?, cimg=?, paymode=?, pimg=?, tcost=? where custid=? and pno=?";
				
				pstmt = con.prepareStatement(update);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, phone);
				pstmt.setString(4, address);
				pstmt.setInt(5, qty);
				if(other!=null  && cimg.getSize()==0) {
					pstmt.setString(6, null);
					pstmt.setString(7, null);
					pstmt.setString(8, other);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setBytes(11, pimg);
					pstmt.setInt(12, tcost);
					pstmt.setInt(13, custid);
					pstmt.setInt(14, pno);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else if(modelno==null  && size==null && other!=null && cimg.getSize()!=0){
					pstmt.setString(6, null);
					pstmt.setString(7, null);
					pstmt.setString(8, other);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setBytes(11, null);
					pstmt.setInt(12, tcost);
					pstmt.setInt(13, custid);
					pstmt.setInt(14, pno);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}//update end
			else {
				String query = "insert into firstwebsite.order(fname,lname,phone,address,qty,modelno,size,other,cimg,paymode,custid,pno,pimg,tcost)"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setString(3, phone);
				pstmt.setString(4, address);
				pstmt.setInt(5, qty);
				if(other!=null  && cimg.getSize()==0) {
					pstmt.setString(6, null);
					pstmt.setString(7, null);
					pstmt.setString(8, other);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setInt(11, custid);
					pstmt.setInt(12, pno);
					pstmt.setBytes(13, pimg);
					pstmt.setInt(14, tcost);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else if(modelno==null  && size==null && other!=null && cimg.getSize()!=0){
					pstmt.setString(6, null);
					pstmt.setString(7, null);
					pstmt.setString(8, other);
					InputStream is = cimg.getInputStream();
					pstmt.setBlob(9, is);
					pstmt.setString(10, paymode);
					pstmt.setInt(11, custid);
					pstmt.setInt(12, pno);
					pstmt.setBytes(13, null);
					pstmt.setInt(14, tcost);
					
					int x = pstmt.executeUpdate();
					System.out.println(x);
					if(x>=1) {
						boolean st = status();
						if(st==true) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}//old end
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getOrderedProductDetails() {
		try {
			String sql ="select * from firstwebsite.order where pno =? and custid =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pno);
			pstmt.setInt(2, custid);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				tcost = result.getInt("tcost");
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean getOrderedImage() {
		try
		{
		String sql="SELECT * FROM firstwebsite.order where pno=? and custid=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, pno);
		pstmt.setInt(2, custid);
		ResultSet res = pstmt.executeQuery();
		if(res.next())
		{
			pimg = res.getBytes("pimg");
			if(pimg == null) {
				imgs = res.getBytes("cimg");
				return true;
			}
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean cancleOrder() {
		try {
			String sql = "delete from firstwebsite.order where custid=? and pno =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			int eu = pstmt.executeUpdate();
			if(eu>=1) {
				String status = "delete from status where custid=? and pno=?";
				pstmt  = con.prepareStatement(status);
				pstmt.setInt(1, custid);
				pstmt.setInt(2, pno);
				int e = pstmt.executeUpdate();
				if(e>=1) {
					return true;
				}
				else {
					return false;
				}
				
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean removeCartProduct() {
		try {
			String rem = "delete from cart where custid =? and pno =?";
			pstmt = con.prepareStatement(rem);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			
			int eu = pstmt.executeUpdate();
			
			if(eu>=1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean status() {
		try {
			String select = "select * from status where custid=? and pno=?";
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			result = pstmt.executeQuery();
			if(result.next()) {
				return true;
			}
			else {
				String add = "insert into status (custid, pno, status) values (?, ?, ?)";
				pstmt = con.prepareStatement(add);
				pstmt.setInt(1, custid);
				pstmt.setInt(2, pno);
				pstmt.setString(3, "Your Order Is Pending...");
				
				int eu = pstmt.executeUpdate();
				if(eu>=1) {
					return true;
				}
				else {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean getStatus() {
		try {
			String get = "select status from status where custid=? and pno=?";
			pstmt = con.prepareStatement(get);
			pstmt.setInt(1, custid);
			pstmt.setInt(2, pno);
			
			result = pstmt.executeQuery();
			if(result.next()) {
				ostatus = result.getString("status");
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	
	}

	public boolean adminStatusUpdate() {
		try {
			String ustatus = "update status set status=? where custid=? and pno=?";
			pstmt = con.prepareStatement(ustatus);
			String status = ostatus;
			pstmt.setString(1, status);
			pstmt.setInt(2, custid);
			pstmt.setInt(3, pno);
			int eu = pstmt.executeUpdate();
			
			if(eu>=1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateProfile() {
		try {
			String uprofile = "update customer set cname=?, cphone=?, cemail=?, cpassword=? where custid=?";
			pstmt = con.prepareStatement(uprofile);
			pstmt.setString(1, cname);
			pstmt.setString(2, cphone);
			pstmt.setString(3, cemail);
			pstmt.setString(4, cpassword);
			pstmt.setInt(5, custid);
			
			int up = pstmt.executeUpdate();
			if(up>=1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
}
