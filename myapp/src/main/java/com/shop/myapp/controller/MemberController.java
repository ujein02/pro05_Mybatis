package com.shop.myapp.controller;

import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.shop.myapp.dto.MemberDTO;
import com.shop.myapp.service.MemberService;

@Controller
@RequestMapping(value = "/member/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("list")
	public String memberList(Model model) {
		List<MemberDTO> memberList =  memberService.memberList();
		model.addAttribute("memberList", memberList);
		return "member/list";
	}
	
	//회원 가입 - 회원가입폼 페이지 로딩
	@GetMapping("signup")
	public String getJoin(Model model) throws Exception {
		return "member/signup";
	}
	
	
		
	//로그인 폼 로딩
	@RequestMapping("login")  
	public String memberLoginForm(Model model) throws Exception {
		return "member/login";
	}
	
	

}
