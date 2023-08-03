package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import com.iu.main.board.BoardDTO;

import com.iu.main.util.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "qna";
	}
	

	@RequestMapping(value ="list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "board/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "board/add";
		}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(QnaDTO qnaDTO, MultipartFile[] photos, HttpSession session)throws Exception{
		int result =qnaService.setAdd(qnaDTO, photos, session);
		return "redirect:./list";
		}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String setAdd(QnaDTO qnaDTO, Model model)throws Exception{
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		/* System.out.println(boardDTO.getContents()); */
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO noticeDTO, MultipartFile[] photos, HttpSession session)throws Exception{
		int result = qnaService.setUpdate(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String setAdd(QnaDTO qnaDTO)throws Exception{
		int result =qnaService.setDelete(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.GET)
	public String setReply(Long num, Model model) throws Exception{
		model.addAttribute("num", num);
		return "board/reply";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String setReply(QnaDTO qnaDTO, MultipartFile[] photos, HttpSession session) throws Exception{
		int result = qnaService.setReplyAdd(qnaDTO, photos, session);
		return "board/reply";
	}
	

}