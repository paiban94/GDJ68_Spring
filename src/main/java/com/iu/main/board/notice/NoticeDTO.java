package com.iu.main.board.notice;


import java.util.List;

import com.iu.main.board.BoardDTO;



public class NoticeDTO extends BoardDTO  {

	public List<NoticeFileDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<NoticeFileDTO> dtos) {
		this.dtos = dtos;
	}

	private List<NoticeFileDTO> dtos;
}
