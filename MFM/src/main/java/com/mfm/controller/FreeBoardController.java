package com.mfm.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mfm.service.FreeBoardService;
import com.mfm.vo.FreeBoardVO;

@Controller
@RequestMapping("/board/freeboard/*")
public class FreeBoardController {
	private static final Logger logger=
			LoggerFactory.getLogger(FreeBoardController.class);
	@Inject
	private FreeBoardService freeboardservice;
	
	//자유게시판 등록 페이지 이동
	@GetMapping("/register")
	public String registerGET() {
		logger.info("registerGET...");
		return "/board/freeboard/register";
	}

	//자유게시판 등록처리
	@PostMapping("/register")
	public String registerPOST(FreeBoardVO freeboardvo, RedirectAttributes rttr) {
		logger.info("registerPOST...");
	    logger.info(freeboardvo.toString());
	    freeboardservice.register(freeboardvo);
	    rttr.addFlashAttribute("msg", "regSuccess");
		/* rttr.addFlashAttribute("result", freeboardvo.getBno()); */
	    return "redirect:/board/freeboard/list";
	}

	// 전체보기 페이지 이동
	@GetMapping("/list")
	public String list(Model model) {
		logger.info("list...");
		model.addAttribute("list", freeboardservice.getList());
		return "/board/freeboard/list";
	}

	// 상세보기 페이지 이동
	@GetMapping("/get")
	public String get(@RequestParam("bno") Long bno, Model model) {
		logger.info("get...");
		model.addAttribute("get", freeboardservice.get(bno));
		return "/board/freeboard/get";
	}

	// 수정 페이지 이동
	@GetMapping("/modify")
	public String modifyGET(@RequestParam("bno") Long bno, Model model) {
		logger.info("modifyGET...");
		model.addAttribute("modify", freeboardservice.get(bno));
		return "redirect:/board/freeboard/list";
	}
	
	// 수정 처리
	@PostMapping("/modify")
	public String modifyPOST(FreeBoardVO freeboardvo, RedirectAttributes rttr) {
		logger.info("modifyPOST...");
		freeboardservice.modify(freeboardvo);
		rttr.addFlashAttribute("msg", "modSucess");
		return "redirect:/board/freeboard/list";
	}
	

	// 삭제하기
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr) {
		logger.info("remove...");
		freeboardservice.remove(bno);
		rttr.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/freeboard/list";
	}
}