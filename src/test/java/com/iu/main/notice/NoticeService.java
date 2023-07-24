package com.iu.main.notice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getNoList () throws Exception{
		return noticeDAO.getNoList();
	}
	
	
}
