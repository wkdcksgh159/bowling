package com.example.bowling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingAdminMapper;
import com.example.bowling.vo.Admin;

@Service
@Transactional
public class BowlingAdminServiceImpl implements BowlingAdminService {
	@Autowired
	private BowlingAdminMapper bowlingAdminMapper;
	
	// 관리자 로그인을 체크하는 serviceImpl
	@Override
	public String adminLogin(Admin admin){
		System.out.println("admin login serviceImpl------------------------------------");
		
		return bowlingAdminMapper.loginCheck(admin);
	}
}
