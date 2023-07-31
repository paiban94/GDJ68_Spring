package com.iu.main.notice;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.bankBook.BankBookFileDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;




@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	private FileManager fileManager;
	
	public List<NoticeDTO> getlist (Pager pager) throws Exception{
		
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		
		pager.makePageNum(total);
		
		return noticeDAO.getlist(pager);
	}
	
	public int setAdd(NoticeDTO noticeDTO,MultipartFile [] files, HttpSession session) throws Exception{
		String path ="/resources/upload/notice/";
		
		int result = noticeDAO.setAdd(noticeDTO);

		for(MultipartFile multipartFile: files) {
	
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName= fileManager.filesave(path, session, multipartFile);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setNoticeNo(noticeDTO.getNoticeNo());
			result = noticeDAO.setFileAdd(noticeFileDTO);
		}
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
