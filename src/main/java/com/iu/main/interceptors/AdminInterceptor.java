package com.iu.main.interceptors;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.main.member.MemberDTO;
import com.iu.main.member.RoleDTO;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		MemberDTO memberDTO=(MemberDTO)request.getSession().getAttribute("member");
		List<RoleDTO> roles =memberDTO.getRoles();
		for(RoleDTO roleDTO:roles) {
			if(roleDTO.getRoleName().equals("ADMIN")) {
				return false;
			}
		}
		request.setAttribute("message", "권한이 불충분하다");
		request.setAttribute("url", "/");
			
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
