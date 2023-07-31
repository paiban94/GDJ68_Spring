package com.iu.main.qnaBoard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

@Repository
public class QnaBoardDAO {

		@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE="com.iu.main.qnaBoard.QnaBoardDAO.";
		
		//total
		public long getTotal(Pager pager)throws Exception{
			return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
		}
		
		//list
		public List<QnaBoardDTO>getlist(Pager pager) throws Exception{
			return sqlSession.selectList(NAMESPACE+"getlist",pager);
		}
}
