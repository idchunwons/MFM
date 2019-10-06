package com.mfm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mfm.vo.FreeBoardVO;

@Repository("freeboardmapper")
public interface FreeBoardMapper {
	
	//추가하기
	public void insert(FreeBoardVO freeboardvo);
		
	//전체보기
	public List<FreeBoardVO> getList();
		
	//상세보기
	public FreeBoardVO get(Long bno);
	
	//수정하기
	public void modify(FreeBoardVO freeboardvo);
	
	//삭제하기
	public void remove(long bno);
	
	//
//	public void insertSelectKey(FreeBoardVO freeboardvo);
	//페이징
//	public List<FreeBoardVO> getListWithPaging(PagingAction pa);
	//갯수세기
//	public int getTotal(PagingAction pa);
	//param 설명
//	public void updateReplyCnt(@Param("bno")Long bno,@Param("amount")int amount);
	
}