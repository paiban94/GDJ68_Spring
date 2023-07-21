package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/student/")
public class StudentController {
		@Autowired
		private StudentService studentService;
		

		@RequestMapping(value = "list", method = RequestMethod.GET)
		public String getStudentList (Model model) throws Exception{
		List<StudentDTO> st=studentService.getStudentList();
		model.addAttribute("list", st);
		return "student/list";
		
		public void getStudentDetail () throws Exception{
			
		}
		
		}

}