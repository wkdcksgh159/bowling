package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamReport;

@Mapper
public interface BowlingTeamMapper {
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 mapper
	public List<TeamChart> selectTeamStrikeChart(String teamName);
	// 해당 팀의 기록을 가져오는 mapper
	public TeamReport selectTeamReport(String teamName);
}