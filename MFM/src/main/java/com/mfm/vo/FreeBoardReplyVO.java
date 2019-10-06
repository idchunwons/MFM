package com.mfm.vo;

import java.util.Date;

public class FreeBoardReplyVO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	
	public Long getRno() {
		return rno;
	}
	public Long getBno() {
		return bno;
	}
	public String getReply() {
		return reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setRno(Long rno) {
		this.rno = rno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
