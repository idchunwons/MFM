package com.mfm.vo;

import java.sql.Date;

public class FreeBoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	private int replyCnt;
	private int viewCnt;
	
	public Long getBno() {
		return bno;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}	
}