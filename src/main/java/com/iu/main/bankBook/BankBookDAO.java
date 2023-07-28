package com.iu.main.bankBook;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.naming.PartialResultException;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.file.FileDTO;
import com.iu.main.util.Pager;

@Repository // 해당 클래스의 객체 생성 , 스프링이 작동함
public class BankBookDAO {
		
		@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO."; /* . 은 경*/
		
	//total
		public Long getTotal(Pager pager)throws Exception{
			return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
		}
		
		
	//List
	//	public List<E>t
	
		public List<BankBookDTO> getList(Pager pager) throws Exception {
			return sqlSession.selectList(NAMESPACE+"getList", pager);
		}
		
		
		
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
	     // sqlSession 멥퍼의 위치, NAMESPACE 멥퍼의 경로,getDetail 멥퍼의 아이디
	}

	public long getSequence()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSequence");
	}
	
	//add
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
	}
	public int setFileAdd(BankBookFileDTO bankBookFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileAdd", bankBookFileDTO);
	}
	//update
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	//delete
	public int setDelete (Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}
	
	
	
	
}

