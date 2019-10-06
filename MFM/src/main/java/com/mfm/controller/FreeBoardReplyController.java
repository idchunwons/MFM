package com.mfm.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mfm.paging.PagingAction;
import com.mfm.paging.ReplyPageDTO;
import com.mfm.service.FreeBoardReplyService;
import com.mfm.vo.FreeBoardReplyVO;



@RequestMapping("/freereplies")
@RestController
public class FreeBoardReplyController {

	private static final Logger log=LoggerFactory.getLogger(FreeBoardReplyController.class);
	
	@Inject
	private FreeBoardReplyService freeboardreplyservice;
	
	@PostMapping(value="/new")
	public ResponseEntity<String> create(@RequestBody FreeBoardReplyVO freeboardreplyvo){
		log.info("ReplyVo: " + freeboardreplyvo);
		int insertCount=freeboardreplyservice.register(freeboardreplyvo);
		log.info("Reply INSERT COUNT: " + insertCount);
		return insertCount == 1
		?new ResponseEntity<>("insert sucess",HttpStatus.OK)
		:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	@GetMapping(value="/pages/{bno}/{page}", 
			produces= {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO>getList(@PathVariable("page")int page,@PathVariable("bno")Long bno){
		PagingAction pa=new PagingAction();
		pa.setPageNum(page);
		return new ResponseEntity<>(freeboardreplyservice.getListPage(pa,bno),HttpStatus.OK);
	}
	
	@GetMapping(value="/{rno}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<FreeBoardReplyVO> get(@PathVariable("rno") Long rno){
		return new ResponseEntity<>(freeboardreplyservice.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{rno}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>remove(@PathVariable("rno")Long rno){
		return freeboardreplyservice.remove(rno)==1
				?new ResponseEntity<>("delete sucess", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},
		value="/{rno}",
		consumes="application/json",
		produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>modify(
			@RequestBody FreeBoardReplyVO freeboardreplyvo,
			@PathVariable("rno")Long rno){
		freeboardreplyvo.setRno(rno);
		return freeboardreplyservice.modify(freeboardreplyvo)==1
			?new ResponseEntity<>("update sucuess",HttpStatus.OK)
			:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}