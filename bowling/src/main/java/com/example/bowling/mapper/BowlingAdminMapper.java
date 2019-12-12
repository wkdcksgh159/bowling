package com.example.bowling.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.Admin;

@Mapper
public interface BowlingAdminMapper {
	// 관리자 로그인을 체크하는 mapper
	public String loginCheck(Admin admin);
}
