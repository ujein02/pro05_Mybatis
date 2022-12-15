package com.shop.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String id; 
	private String pw;  
	private String name;
	private String email;
	private String tel; 
	private String addr1;
	private String addr2;
	private String postcode;
	private String regdate;
	

}
