package com.iu.main.board.notice;



import java.util.List
;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;



@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="com.iu.main.board.notice.NoticeDAO.";
	
	
	
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
		return session.update(NAMESPACE+"setUpdate",boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
	 return session.delete(NAMESPACE+"setDelete", boardDTO);
		}
	@Override
	public Long getTotal(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+"getTotal", pager);
		}
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public long getSequence()throws Exception{
	return session.selectOne(NAMESPACE+"getSequence");
    }

	public int setFileAdd(NoticeFileDTO noticeFileDTO) throws Exception{
	return session.insert(NAMESPACE+"setAdd", noticeFileDTO);
	}

	
	//total
//	@Override
//	public Long getTotal(Pager pager)throws Exception {
//	return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
//	}
//	
//	@Override
//	public int setHitUpdate() throws Exception{
//		return 0;
//	}
	
	
//	//list
//	@Override
//	public List<BoardDTO>getList(Pager pager) throws Exception{
//		return sqlSession.selectList(NAMESPACE+"getList", pager);
//	}
////	@Test
////	public void getNoList() throws Exception{
////		List<NoticeDTO> ar = noticeDAO.getNoList();
////		assertNotEquals(0, ar.size());
////	}
//	//Add
//	public int setAdd(NoticeDTO noticeDTO) throws Exception{
//		return sqlSession.insert(NAMESPACE+"setAdd", noticeDTO);
//	}
//	public int setFileAdd(NoticeFileDTO noticeFileDTO) throws Exception{
//		return sqlSession.insert(NAMESPACE+"setAdd", noticeFileDTO);
//	}
//	
//	//detail
//	
//	public NoticeDTO getDetail(NoticeDTO noticeDTO)throws Exception{
//		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
//	}
//	
//	public long getSequence()throws Exception{
//		return sqlSession.selectOne(NAMESPACE+"getSequence");
//	}
//	
//	//update
//	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
//		return sqlSession.update(NAMESPACE+"setUpdate",noticeDTO);
//	}
//	//delete
//	public int setDelete (Long noticeNo)throws Exception{
//	 return sqlSession.delete(NAMESPACE+"setDelete", noticeNo);
//	}
}
