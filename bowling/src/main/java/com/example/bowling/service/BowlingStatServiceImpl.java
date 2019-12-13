package com.example.bowling.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingStatMapper;

@Service
@Transactional
public class BowlingStatServiceImpl implements BowlingStatService{
	@Autowired
	private BowlingStatMapper bowlingStatMapper;
	// 선수의 주로 사용하는 그립 분포도를 보기위한 service
	@Override
	public List<Map<String, Object>> getGripDistribution() {
		System.out.println("getGripDistribution 서비스 요청 확인!");
		return bowlingStatMapper.selectGripDistribution();
	}
	// 선수의 손잡이 분포도를 보기 위한 mapper
	@Override
	public List<Map<String, Object>> getHandDistribution() {
		System.out.println("getHandDistribution 서비스 요청 확인!");
		return bowlingStatMapper.selectHandDistribution();
	}
}
