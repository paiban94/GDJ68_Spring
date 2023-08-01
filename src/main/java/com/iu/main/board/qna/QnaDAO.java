package com.iu.main.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{

		@Autowired
		private SqlSession session;
		
		private final String NAMESPACE="com.iu.main.board.qna.QnaDAO.";
		
		@Override
		public List<BoardDTO> getList(Pager pager) throws Exception {
			// TODO Auto-generated method stub
			return session.selectList(NAMESPACE+"getList", pager);
		}

		@Override
		public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
			// TODO Auto-generated method stub
			return session.selectOne(NAMESPACE+"getDetail", boardDTO);
		}

		@Override
		public int setAdd(BoardDTO boardDTO) throws Exception {
			// TODO Auto-generated method stub
			return session.insert(NAMESPACE+"setAdd", boardDTO);
		}

		@Override
		public int setUpdate(BoardDTO boardDTO) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int setDelete(BoardDTO boardDTO) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int setHitUpdate(BoardDTO boardDTO) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}
		//total
		@Override
		public Long getTotal(Pager pager)throws Exception{
			return session.selectOne(NAMESPACE+"getTotal", pager);
		}

		public int setReplyAdd(QnaDTO qnaDTO)throws Exception{
			System.out.println("setReplyAdd");
			return session.insert(NAMESPACE+"setReplyAdd", qnaDTO);
		}
		
		public int setStepUpdate(QnaDTO qnaDTO)throws Exception {
			return session.update(NAMESPACE+"setStepUpdate", qnaDTO);
		}
		
	
}
