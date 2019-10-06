package com.mfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mfm.paging.PagingAction;
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
	
	//����¡
	public List<FreeBoardVO> getListWithPaging(PagingAction pa);
	
	//��������
	public int getTotal(PagingAction pa);

	//param ����
	public void updateReplyCnt(@Param("bno")Long bno,@Param("amount")int amount);
	
	

	//����¡ ó��
	/* public List<FreeBoardVO> listPaging(int page); */

	//����¡ ó��
	/* public List<FreeBoardVO> listCriteria(Criteria criteria); */
	
	
	
	//
//	public void insertSelectKey(FreeBoardVO freeboardvo);
	//����¡
//	public List<FreeBoardVO> getListWithPaging(PagingAction pa);
	//��������
//	public int getTotal(PagingAction pa);
	
}