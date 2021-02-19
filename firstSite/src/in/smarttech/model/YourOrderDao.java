package in.smarttech.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class YourOrderDao {
	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	public List<YourOrderDto> getData(int custid){
		
		YourOrderDto yo = null;
		List<YourOrderDto> imageList = new ArrayList<YourOrderDto>();
		try {
			String SQL = "select * from firstwebsite.order where custid=?";
			
			con = Model.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, custid);
			res = pstmt.executeQuery();
			while (res.next()) {
				yo = new YourOrderDto();
				yo.setFname(res.getString("fname"));
				yo.setLname(res.getString("lname"));
				yo.setPhone(res.getString("phone"));
				yo.setAddress(res.getString("address"));
				yo.setQty(res.getInt("qty"));
				yo.setModelno(res.getString("modelno"));
				yo.setSize(res.getString("size"));
				yo.setOther(res.getString("other"));
				yo.setPaymode(res.getString("paymode"));
				yo.setCustid(res.getInt("custid"));
				yo.setPno(res.getInt("pno"));
				yo.setTcost(res.getInt("tcost"));
				yo.setPimg(res.getBytes("pimg"));
				yo.setCimg(res.getBytes("cimg"));
				imageList.add(yo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return imageList;
	}
	
	public byte[] getImageOld(int pno, int custid) {
		byte[] pimg = null;
		try {
			String GET_IMAGE_QUERY ="select pimg from firstwebsite.order where pno =? and custid=?";
			con = Model.getConnection();
			pstmt = con.prepareStatement(GET_IMAGE_QUERY);
			pstmt.setInt(1, pno);
			pstmt.setInt(2, custid);
			res = pstmt.executeQuery();
			if(res.next()) {
				pimg = res.getBytes(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pimg;
	}
	public byte[] getImageNew(int pno, int custid) {
		byte[] cimg = null;
		try {
			String GET_IMAGE_QUERY ="select cimg from firstwebsite.order where pno =? and custid=?";
			con = Model.getConnection();
			pstmt = con.prepareStatement(GET_IMAGE_QUERY);
			pstmt.setInt(1, pno);
			pstmt.setInt(2, custid);
			res = pstmt.executeQuery();
			if(res.next()) {
				cimg = res.getBytes(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cimg;
	}
}
