package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImgDao {
	private ImgDao() {}
	private static ImgDao imgDao = new ImgDao();
	public static ImgDao getInstance() {
		return imgDao;
	}
	
	public List<String> LoadBoardImg(int bno) {
		List<String> imgList = new ArrayList<String>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql="select img from image where bno=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			while(rs.next()){
				imgList.add(rs.getString("img"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		
		return imgList;
	}
	
	public boolean InsertImg(int bno, String img) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag= false;
		String sql = "insert into image(bno,img) values(?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.setString(2, img);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("이미지 입력성공");
			}else {
				System.out.println("데이터 입력실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}

}
