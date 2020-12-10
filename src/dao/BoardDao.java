package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Board;

public class BoardDao {

	private BoardDao() {}
	private static BoardDao instance=new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	
	
	//게시물 한 개 선택하는 메소드
	public Board selectOne(int bno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Board board = new Board();
		String sql="select * from board where bno=?";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			while(rs.next()) {
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setContext(rs.getString("context"));
				board.setId(rs.getString("id"));
				board.setD_date(rs.getDate("d_date"));
				board.setLikenum(rs.getInt("likenum"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReplycount(rs.getInt("replycount"));
				board.setImg(rs.getString("img"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				if(ps != null)ps.close();
				if(conn!=null)conn.close();
				if(rs != null)rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
		
		return board;
	}
	
	//조회수 올리는 메소드
	public boolean updateReadCount(int bno) {
		String sql="update board set readcount=readcount+1 where bno=?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("조회수 업데이트 성공");
			}else {
				System.out.println("조회수 업데이트 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.getStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
		
	}
	
	
	//게시물 수정 메소드
	public boolean updateBoard(Board board) {  //img수정해야함.
		Connection conn=null;
		boolean flag = false;
		PreparedStatement ps = null;
		String sql = "update board set title=?,context=?,price=? where bno=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContext());
			ps.setInt(3, board.getPrice());
			ps.setInt(4, board.getBno());
			int n = ps.executeUpdate();
			if(n==1) {
				flag = true;
				System.out.println("글 업데이트 성공");
			}else {
				System.out.println("글 업데이트 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return flag;
	}
	
	
	//게시물 작성 메소드
	public boolean insertBoard(Board board,String img1,String img2,String img3) {
		Connection conn=null;
		boolean flag = false;
		PreparedStatement ps =null;
		PreparedStatement ps2 =null;
		ResultSet rs = null;
		String sql = "insert into board(title,price,context,id,area,img) values(?,?,?,?,?,?)";
		String sql2 = "SELECT MAX(bno) FROM board";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setInt(2, board.getPrice());
			ps.setString(3, board.getContext());
			ps.setString(4, board.getId());			
			ps.setString(5, board.getArea());	
			ps.setString(6,board.getImg());
			int n = ps.executeUpdate();
			ps2 = conn.prepareStatement(sql2);
			rs = ps2.executeQuery();
			rs.next();
			int bno = rs.getInt("MAX(bno)");
			System.out.println("bno값: "+bno);
			if(ImgDao.getInstance().InsertImg(bno, img1)) {
				System.out.println("이미지1 입력 성공");
			}
			if(ImgDao.getInstance().InsertImg(bno, img2)) {
				System.out.println("이미지2 입력 성공");
			}
			if(ImgDao.getInstance().InsertImg(bno, img3)) {
				System.out.println("이미지3 입력 성공");
			}
			
			if(n == 1) {
				flag = true;
				System.out.println("데이터 입력 성공");
			}else {
				System.out.println("데이터 입력 실패");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.getStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	//게시물 삭제 메소드
	public boolean deleteBoard(int bno) {
		Connection conn = null;
		boolean flag = false;
		PreparedStatement ps = null;
		String sql = "delete from board where bno=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return flag;
		
	}
	
	//모든 게시물들 검색 메소드
	public List<Board> selectAll(){
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board order by bno desc";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setPrice(rs.getInt("price"));
				board.setStatus(rs.getString("status"));
				board.setContext(rs.getString("context"));
				board.setId(rs.getString("id"));
				board.setReadcount(rs.getInt("readcount"));
				board.setD_date(rs.getDate("d_date"));
				board.setReplycount(rs.getInt("replycount"));
				board.setLikenum(rs.getInt("likenum"));
				board.setArea(rs.getString("area"));
				board.setImg(rs.getString("img"));
				list.add(board);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return list;
		
		
	}
	
	public List<Board> selectAreaAll(String area){							//지역별로 나눠서 검색
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board where area=? order by bno desc";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,area);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setPrice(rs.getInt("price"));
				board.setStatus(rs.getString("status"));
				board.setContext(rs.getString("context"));
				board.setId(rs.getString("id"));
				board.setReadcount(rs.getInt("readcount"));
				board.setD_date(rs.getDate("d_date"));
				board.setReplycount(rs.getInt("replycount"));
				board.setLikenum(rs.getInt("likenum"));
				board.setArea(rs.getString("area"));
				board.setImg(rs.getString("img"));
				list.add(board);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return list;
		
		
	}
	
	
	public String Addlike(String id,int bno) {
		String result="fail";
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql="select bno from dip where id=?";
		String sql2 = "select likenum from board where bno=?";
		String sql3="update board set likenum=? where bno=?";
		String sql4="insert into dip(bno,id) values(?,?)";
				
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("bno")==bno) {
					result = "already";
				}
			}
			if(result.equals("fail"))
			{
			ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, bno);
			rs2 = ps2.executeQuery();
			rs2.next();
			int likenum = rs2.getInt("likenum");
			System.out.println("종아요수: "+likenum++);
			
			
			ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, likenum); 
			ps3.setInt(2, bno);
			int n = ps3.executeUpdate();
			if(n==1) {
				System.out.println("좋아요 숫자 추가 완료");
				
			}else {
				System.out.println("좋아요 숫자 추가 실패");
			}
			
			ps4 = conn.prepareStatement(sql4);
			ps4.setInt(1, bno); 
			ps4.setString(2, id);
			int n1 = ps4.executeUpdate();
			if(n1 == 1) {
				System.out.println("좋아요데이터 입력 성공");
				result="success";
			}else {
				System.out.println("좋아요데이터 입력 실패");
			}
			}
			
			
			System.out.println("결과:"+result);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				if(ps != null)ps.close();
				if(conn!=null)conn.close();
				if(ps2 != null)ps.close();
				if(ps3 != null)ps.close();
				if(rs != null)rs.close();
				if(rs2 != null)rs.close();
		
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
		return result;
		
		
	}
	
	public boolean deleteLike(int bno,String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs =null;
		boolean flag=false;
		
		String sql = "delete from dip where bno=? and id=?";
		String sql2 = "select likenum from board where bno=?";
		String sql3="update board set likenum=? where bno=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps2=conn.prepareStatement(sql2);
			ps3=conn.prepareStatement(sql3);
			ps.setInt(1, bno);
			ps.setString(2, id);
			int n = ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 삭제 성공");
				
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, bno);
				rs = ps2.executeQuery();
				rs.next();
				int likenum = rs.getInt("likenum");
				System.out.println("종아요수: "+likenum--);
				
				
				ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, likenum); 
				ps3.setInt(2, bno);
				int n1 = ps3.executeUpdate();
				if(n1==1) {
					System.out.println("좋아요 숫자 빼기 완료");
					
				}else {
					System.out.println("좋아요 숫자 빼기 실패");
				}
				
			}else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return flag;
		
		
	}
	
	public List<Board> DipSelectAll(String id){
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board,dip where board.bno = dip.bno and dip.id=?";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setPrice(rs.getInt("price"));
				board.setStatus(rs.getString("status"));
				board.setContext(rs.getString("context"));
				board.setId(rs.getString("id"));
				board.setReadcount(rs.getInt("readcount"));
				board.setD_date(rs.getDate("d_date"));
				board.setReplycount(rs.getInt("replycount"));
				board.setLikenum(rs.getInt("likenum"));
				board.setImg(rs.getString("img"));
				list.add(board);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
		return list;
		
		
	}
	//페이지별 리스트뽑기
	public List<Board> selectAll(int start, int end){
		String mysql_sql = "select * from board order by bno desc limit ?,?";
		//String oracle_sql= "select * from (select /*+ INDEX(BNO_IDX) */ rownum as rn, b1.* from board b1) where rn between start and end";
		
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(mysql_sql);
			pstmt.setInt(1,end);
			pstmt.setInt(2,start);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				//board.setContent(rs.getString("content"));
				board.setId(rs.getString("id"));
				board.setReadcount(rs.getInt("readcount"));
				board.setD_date(rs.getDate("d_date"));
				board.setPrice(rs.getInt("price"));
				board.setReplycount(rs.getInt("replycount"));
				board.setLikenum(rs.getInt("likenum"));
				board.setImg(rs.getString("img"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//게시물 숫자 세기
	public int getBoardCount(){
		int count=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select count(*) from board";
		try{
			conn=DBConn.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConn.close(conn, pstmt, rs);
		}
		return count;
	}
	
	//댓글숫자 업데이트
	public void updateReplyCount(String bno, int n){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="update board set replycount=replycount+? where bno=?";
		
		try{
			conn=DBConn.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, n);
			pstmt.setInt(2,Integer.parseInt(bno) );
			int i=pstmt.executeUpdate();
			System.out.println(i);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.close(conn,pstmt);
		}
	}
	
	
}
