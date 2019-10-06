package com.mfm.mapper;

import org.springframework.stereotype.Repository;

import com.mfm.paging.LoginDTO;
import com.mfm.vo.MemberProfileVO;


@Repository("membermapper")
public interface MemberMapper {
	//ȸ�� ���� ���
	public void signup(MemberProfileVO memberProfileVO);
	//ȸ�� �α���
	public MemberProfileVO login(LoginDTO loginDTO);

}
