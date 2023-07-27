package com.iu.main.notice;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.util.Pager;




@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getlist (Pager pager) throws Exception{
		
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		
		pager.makePageNum(total);
		
		return noticeDAO.getlist(pager);
	}
	
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setAdd(noticeDTO);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.getDetail(noticeDTO);
	}
	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setUpdate(noticeDTO);
	}
	public int setDelete(Long noticeNo) throws Exception{
		return noticeDAO.setDelete(noticeNo);
	}
}
