package com.mfm.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.mfm.paging.LoginDTO;
import com.mfm.service.FreeBoardService;
import com.mfm.service.MemberProfileService;
import com.mfm.vo.MemberProfileVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@Inject
	private MemberProfileService service;

	
	  @GetMapping("/login")
	  public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
		return "/login/login";
	  }
	  
	  @PostMapping("/loginPost")
	  public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) {
		  MemberProfileVO memberprofileVO = service.login(loginDTO);
		  if (memberprofileVO == null || !BCrypt.checkpw(loginDTO.getMemberpw(), memberprofileVO.getMemberpw())) {
	            return;
	      }
		  model.addAttribute("user", memberprofileVO);
	  }
	 

	
	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		System.out.println("여기는 logout");
		session.invalidate();
		return "login/logout";
	}
}