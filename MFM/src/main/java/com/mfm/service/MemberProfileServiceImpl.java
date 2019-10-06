package com.mfm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfm.mapper.MemberMapper;
import com.mfm.paging.LoginDTO;
import com.mfm.vo.MemberProfileVO;

@Service
public class MemberProfileServiceImpl implements MemberProfileService{

		
	@Autowired
	private MemberMapper membermapper;
	
	
	@Override
	public void signup(MemberProfileVO memberprofileVO) {
		membermapper.signup(memberprofileVO);
		
	}
	@Override
	public MemberProfileVO login(LoginDTO loginDTO) {
		return membermapper.login(loginDTO);
	}
}