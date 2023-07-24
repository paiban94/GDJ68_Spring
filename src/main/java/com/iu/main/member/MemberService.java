package com.iu.main.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //객체생성 언오테이션
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
}

