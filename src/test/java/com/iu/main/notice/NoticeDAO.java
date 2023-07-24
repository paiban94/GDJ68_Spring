package com.iu.main.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.notie.NoticeDAO.";
	
	public List<NoticeDTO>getNoList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getNoList");
	}
}
