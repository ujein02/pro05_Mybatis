package com.shop.myapp.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.shop.myapp.dao.MemberMapper;
import com.shop.myapp.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberMapper memberMapper;
	
	

	//회원목록
	@Override
	public List<MemberDTO> memberList() {
		return memberMapper.memberList();
	}
	
	//회원정보 조회
	@Override
	public MemberDTO getMember(String id) {	
		return memberMapper.getMember(id);
	}
	
	//회원가입
	@Override
	public void memberInsert(MemberDTO dto) {
		memberMapper.memberInsert(dto);
		
	}

	@Override
	public MemberDTO signIn(MemberDTO mdto) {
		return memberMapper.signIn(mdto);
	}

	@Override
	public MemberDTO loginCheck(MemberDTO mdto) {
		return memberMapper.loginCheck(mdto);
	}


	

}
