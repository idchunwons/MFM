package com.mfm.service;

import com.mfm.paging.LoginDTO;
import com.mfm.vo.MemberProfileVO;

public interface MemberProfileService {
	//회원 정보 등록
	public void signup(MemberProfileVO memberprofileVO);
	
	public MemberProfileVO login(LoginDTO loginDTO);
	
	
}