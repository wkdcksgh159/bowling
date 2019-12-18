package com.example.bowling.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bowling.service.BowlingAdminService;
import com.example.bowling.vo.Admin;

@RestController
public class BowlinAdminController {
	@Autowired
	private BowlingAdminService bowlingAdminService;
	
	//로그인 체크
	@PostMapping("/loginResult")
	public int adminLoginResult(HttpSession session) {
		System.out.println("Controller Session: "+session.getAttribute("loginResult"));
		String login = (String) session.getAttribute("loginResult");
		System.out.println("Controller Login: "+login);
		if (login == null) {
			return 0;
		}else {
			return 1;
		}
		
	}
	
	// 관리자 로그인 체크
	@PostMapping("/adminLogin")
	public int adminLoginCheck(Admin admin, HttpSession session, 
			ModelAndView modelAndView, HttpServletRequest request) {
		System.out.println("adminlogin controller ----------------------------");
		System.out.println("admin 요청 확인"+admin);
		String loginResult = bowlingAdminService.adminLogin(admin);
		System.out.println("Controller Login Result: "+loginResult);
		if(loginResult != null) {
			session.setAttribute("loginResult", loginResult);
			System.out.println("Session: "+session.getAttribute("loginResult"));
			return 1;
		}else {
			return 0;
		}
	}
	
	// 관리자 로그아웃시
	@PostMapping("/adminLogout")
	public String logout(HttpSession session) {
		System.out.println("로그아웃----------------------");
		session.invalidate();
		
		return "redirect:/";
	}

}
