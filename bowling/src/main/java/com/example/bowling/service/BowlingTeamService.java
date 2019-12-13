package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamRecord;

public interface BowlingTeamService {
	// 팀의 순위를 불러오는 service
	public List<TeamRecord> getTeamRecord(TeamRecord teamRecord);
	
	// 해당 팀의 각 핀을 쓰러트린 평균을 가져오는 service
	public List<TeamChart> getTeamPinAvgChart(String teamName);
	// 해당 팀의 승률을 가져오는 service
	public List<TeamChart> getTeamWinChart(String teamName);
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 service
	public List<TeamChart> getTeamStrikeChart(String teamName);
	// 해당 팀의 기록을 가져오는 service
	public TeamRecord getTeamReport(String teamName);
}
