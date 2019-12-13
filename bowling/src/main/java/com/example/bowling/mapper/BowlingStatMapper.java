package com.example.bowling.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BowlingStatMapper {
	// 선수의 주로 사용하는 그립 분포도를 보기위한 mapper
	public List<Map<String, Object>> selectGripDistribution();
	// 선수의 손잡이 분포도를 보기 위한 mapper
	public List<Map<String, Object>> selectHandDistribution();
}
