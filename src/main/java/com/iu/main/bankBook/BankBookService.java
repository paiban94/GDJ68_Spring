package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스의 객체를 생성하시오
public class BankBookService {

	@Autowired // ex) BankBookDAO 타입으로 된 객체를 찾아서 넣어주라는 뜻
	private BankBookDAO bankBookDAO; //서비스는 dao에 의존적
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	
	
}
