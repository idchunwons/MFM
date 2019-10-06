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
	
	//�����Խ��� ��� ������ �̵�
	@GetMapping("/register")
	public String registerGET() {
		logger.info("registerGET...");
		return "/board/freeboard/register";
	}

	//�����Խ��� ���ó��
	@PostMapping("/register")
	public String registerPOST(FreeBoardVO freeboardvo, RedirectAttributes rttr) {
		logger.info("registerPOST...");
	    logger.info(freeboardvo.toString());
	    freeboardservice.register(freeboardvo);
	    rttr.addFlashAttribute("msg", "regSuccess");
		/* rttr.addFlashAttribute("result", freeboardvo.getBno()); */
	    return "redirect:/board/freeboard/list";
	}

	// ��ü���� ������ �̵�
	@GetMapping("/list")
	public String list(Model model) {
		logger.info("list...");
		model.addAttribute("list", freeboardservice.getList());
		return "/board/freeboard/list";
	}

	// �󼼺��� ������ �̵�
	@GetMapping("/get")
	public String get(@RequestParam("bno") Long bno, Model model) {
		logger.info("get...");
		model.addAttribute("get", freeboardservice.get(bno));
		return "/board/freeboard/get";
	}

	// ���� ������ �̵�
	@GetMapping("/modify")
	public String modifyGET(@RequestParam("bno") Long bno, Model model) {
		logger.info("modifyGET...");
		model.addAttribute("modify", freeboardservice.get(bno));
		return "redirect:/board/freeboard/list";
	}
	
	// ���� ó��
	@PostMapping("/modify")
	public String modifyPOST(FreeBoardVO freeboardvo, RedirectAttributes rttr) {
		logger.info("modifyPOST...");
		freeboardservice.modify(freeboardvo);
		rttr.addFlashAttribute("msg", "modSucess");
		return "redirect:/board/freeboard/list";
	}
	

	// �����ϱ�
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr) {
		logger.info("remove...");
		freeboardservice.remove(bno);
		rttr.addFlashAttribute("msg", "delSuccess");
		return "redirect:/board/freeboard/list";
	}
}