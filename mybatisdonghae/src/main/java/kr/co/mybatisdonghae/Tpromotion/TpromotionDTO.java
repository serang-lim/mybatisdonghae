package kr.co.mybatisdonghae.Tpromotion;


import org.springframework.web.multipart.MultipartFile;
public class TpromotionDTO {

	public TpromotionDTO() {}//기본생성자함수
	
	private String TpromotionWrite;
	private int tbno;
	private String timageName;
	private int timageSize;
	private String timageName2;
	private int timageSize2;
	private String tregion;
	private String tsubject;
	private String twdate;
	private String ttime;
	private int tnum;
	private String twriter;
	private String ticon;

	
	private MultipartFile timageNameMF;
	private MultipartFile timageNameMF2;
	
	
	
	public String getTpromotionWrite() {
		return TpromotionWrite;
	}
	public void setTpromotionWrite(String tpromotionWrite) {
		TpromotionWrite = tpromotionWrite;
	}
	public int getTbno() {
		return tbno;
	}
	public void setTbno(int tbno) {
		this.tbno = tbno;
	}
	public String getTimageName() {
		return timageName;
	}
	public void setTimageName(String timageName) {
		this.timageName = timageName;
	}
	public int getTimageSize() {
		return timageSize;
	}
	public void setTimageSize(int timageSize) {
		this.timageSize = timageSize;
	}
	public String getTimageName2() {
		return timageName2;
	}
	public void setTimageName2(String timageName2) {
		this.timageName2 = timageName2;
	}
	public int getTimageSize2() {
		return timageSize2;
	}
	public void setTimageSize2(int timageSize2) {
		this.timageSize2 = timageSize2;
	}
	public String getTregion() {
		return tregion;
	}
	public void setTregion(String tregion) {
		this.tregion = tregion;
	}
	public String getTsubject() {
		return tsubject;
	}
	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}
	public String getTwdate() {
		return twdate;
	}
	public void setTwdate(String twdate) {
		this.twdate = twdate;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTwriter() {
		return twriter;
	}
	public void setTwriter(String twriter) {
		this.twriter = twriter;
	}
	public String getTicon() {
		return ticon;
	}
	public void setTicon(String ticon) {
		this.ticon = ticon;
	}
	public MultipartFile getTimageNameMF() {
		return timageNameMF;
	}
	public void setTimageNameMF(MultipartFile timageNameMF) {
		this.timageNameMF = timageNameMF;
	}
	public MultipartFile getTimageNameMF2() {
		return timageNameMF2;
	}
	public void setTimageNameMF2(MultipartFile timageNameMF2) {
		this.timageNameMF2 = timageNameMF2;
	}
	@Override
	public String toString() {
		return "TpromotionDTO [tbno=" + tbno + ", timageName=" + timageName + ", timageSize=" + timageSize
				+ ", timageName2=" + timageName2 + ", timageSize2=" + timageSize2 + ", tregion=" + tregion
				+ ", tsubject=" + tsubject + ", twdate=" + twdate + ", ttime=" + ttime + ", tnum=" + tnum + ", twriter="
				+ twriter + ", ticon=" + ticon + ", timageNameMF=" + timageNameMF + ", timageNameMF2=" + timageNameMF2
				+ "]";
	}

	
	
	
	
}//class end