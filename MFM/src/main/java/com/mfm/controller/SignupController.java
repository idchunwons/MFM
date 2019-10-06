package com.mfm.controller;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mfm.service.MemberProfileService;
import com.mfm.vo.MemberProfileVO;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
		
	@Inject
	private MemberProfileService service;
	
	
	@GetMapping("/signup")
	public String signup() {
		return "/signup/signup";
	}
	
	@PostMapping("/signup") 
	public String signup(MemberProfileVO memberprofileVO,RedirectAttributes rttr) {
		String hashedPw=BCrypt.hashpw(memberprofileVO.getMemberpw(),BCrypt.gensalt());
		memberprofileVO.setMemberpw(hashedPw);
		service.signup(memberprofileVO);
		rttr.addFlashAttribute("msg", "REGISTERED");
		return "redirect:/login/login";
	}
}