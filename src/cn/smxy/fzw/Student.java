package cn.smxy.fzw;

public class Student {
	private String sid;
	private String sname;
	private String spwd;
	
	private Boolean success;
	
	
	public Student() {
		super();
	}
	public String getsid() {
		return sid;
	}
	public void setsid(String sid) {
		this.sid = sid;
	}
	public String getsname() {
		return sname;
	}
	public void setsname(String sname) {
		this.sname = sname;
	}
	public String getspwd() {
		return spwd;
	}
	public void setspwd(String spwd) {
		this.spwd = spwd;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Student(String sid, String sname, String spwd) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spwd = spwd;
	}
	@Override
	public String toString() {
		return "Teacher [sid=" + sid + ", sname=" + sname + ", spwd=" + spwd
				+ "]";
	}
	
	
}
