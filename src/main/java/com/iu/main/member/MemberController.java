package com.iu.main.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/member/*")

public class MemberController {
	
		@RequestMapping(value= "login")
		public String GetLogin () throws Exception{
			System.out.println("Login");
			return "/member/login";
		}
	// membercontroller 만들기 , GET
	// 주소 .do 빼기
	// /member/login
}
