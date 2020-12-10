package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Reply;

public class ReplyDao {
	private ReplyDao() {}
	private static ReplyDao replyDao=new ReplyDao();
	public static ReplyDao getInstance() {
		return replyDao;
	}
	public List<Reply> selectReply(int bno){
		List<Reply> list=new ArrayList<Reply>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql="select * from reply where bno=?";
		
		try{
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			while(rs.next()){
				Reply reply=new Reply();
				reply.setRno(rs.getInt("rno"));
				reply.setBno(rs.getInt("bno"));
				reply.setid(rs.getString("id"));
				reply.setReplytext(rs.getString("replytext"));
				reply.setWritedate(rs.getTimestamp("writedate"));
				reply.setImg(rs.getString("img"));
				list.add(reply);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.close(conn,ps, rs);
		}
		return list;
	}

	
	public boolean insertReply(Reply reply){
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql="insert into reply(bno,id,replytext,img) values(?,?,?,?)";
		try{
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			String img = MemberDao.getInstance().LoadImg(reply.getid());
			System.out.println("이미지값:"+img);
			ps.setInt(1, reply.getBno());
			ps.setString(2,reply.getid());
			ps.setString(3, reply.getReplytext());
			ps.setString(4, img);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("댓글 입력 성공");
			}else {
				System.out.println("댓글 입력 실패");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.close(conn,ps);
		}
		return flag;
	}
	
	public Reply selectOne(String rno){
		Reply reply=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from reply where rno=?";
		try{
			conn=DBConn.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(rno));
			rs=pstmt.executeQuery();
			if(rs.next()){
				
				reply=new Reply();
				reply.setRno(rs.getInt("rno"));
				reply.setBno(rs.getInt("bno"));
				reply.setid(rs.getString("id"));
				reply.setReplytext(rs.getString("replytext"));
				reply.setImg(rs.getString("img"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.close(conn,pstmt);
		}
		return reply;
	}
	public boolean replyDelete(int rno){
		Connection conn = null;
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql="delete from reply where rno=?";
		try{
			conn=DBConn.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.executeUpdate();
			flag= true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.close(conn,pstmt);
		}
		return flag;
	}

}
