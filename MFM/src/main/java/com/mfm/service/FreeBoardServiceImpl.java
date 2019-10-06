package com.mfm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mfm.mapper.FreeBoardMapper;
import com.mfm.paging.PagingAction;
import com.mfm.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper freeboardmapper;

	@Override
	public void register(FreeBoardVO freeboardvo) {
		freeboardmapper.insert(freeboardvo);
	}

	@Override
	public List<FreeBoardVO> getList() {
		return freeboardmapper.getList();
	}

	@Override
	public FreeBoardVO get(long bno) {
		return freeboardmapper.get(bno);
	}

	@Override
	public void modify(FreeBoardVO freeboardvo) {
		freeboardmapper.modify(freeboardvo);
	}

	@Override
	public void remove(long bno) {
		freeboardmapper.remove(bno);
	}

	@Override
	public List<FreeBoardVO> getList(PagingAction pa) {
		return freeboardmapper.getListWithPaging(pa);
	}

	@Override
	public int getTotal(PagingAction pa) {
		return freeboardmapper.getTotal(pa);
	}

	
	
	
	/*
	 * @Override public List<FreeBoardVO> getList(PagingAction pa) { return
	 * freeboardmapper.getListWithPaging(pa); }
	 * 
	 * @Override public int getTotal(PagingAction pa) { // TODO Auto-generated
	 * method stub return freeboardmapper.getTotal(pa); }
	 */
}