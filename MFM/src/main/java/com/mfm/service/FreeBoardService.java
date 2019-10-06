package com.mfm.service;

import java.util.List;

import com.mfm.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//�߰�
	public void register(FreeBoardVO freeboardvo);
	
	//��ü����
	public List<FreeBoardVO> getList();
	
	//�󼼺���
	public FreeBoardVO get(Long bno);
	
	//�����ϱ�
	public void modify(FreeBoardVO freeboardvo);
	
	//�����ϱ�
	public void remove(long bno);
	//�˻��ϱ�
	/* public List<FreeBoardVO>getList(PagingAction pa); */
	//��������
	/* public int getTotal(PagingAction pa); */
}