package cn.smxy.fzw;

public class Works {
	private int wid;
	private String wname;
	private String wcontent;
	private String p_time;
	private String f_time;
	
	private Boolean success;
	
	
	public Works() {
		super();
	}
	public int getwid() {
		return wid;
	}
	public void setwid(int wid) {
		this.wid = wid;
	}
	public String getwname() {
		return wname;
	}
	public void setwname(String wname) {
		this.wname = wname;
	}
	public String getWcontent() {
		return wcontent;
	}
	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}
	public String getP_time() {
		return p_time;
	}
	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	public String getF_time() {
		return f_time;
	}
	public void setF_time(String f_time) {
		this.f_time = f_time;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Works(int wid, String wname, String wcontent, String p_time,
			String f_time) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.wcontent = wcontent;
		this.p_time = p_time;
		this.f_time = f_time;
	}
	@Override
	public String toString() {
		return "Works [wid=" + wid + ", wname=" + wname + ", wcontent="
				+ wcontent + ", p_time=" + p_time + ", f_time=" + f_time + "]";
	}
	
	
}
