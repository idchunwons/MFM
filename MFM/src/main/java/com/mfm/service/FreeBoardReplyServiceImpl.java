package com.mfm.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfm.mapper.FreeBoardMapper;
import com.mfm.mapper.FreeBoardReplyMapper;
import com.mfm.paging.PagingAction;
import com.mfm.paging.ReplyPageDTO;
import com.mfm.vo.FreeBoardReplyVO;

@Service
public class FreeBoardReplyServiceImpl implements FreeBoardReplyService {

	@Inject
	private FreeBoardReplyMapper freeboardreplymapper;
	
	@Inject
	private FreeBoardMapper freeboardMapper;
	
	private static final Logger log = LoggerFactory.getLogger(FreeBoardReplyServiceImpl.class);
	
	@Transactional
	@Override
	public int register(FreeBoardReplyVO freeboardreplyvo) {
		log.info("register......" + freeboardreplyvo);
		freeboardMapper.updateReplyCnt(freeboardreplyvo.getBno(),1);
		return freeboardreplymapper.insert(freeboardreplyvo);
	}

	@Override
	public ReplyPageDTO getListPage(PagingAction pa, Long bno) {
		return new ReplyPageDTO(freeboardreplymapper.getCountByBno(bno),freeboardreplymapper.getListWithPaging(pa,bno));
	}

	@Override
	public List<FreeBoardReplyVO> getList(PagingAction pa, Long bno) {
		// TODO Auto-generated method stub
		return freeboardreplymapper.getListWithPaging(pa, bno);
	}

	@Override
	public int getCountByBno(Long bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FreeBoardReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		return freeboardreplymapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove..."+rno);
		return freeboardreplymapper.delete(rno);
	}

	@Override
	public int modify(FreeBoardReplyVO freeboardreplyvo) {
		log.info("modify..."+freeboardreplyvo);
		return freeboardreplymapper.update(freeboardreplyvo);
	}
}