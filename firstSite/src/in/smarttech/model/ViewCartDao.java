package in.smarttech.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewCartDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	public List<ViewCartDto> getData(int custid){
		
		ViewCartDto yo = null;
		List<ViewCartDto> imageList = new ArrayList<ViewCartDto>();
		try {
			String SQL = "select * from cart where custid=?";
			
			con = Model.getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, custid);
			res = pstmt.executeQuery();
			while (res.next()) {
				yo = new ViewCartDto();
				yo.setCustid(custid);
				yo.setPno(res.getInt("pno"));
				yo.setQty(res.getInt("qty"));
				yo.setTcost(res.getInt("tcost"));
				imageList.add(yo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return imageList;
	}
	
	
	public byte[] getImage(int pno) {
		byte[] pimg = null;
		try {
			String GET_IMAGE_QUERY ="select pimg from product where pno =? ";
			con = Model.getConnection();
			pstmt = con.prepareStatement(GET_IMAGE_QUERY);
			pstmt.setInt(1, pno);
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
	
}
