package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;

	public List<StudentDTO> getStudentList() throws Exception{
		return studentDAO.getStudentList();
	}
	public StudentDTO getStudentDetail(StudentDTO studentDTO)throws Exception {
			return studentDAO.getStudentDetail(studentDTO);
	}


}
