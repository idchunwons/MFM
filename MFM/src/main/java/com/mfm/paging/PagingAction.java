package com.mfm.paging;


public class PagingAction {
	//페이지 번호
	private int pageNum=1;
	//한페이지에 나오는 게시물수
	private int amount=5;
	private String type;
	private String keyword;
	private String[] typeArr;
	
	public int getPageNum() {
		return pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public String getType() {
		return type;
	}
	public String getKeyword() {
		return keyword;
	}
	public String[] getTypeArr() {
		return type==null?new String[] {}:type.split("");
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}
	
	
	/*
	 * public PagingAction() { this(1,5); } public PagingAction(int pageNum,int
	 * amount) { this.pageNum=pageNum; this.amount=amount; }
	 */
}
