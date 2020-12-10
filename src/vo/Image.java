package vo;

public class Image {

	private int ino;
	private int bno;
	private String img;
	
	public Image() {}
	public Image(int ino, int bno, String img) {
		super();
		this.ino = ino;
		this.bno = bno;
		this.img = img;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
}
