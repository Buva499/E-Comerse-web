package in.smarttech.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class ImageDao {
	private final String SQL = "select * from product";
	private final String GET_IMAGE_QUERY ="select pimg from product where pno =?";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	public List<ImageDto> getData(){
		ImageDto imageDto = null;
		List<ImageDto> imageList = new ArrayList<ImageDto>();
		try {
			con = Model.getConnection();
			pstmt = con.prepareStatement(SQL);
			res = pstmt.executeQuery();
			while (res.next()) {
				imageDto = new ImageDto();
				imageDto.setPno(res.getInt(1));
				imageDto.setPname(res.getString(2));
				imageDto.setCatagory(res.getString(3));
				imageDto.setPdetails(res.getString(4));
				imageDto.setPcost(res.getInt(5));
				imageList.add(imageDto);
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
