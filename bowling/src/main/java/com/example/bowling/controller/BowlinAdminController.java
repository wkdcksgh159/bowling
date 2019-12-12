package com.example.bowling.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bowling.service.BowlingAdminServiceImpl;
import com.example.bowling.vo.Admin;

@RestController
public class BowlinAdminController {
	@Autowired
	private BowlingAdminServiceImpl bowlingAdminServiceImpl;
	
	// 관리자 로그인 체크
	@PostMapping("/adminLogin")
	public String adminLoginCheck(Admin admin, HttpSession session, 
			ModelAndView modelAndView) {
		System.out.println("adminlogin controller ----------------------------");
		
		// 로그인 성공
		if((bowlingAdminServiceImpl.adminLogin(admin)) != null) {
			session.setAttribute("adminId", admin.getAdminId());
			session.setAttribute("adminPw", admin.getAdminPw());
			modelAndView.setViewName("admin/HelloAdmin.html"); // 로그인후 관리자 페이지 이동
			modelAndView.addObject("success");
			System.out.println("세션"+session);
		// 로그인 실패
		} else {
			modelAndView.setViewName("/admin/adminLogin.html"); // 실패시 로그인페이지로 돌아감
			modelAndView.addObject("false");
		}
		
		return bowlingAdminServiceImpl.adminLogin(admin);
	}
	
	// 관리자 로그아웃시
	@PostMapping("/adminLogout")
	public ModelAndView logout(HttpSession session, HttpServletResponse response) throws IOException {
		System.out.println("로그아웃----------------------");
		if (session.getAttribute("signedUser") == null) {
	        response.sendRedirect("/admin/adminLogin.html");
	    }
		session.invalidate();
		ModelAndView modelAV = new ModelAndView();
		modelAV.setViewName("index.html"); // 로그아웃시 로그인 화면으로
		modelAV.addObject("logout");
		
		return modelAV;
	}

}
