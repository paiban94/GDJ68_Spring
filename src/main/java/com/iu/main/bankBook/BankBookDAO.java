package com.iu.main.bankBook;

import org.springframework.stereotype.Repository;

@Repository // 해당 클래스의 객체 생성 , 스프링이 작동함
public class BankBookDAO {

	public void dao() {
		System.out.println("dao");
	}
}
