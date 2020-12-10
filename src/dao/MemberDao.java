package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	
	//회원 모두 검색
	public List<Member> selectAll(){
		List<Member>list=new ArrayList<Member>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from member";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Member member=new Member();
				member.setId(rs.getNString("id"));
				member.setPw(rs.getNString("pw"));
				member.setAddr(rs.getNString("addr"));
				member.setTel(rs.getString("tel"));
				list.add(member);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getStackTrace());
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	//아이디 중복 검사
	public boolean overappedId(String id){
		Member member=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag = false;
		String sql="select * from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				flag= true;
				System.out.println("아이디 중복");
			}else {
				System.out.println("아이디 중복없음");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return flag;
	}
	
	//회원가입
	public boolean insert(Member member){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into member(id,pw,addr,tel,img) values(?,?,?,?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setNString(1, member.getId());
			ps.setNString(2, member.getPw());
			ps.setNString(3, member.getAddr());
			ps.setString(4, member.getTel());
			ps.setString(5, member.getImg());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 입력성공");
			}else {
				System.out.println("데이터 입력실패");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	
	//회원정보 수정
	public boolean update(Member member){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update member set pw=?,addr=?,tel=? where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setNString(1, member.getPw());
			ps.setNString(2, member.getAddr());
			ps.setString(3, member.getTel());
			ps.setString(4, member.getId());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 갱신성공");
			}else {
				System.out.println("데이터 갱신실패");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	//회원삭제
	public boolean delete(String id){
		boolean flag=false;
		
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제 실패");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	public String LoadImg(String id) {
		String img="";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql="select img from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			rs.next();
			img = rs.getString(1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		
		return img;
	}
	public String LoadArea(String id) {
		String area="";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql="select addr from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			rs.next();
			area = rs.getString(1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		
		
		
		return area;
	}
	
	//로그인
	public int login(String id, String pw) {
		int n=-1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				if(pw.equals(rs.getString(1))) {
					n=1;
					System.out.println("로그인 성공");
				}else {
					n=0;
					System.out.println("패스워드 다름");
				}
			}else {
				System.out.println("아이디 없음");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return n;
	}
}