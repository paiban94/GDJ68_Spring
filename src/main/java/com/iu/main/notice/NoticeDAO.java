package com.iu.main.notice;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.bankBook.BankBookDTO;



@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.notice.NoticeDAO.";
	
	public List<NoticeDTO>getlist() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getlist");
	}
//	@Test
//	public void getNoList() throws Exception{
//		List<NoticeDTO> ar = noticeDAO.getNoList();
//		assertNotEquals(0, ar.size());
//	}
	//Add
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", noticeDTO);
	}
	//detail
	public NoticeDTO getDetail(NoticeDTO noticeDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	//update
	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate",noticeDTO);
	}
	//delete
	public int setDelete (Long noticeNo)throws Exception{
	 return sqlSession.delete(NAMESPACE+"setDelete", noticeNo);
	}
}
