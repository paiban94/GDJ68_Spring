package com.iu.main.bankBook;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.PartialResultException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 해당 클래스의 객체 생성 , 스프링이 작동함
public class BankBookDAO {
		
		@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
		
		
		//List

	//detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
	/*	//1.DB 연결
		Connection con = null; */
	/*	//2.sql문 생성
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM=?"; */
	/*	//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql); */
//		//4. ? 세팅
//		st.setLong(1, bankBookDTO.getBookNum());
//		//5. 최종 전송 및 결과 처리
//		ResultSet rs = st.executeQuery();	
//		
//		if(rs.next()) {
//			//true면 데이터 있고
//			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
//			bankBookDTO.setBookContents(rs.getString("BOOKCONTENTS"));
//			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
//			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
//			
//		}else {
//			bankBookDTO=null;
//		} //false 데이터없다
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	
	}
	//add
	
	//update
	
	//delete
	
}

