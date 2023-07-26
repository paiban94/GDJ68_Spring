package com.iu.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Frontcontroller {

	//Add_MyBatis

	//Add_Board

	
	@RequestMapping(value = "/" )
	public String getIndex () throws Exception{
		System.out.println("index");
	
		return "index";
	}
	//home 메서드
	//  / 주소가 왔을 때 실행, index.jsp 실행
	// / 주소를 주면 index 가 나와야함.

	// membercontroller 만들기 , GET
	// 주소 .do 빼기
	// /member/login
}
