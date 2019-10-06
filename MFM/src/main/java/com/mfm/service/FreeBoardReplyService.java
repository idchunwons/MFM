package com.mfm.service;

import java.util.List;

import com.mfm.paging.PagingAction;
import com.mfm.paging.ReplyPageDTO;
import com.mfm.vo.FreeBoardReplyVO;


public interface FreeBoardReplyService {

	// 댓글추가하기
	public int register(FreeBoardReplyVO freeboardreplyvo);

	// 댓글상세보기
	public FreeBoardReplyVO get(Long rno);

	// 댓글목록보이기
	public List<FreeBoardReplyVO> getList(PagingAction pa, Long bno);

	// 댓글페이징
	public ReplyPageDTO getListPage(PagingAction pa, Long bno);

	// 게시물 번호
	public int getCountByBno(Long bno);
	
	//댓글삭제
	public int remove(Long rno);
	
	//댓글수정
	public int modify(FreeBoardReplyVO freeboardreplyvo);
	
	
}
