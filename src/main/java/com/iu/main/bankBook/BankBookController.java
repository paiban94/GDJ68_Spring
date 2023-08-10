package com.iu.main.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.util.Pager;

//클래스선언부
@Controller 
@RequestMapping("/bankbook/*")/*하나만 들어가는건 value 안써도됨*/
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService; //의존적

	//-- Comment
	@GetMapping("commentList")
	public void getCommentList(CommentDTO commentDTO, Pager pager)throws Exception{
		List<comment> ar=bankBookService.getCommentList(pageer, commentDTO);
	}
	
	//---BankBook
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model)throws Exception{
		List<BankBookDTO> ar = bankBookService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "bankbook/list";
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
	// form으로 이동
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void setAdd() throws Exception{
		
	}
	
	//db insert
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		 int result =bankBookService.setAdd(bankBookDTO, photos, session);
		 return "redirect:./list";
	}

	//하나는 수정 폼, 하나는 수정하고 db에 업데이트
	//수정 form
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void setUpdate(BankBookDTO bankBookDTO, Model model)throws Exception{
		bankBookDTO=bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
	}
	
	//update
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		//return "redirect:./list";
		return "redirect:./detail?bookNum="+bankBookDTO.getBookNum();
	}
	
	
	//delete

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(@RequestParam(name = "bookNum") Long num)throws Exception{
		int result = bankBookService.setDelete(num);
		return "redirect:./list";
	}
}
