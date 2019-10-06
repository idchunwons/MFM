package com.mfm.paging;

import org.springframework.stereotype.Repository;

@Repository("page")
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private PagingAction pa;
	
	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getTotal() {
		return total;
	}

	public PagingAction getPa() {
		return pa;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setPa(PagingAction pa) {
		this.pa = pa;
	}

	public void paging(PagingAction pa, int total) {
		this.pa=pa;
		this.total=total;
		
		this.endPage=(int)(Math.ceil(pa.getPageNum()/5.0))*5;
		this.startPage=this.endPage-4;
		
		int realEnd=(int)(Math.ceil((total*1.0)/pa.getAmount()));
		
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1;
		this.next=this.endPage<realEnd;
	}
}