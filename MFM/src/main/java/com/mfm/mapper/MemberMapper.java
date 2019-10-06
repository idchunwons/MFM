package com.mfm.mapper;

import org.springframework.stereotype.Repository;

import com.mfm.paging.LoginDTO;
import com.mfm.vo.MemberProfileVO;


@Repository("membermapper")
public interface MemberMapper {
	//회원 정보 등록
	public void signup(MemberProfileVO memberProfileVO);
	//회원 로그인
	public MemberProfileVO login(LoginDTO loginDTO);

}
