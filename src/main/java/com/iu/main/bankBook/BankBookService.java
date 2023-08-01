package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service // 해당 클래스의 객체를 생성하시오
public class BankBookService {

	@Autowired // ex) BankBookDAO 타입으로 된 객체를 찾아서 넣어주라는 뜻
	private BankBookDAO bankBookDAO; //서비스는 dao에 의존적
	@Autowired
	private FileManager fileManager; //hdd저장
	
	public List<BankBookDTO> getList (Pager pager) throws Exception{
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		//page  	start 	lastrow
//		// 1		1  		10
//		// 2 		11 		20
//		// 3 		21		30
//		//...
//		int count=10;
//		int startRow=(page-1)*count+1;
//		int lastRow=page*count;
//		
		pager.makeRowNum();
		Long total = bankBookDAO.getTotal(pager);

		pager.makePageNum(total);
		
//		map.put("startRow",startRow);
//		map.put("lastRow", lastRow);
		return bankBookDAO.getList(pager);
	}
	
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO, MultipartFile [] files, HttpSession session) throws Exception{
		// /resources/upload/bankbook
		String path ="/resources/upload/bankbook/";
		//long num = bankBookDAO.getSequence();
		//bankBookDTO.setBookNum(num);
		
		int result = bankBookDAO.setAdd(bankBookDTO); 
	
		for(MultipartFile multipartFile: files) {
	
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName= fileManager.fileSave(path, session, multipartFile);
			BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
			bankBookFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			bankBookFileDTO.setFileName(fileName);
			bankBookFileDTO.setBookNum(bankBookDTO.getBookNum());
			result = bankBookDAO.setFileAdd(bankBookFileDTO);
		}
				
		return result; 
	}
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	
	public int setDelete(Long num)throws Exception{
		return bankBookDAO.setDelete(num);
		
	}
}

