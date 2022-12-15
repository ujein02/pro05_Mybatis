package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> memberList();
	public MemberDTO getMember(String id);
	public void memberInsert(MemberDTO dto);
	public MemberDTO signIn(MemberDTO mdto);
	public MemberDTO loginCheck(MemberDTO mdto);
	

}
