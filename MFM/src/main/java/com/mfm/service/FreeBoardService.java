package com.mfm.service;

import java.util.List;

import com.mfm.paging.PagingAction;
import com.mfm.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//�߰�
	public void register(FreeBoardVO freeboardvo);
	
	//��ü����
	public List<FreeBoardVO> getList();
	
	//�󼼺���
	public FreeBoardVO get(long bno);
	
	//�����ϱ�
	public void modify(FreeBoardVO freeboardvo);
	
	//�����ϱ�
	public void remove(long bno);	
	
	//�˻��ϱ�,��ü����,����¡
	public List<FreeBoardVO> getList(PagingAction pa);
	
	//��������
	public int getTotal(PagingAction pa);
	
	


	/*
	 * //����¡ ó�� public List<FreeBoardVO> listPaging(int page); public
	 * List<FreeBoardVO> listCriteria(Criteria criteria);
	 *///�˻��ϱ�
	/* public List<FreeBoardVO>getList(PagingAction pa); */
	//��������
	/* public int getTotal(PagingAction pa); */
}