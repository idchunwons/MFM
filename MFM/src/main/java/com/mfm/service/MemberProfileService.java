package com.mfm.service;

import com.mfm.paging.LoginDTO;
import com.mfm.vo.MemberProfileVO;

public interface MemberProfileService {
	//ȸ�� ���� ���
	public void signup(MemberProfileVO memberprofileVO);
	
	public MemberProfileVO login(LoginDTO loginDTO);
	
	
}