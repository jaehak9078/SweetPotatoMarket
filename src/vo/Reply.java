package vo;

import java.util.Date;

public class Reply {
	private int rno;
	private int bno;
	private String id;
	private String replytext;
	private Date writedate;
	private String img;
	
	public Reply() {}

	public Reply(int rno, int bno, String id, String replytext, Date writedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.id = id;
		this.replytext = replytext;
		this.writedate = writedate;
	}

	public Reply(int bno, String id, String replytext) {
		super();
		this.bno = bno;
		this.id = id;
		this.replytext = replytext;
	}
	
	public Reply(int bno, String id, String replytext, String img) {
		super();
		this.bno = bno;
		this.id = id;
		this.replytext = replytext;
		this.img=img;
	}
	
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", bno=" + bno + ", id=" + id + ", replytext=" + replytext + ", writedate="
				+ writedate + "]";
	}
	
}
