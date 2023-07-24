package com.iu.main.student;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankBook.BankBookDTO;




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
		} //ㅜㅜ
		
		@RequestMapping(value = "detail", method = RequestMethod.GET)
		public ModelAndView getSDetail(StudentDTO studentDTO, ModelAndView mv)throws Exception{
		studentDTO =  studentService.getStudentDetail(studentDTO);
		System.out.println(studentDTO.getStudentName());
		mv.addObject("dto", studentDTO);
		mv.setViewName("student/detail");
		return mv;
		
		
	
		}

		
		
	}
