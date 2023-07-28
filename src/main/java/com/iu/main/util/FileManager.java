package com.iu.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//filesave
	public String filesave(String path, HttpSession session, MultipartFile multipartFile) throws Exception{
		
		//파일의 정보를 이용해서 HDD에 파일을 저장
		
				//1. 어디에 저장?
				//String path = "/resources/upload/member/";
				
				//2.실제 경로 알아오기
				//톰캣 내장객체 어플리케이션사용해야함
				//jsp : allplication == java : ServletContext
				 String realPath= session.getServletContext().getRealPath(path);
				System.out.println(realPath);
				
				File file = new File(realPath);
				
				if(!file.exists()) {
					file.mkdirs();
				}
				//3. 어떤 이름으로 저장?
				//1) 시간을 이용
//				Calendar ca = Calendar.getInstance();
//				long result = ca.getTimeInMillis();
//				file =  new File(file, result+"_"+multipartFile.getOriginalFilename());
				//2) API - 중복된이름이 나오지않게 라이브러리가 보장해줌	
				String uId =UUID.randomUUID().toString();
				uId = uId+"_"+multipartFile.getOriginalFilename();
				System.out.println(uId);
				file = new File(file, uId);
				//universal unique ID
				
				//4. 파일을 저장
				//A. Spring에서 제공하는 API FilecopyUtilis메서드
					FileCopyUtils.copy(multipartFile.getBytes(), file);
				//B. MultipartFile의 transferTo메서드
				multipartFile.transferTo(file);
				
				return uId;
	}

}
