package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//클래스선언부
@Controller 
@RequestMapping("/bankbook/*")/*하나만 들어가는건 value 안써도됨*/
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService; //의존적

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model)throws Exception{
		List<BankBookDTO> ar=bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list"; // list.jsp 찾아가기
	}
	@RequestMapping(value = "detail")
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv)throws Exception{
	//	bankBookDTO = bankBookService.getDetail(bankBookDTO);
	//	bankBookDTO=bankBookService.getDetail(bankBookDTO);
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		mv.addObject("dto",bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}
}
