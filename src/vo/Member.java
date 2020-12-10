package vo;

import java.util.Date;

public class Member {
	private String id;
	private String pw;
	private String addr;
	private String tel;
	private String img;
	public Member(String id, String pw, String addr, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.tel = tel;
	}
	public Member(String id, String pw, String addr, String tel,String img) {
		super();
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.tel = tel;
		this.img = img;
	}
	
	public Member() {}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
