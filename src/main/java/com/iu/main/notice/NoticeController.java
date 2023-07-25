package com.iu.main.notice;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;



@Controller
@RequestMapping(value = "/board/*")
public class NoticeController   {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list",  method = RequestMethod.GET)
	public String getlist(Model model) throws Exception{
		List<NoticeDTO> ar = noticeService.getlist();
		model.addAttribute("list", ar);
		//assertNotEquals(0, ar.size()); /*써도되나?*/
		return "board/list";
	}
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void setAdd() throws Exception{
	}
	//db insert
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO) throws Exception{
	 int result=noticeService.setAdd(noticeDTO);
	 return "redirect:./list";
	}

	//detail
	@RequestMapping(value="detail")
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv)throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	//하나는 수정 폼, 하나는 수정하고 db에 업데이트
	//수정 form
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		noticeDTO=noticeService.getDetail(noticeDTO);
		model.addAttribute("dto",noticeDTO);
	}
	
	//update
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./detail?noticeNo="+noticeDTO.getNoticeNo();
	}
	//delete
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String setDelete(Long noticeNo)throws Exception{
		int result=noticeService.setDelete(noticeNo);
		return "redirect:./list";
	}

}



