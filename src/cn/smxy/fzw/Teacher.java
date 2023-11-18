package cn.smxy.fzw;

public class Teacher {
	private String tid;
	private String tname;
	private String tpwd;
	
	private Boolean success;
	
	
	public Teacher() {
		super();
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Teacher(String tid, String tname, String tpwd) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tpwd = tpwd;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tpwd=" + tpwd
				+ "]";
	}
	
	
}
