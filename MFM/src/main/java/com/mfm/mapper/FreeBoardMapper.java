package com.mfm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mfm.vo.FreeBoardVO;

@Repository("freeboardmapper")
public interface FreeBoardMapper {
	
	//�߰��ϱ�
	public void insert(FreeBoardVO freeboardvo);
		
	//��ü����
	public List<FreeBoardVO> getList();
		
	//�󼼺���
	public FreeBoardVO get(Long bno);
	
	//�����ϱ�
	public void modify(FreeBoardVO freeboardvo);
	
	//�����ϱ�
	public void remove(long bno);
	
	//
//	public void insertSelectKey(FreeBoardVO freeboardvo);
	//����¡
//	public List<FreeBoardVO> getListWithPaging(PagingAction pa);
	//��������
//	public int getTotal(PagingAction pa);
	//param ����
//	public void updateReplyCnt(@Param("bno")Long bno,@Param("amount")int amount);
	
}