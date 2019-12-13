package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamRecord;

@Mapper
public interface BowlingTeamMapper {
	// 팀의 순위를 불러오는 mapper
	public List<TeamRecord> selectTeamRecord(TeamRecord teamRecord);
	
	// 해당 팀의 각 핀을 쓰러트린 평균을 가져오는 mapper
	public List<TeamChart> selectTeamPinAvgChart(String teamName);
	// 해당 팀의 승률을 가져오는 mapper
	public List<TeamChart> selectTeamWinChart(String teamName);
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 mapper
	public List<TeamChart> selectTeamStrikeChart(String teamName);
	// 해당 팀의 기록을 가져오는 mapper
	public TeamRecord selectTeamReport(String teamName);
}