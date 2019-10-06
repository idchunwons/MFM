package com.mfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mfm.paging.PagingAction;
import com.mfm.vo.FreeBoardReplyVO;


public interface FreeBoardReplyMapper {
	
	public int insert(FreeBoardReplyVO freeboardreplyvo);

	public int getCountByBno(Long bno);

	public List<FreeBoardReplyVO> getListWithPaging(@Param("pa")PagingAction pa,@Param("bno")Long bno);
	
	public FreeBoardReplyVO read(Long rno);
	
	public List<FreeBoardReplyVO>getList(Long bno);
	
	public int delete(Long rno);
	
	public int update(FreeBoardReplyVO freeboardreplyvo);
}
