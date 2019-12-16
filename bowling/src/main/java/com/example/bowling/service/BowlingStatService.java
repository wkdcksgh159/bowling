package com.example.bowling.service;

import java.util.List;
import java.util.Map;

public interface BowlingStatService {
	// 선수의 주로 사용하는 그립 분포도를 보기위한 service
	public List<Map<String, Object>> getGripDistribution();
	// 선수의 손잡이 분포도를 보기 위한 service
	public List<Map<String, Object>> getHandDistribution();
	// 성별별 선수의 공 무게 분포도를 보기 위한 service
	public List<Map<String, Object>> getBallDistribution();
	// 팀 별 평균연봉을 보기 위한 service
	public List<Map<String, Object>> getSalaryDistribution();
}
