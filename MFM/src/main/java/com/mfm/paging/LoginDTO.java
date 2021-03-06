package com.mfm.paging;

public class LoginDTO {
	
	private String memberid;
	private String memberpw;
	private boolean useCookie;
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [memberid=" + memberid + ", memberpw=" + memberpw + ", useCookie=" + useCookie + "]";
	}
	
	
}