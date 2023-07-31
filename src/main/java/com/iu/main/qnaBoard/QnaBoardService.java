package com.iu.main.qnaBoard;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class QnaBoardService {
	@Autowired
	private QnaBoardDAO qnaBoardDAO;
	
	public List<QnaBoardDTO> getlist (Pager pager) throws Exception{
		
		pager.makeRowNum();
		Long total = qnaBoardDAO.getTotal(pager);
		
		pager.makePageNum(total);
		
		return qnaBoardDAO.getlist(pager);
	}
}
