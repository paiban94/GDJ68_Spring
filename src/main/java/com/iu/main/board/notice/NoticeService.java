package com.iu.main.board.notice;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.bankBook.BankBookFileDTO;
import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;




@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	private FileManager fileManager;
	@Override
	public List<BoardDTO> getList (Pager pager) throws Exception{
		
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		
		pager.makePageNum(total);
		
		return noticeDAO.getList(pager);
	}
	@Override
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files, HttpSession session) throws Exception{
		String path ="/resources/upload/notice/";
		
		int result = noticeDAO.setAdd(boardDTO);

		for(MultipartFile multipartFile: files) {
	
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName= fileManager.filesave(path, session, multipartFile);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setNoticeNo(noticeDTO.getNum());
			result = noticeDAO.setFileAdd(noticeFileDTO);
		}
		return noticeDAO.setAdd(noticeDTO);
	}
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getDetail(boardDTO);
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
}
