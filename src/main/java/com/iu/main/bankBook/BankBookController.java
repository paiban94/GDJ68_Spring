package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//클래스선언부
@Controller 
@RequestMapping("/bankbook/*")/*하나만 들어가는건 value 안써도됨*/
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService; //의존적

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String getList()throws Exception{
		System.out.println("list");
		bankBookService.service();		
		return "bankbook/list"; // list.jsp 찾아가기
	}
	@RequestMapping(value = "detail")
	public String getDetail()throws Exception{
		System.out.println("detail");
		return "bankbook/detail";
	}
}
