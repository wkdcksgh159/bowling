package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamReport;

public interface BowlingTeamService {
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 service
	public List<TeamChart> getTeamStrikeChart(String teamName);
	// 해당 팀의 기록을 가져오는 service
	public TeamReport getTeamReport(String teamName);
}
