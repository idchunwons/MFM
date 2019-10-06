package com.mfm.paging;

import java.util.List;

import com.mfm.vo.FreeBoardReplyVO;

public class ReplyPageDTO {

		private int replyCnt;
		private List<FreeBoardReplyVO>list;
		
		public ReplyPageDTO(int replyCnt,List<FreeBoardReplyVO>list) {
			
			this.replyCnt=replyCnt;
			this.list=list;
		}

		public int getReplyCnt() {
			return replyCnt;
		}

		public List<FreeBoardReplyVO> getList() {
			return list;
		}

		public void setReplyCnt(int replyCnt) {
			this.replyCnt = replyCnt;
		}

		public void setList(List<FreeBoardReplyVO> list) {
			this.list = list;
		}
}
