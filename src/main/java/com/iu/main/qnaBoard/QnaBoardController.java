package com.iu.main.qnaBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.util.Pager;

@Controller
@RequestMapping(value = "/qnaBoard/*")
public class QnaBoardController {
	
	@Autowired
	private QnaBoardService qnaBoardService;

	@RequestMapping(value ="list", method = RequestMethod.GET)
	public String getlist(Pager pager, Model model) throws Exception{
		List<QnaBoardDTO> ar = qnaBoardService.getlist(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "qnaBoard/list";
	}
}
