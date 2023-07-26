package com.iu.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.bankBook.BankBookDAO;
import com.iu.main.bankBook.BankBookDTO;

public class BankBookDAOTest extends Mytest {
	@Autowired
	 private BankBookDAO bankBookDAO;
	@Test
	public void getListTest() throws Exception{
	Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("StartRow", 1);
		map.put("lastRow", 10);
		
		List<BankBookDTO> ar = bankBookDAO.getList(map);
		System.out.println(ar.get(0).getBookNum());
	System.out.println(ar.get(9).getBookNum());
		}
	
	
	//@Test
	 public void addTest()throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
		
		bankBookDTO.setBookName("적금가입"+i);
		bankBookDTO.setBookContents("적급가입 내용"+i);
		bankBookDTO.setBookRate(2.2);
		bankBookDTO.setBookSale(1);
		bankBookDAO.setAdd(bankBookDTO);
		}
		System.out.println("Finish");
		}
	
}
