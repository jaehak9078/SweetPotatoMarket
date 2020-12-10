package vo;

import java.sql.Date;

public class Board {

	private int bno;
	private String title;
	private String status;
	private String context;
	private int price;
	private String id;
	private int likenum;
	private Date d_date;
	private int replycount;
	private int readcount;
	private String area;
	private String img;
	
	public Board() {}
	public Board(int bno, String title, String status, String context, int price, String id, int likenum,
			Date d_date,String img) {
		super();
		this.bno = bno;
		this.title = title;
		this.status = status;
		this.context = context;
		this.price = price;
		this.id = id;
		this.likenum = likenum;
		this.d_date = d_date;
		this.img = img;
	}
	public Board(int bno, String title, String status, String context, int price, String id, int likenum,
			Date d_date, int replycount, int readcount, String img) {
		super();
		this.bno = bno;
		this.title = title;
		this.status = status;
		this.context = context;
		this.price = price;
		this.id = id;
		this.likenum = likenum;
		this.d_date = d_date;
		this.replycount = replycount;
		this.readcount = readcount;
		this.img = img;
	}
	public Board(int bno, String title, String status, String context, int price, String id, String area,String img) {
		super();
		this.bno = bno;
		this.title = title;
		this.status = status;
		this.context = context;
		this.price = price;
		this.id = id;
		this.area= area;
		this.img = img;
	}
	
	public Board(String title,int price, String context,  String id,String area,String img) {
		super();
		this.title = title;
		this.context = context;
		this.price = price;
		this.id = id;
		this.area = area;
		this.img = img;
	}
	
	public Board(int bno, String title, int price, String context, String id, String area,String img) {
		super();
		this.bno = bno;
		this.title = title;
		this.price = price;
		this.context = context;
		this.id = id;
		this.area = area;
		this.img = img;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLikenum() {
		return likenum;
	}
	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}
	public Date getD_date() {
		return d_date;
	}
	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
	
}
