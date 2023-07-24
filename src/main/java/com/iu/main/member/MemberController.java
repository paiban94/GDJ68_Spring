package com.iu.main.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/member/*")
public class MemberController{
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void getLogin () throws Exception{	
	}

	@RequestMapping(value = "login", method= RequestMethod.POST)
	public String getLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO=memberService.getLogin(memberDTO);
	
		if(memberDTO !=null) {
			//로그인상태유지위해 사용한 내장객체 : section
			session.setAttribute("member", memberDTO);
		}else {}
		//로그인성공하면 리다이렉트로 메인페이지
		return "redirect:../";
	}
	
	//logout
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String getLogout(HttpSession session)throws Exception{
	session.invalidate(); // session 시간을 0으로 만들기
	return "redirect:../";
	}

	
	//mypage
	@RequestMapping(value="mypage", method=RequestMethod.GET)
	public void getMypage() throws Exception {
		
	}
	
	//update
	
	@RequestMapping(value="memberUpdate", method = RequestMethod.GET)
	public void setMemberUpdate()throws Exception{
	}
	@RequestMapping(value="memberUpdate", method = RequestMethod.POST)
	
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{	
		MemberDTO sessionMember =(MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMember.getId());
		int result = memberService.setMemberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:./mypage";
	}

}



//	@Controller
//	@RequestMapping("/member/*")
//
//public class MemberController {
//	
//		@RequestMapping(value= "login")
//		public String GetLogin () throws Exception{
//			System.out.println("Login");
//			return "/member/login";
//		}
//	// membercontroller 만들기 , GET
//	// 주소 .do 빼기
//	// /member/login
//}
