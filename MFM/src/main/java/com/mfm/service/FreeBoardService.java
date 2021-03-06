package com.mfm.service;

import java.util.List;

import com.mfm.paging.PagingAction;
import com.mfm.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//추가
	public void register(FreeBoardVO freeboardvo);
	
	//전체보기
	public List<FreeBoardVO> getList();
	
	//상세보기
	public FreeBoardVO get(long bno);
	
	//수정하기
	public void modify(FreeBoardVO freeboardvo);
	
	//삭제하기
	public void remove(long bno);	
	
	//검색하기,전체보기,페이징
	public List<FreeBoardVO> getList(PagingAction pa);
	
	//갯수세기
	public int getTotal(PagingAction pa);
	
	


	/*
	 * //페이징 처리 public List<FreeBoardVO> listPaging(int page); public
	 * List<FreeBoardVO> listCriteria(Criteria criteria);
	 *///검색하기
	/* public List<FreeBoardVO>getList(PagingAction pa); */
	//갯수세기
	/* public int getTotal(PagingAction pa); */
}