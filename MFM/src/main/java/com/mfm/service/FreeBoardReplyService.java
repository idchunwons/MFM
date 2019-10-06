package com.mfm.service;

import java.util.List;

import com.mfm.paging.PagingAction;
import com.mfm.paging.ReplyPageDTO;
import com.mfm.vo.FreeBoardReplyVO;


public interface FreeBoardReplyService {

	// ����߰��ϱ�
	public int register(FreeBoardReplyVO freeboardreplyvo);

	// ��ۻ󼼺���
	public FreeBoardReplyVO get(Long rno);

	// ��۸�Ϻ��̱�
	public List<FreeBoardReplyVO> getList(PagingAction pa, Long bno);

	// �������¡
	public ReplyPageDTO getListPage(PagingAction pa, Long bno);

	// �Խù� ��ȣ
	public int getCountByBno(Long bno);
	
	//��ۻ���
	public int remove(Long rno);
	
	//��ۼ���
	public int modify(FreeBoardReplyVO freeboardreplyvo);
	
	
}
