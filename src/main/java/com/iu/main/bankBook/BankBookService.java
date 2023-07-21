package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스의 객체를 생성하시오
public class BankBookService {

	@Autowired // ex) BankBookDAO 타입으로 된 객체를 찾아서 넣어주라는 뜻
	private BankBookDAO bankBookDAO; //서비스는 dao에 의존적
	
	public List<BankBookDTO> getList () throws Exception{
		return bankBookDAO.getList();
	}
	
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setAdd(bankBookDTO); 
	}
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	
	public int setDelete(Long num)throws Exception{
		return bankBookDAO.setDelete(num);
		
	}
}
