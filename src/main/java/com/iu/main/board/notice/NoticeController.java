package com.iu.main.board.notice;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;



@Controller
@RequestMapping(value = "/board/*")  /*"/board/*"*/
public class NoticeController   {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list",  method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "board/list";
	}
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void setAdd() throws Exception{
	}
	//db insert
	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO, MultipartFile [] photos, HttpSession session) throws Exception{
	 int result=noticeService.setAdd(noticeDTO, photos, session);
	 return "redirect:./list";
	}

	//detail
	@RequestMapping(value="detail")
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv)throws Exception{
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	//하나는 수정 폼, 하나는 수정하고 db에 업데이트
	//수정 form
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		BoardDTO boardDTO=noticeService.getDetail(noticeDTO);
		model.addAttribute("dto",noticeDTO);
	}
	
	//update
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./detail?noticeNo="+noticeDTO.getNum();
	}
	//delete
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String setDelete(Long noticeNo)throws Exception{
		int result=noticeService.setDelete(noticeNo);
		return "redirect:./list";
	}

}



