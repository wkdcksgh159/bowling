package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingTeamMapper;
import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamRecord;

@Service
@Transactional
public class BowlingTeamServiceImpl implements BowlingTeamService {

	@Autowired
	private BowlingTeamMapper bowlingTeamMapper;
	
	// 팀의 순위를 불러오는 serviceImpl
	@Override
	public List<TeamRecord> getTeamRecord(TeamRecord teamRecord) {
		System.out.println("bowilng serviceImpl getTeamRecord -----------------------------");
		System.out.println("teamRecord : " + teamRecord);
		return bowlingTeamMapper.selectTeamRecord(teamRecord);
	}
	
	// 해당 팀의 각 핀을 쓰러트린 평균을 가져오는 serviceImpl
	@Override
	public List<TeamChart> getTeamPinAvgChart(String teamName) {
		System.out.println("bowilng serviceImpl getTeamPinAvgChart -----------------------------");
		System.out.println("teamName : " + teamName);
		return bowlingTeamMapper.selectTeamPinAvgChart(teamName);
	}
	
	// 해당 팀의 승률 가져오는 serviceImpl
	@Override
	public List<TeamChart> getTeamWinChart(String teamName) {
		System.out.println("bowilng serviceImpl getTeamWinChart -----------------------------");
		System.out.println("teamName : " + teamName);
		return bowlingTeamMapper.selectTeamWinChart(teamName);
	}
	
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 serviceImpl
	@Override
	public List<TeamChart> getTeamStrikeChart(String teamName) {
		System.out.println("bowilng serviceImpl getTeamStrikeChart -----------------------------");
		System.out.println("teamName : " + teamName);
		return bowlingTeamMapper.selectTeamStrikeChart(teamName);
	}
	
	// 해당 팀의 기록을 가져오는 serviceImpl
	@Override
	public TeamRecord getTeamReport(String teamName) {
		System.out.println("bowilng serviceImpl getTeamReport -----------------------------");
		System.out.println("teamName : " + teamName);
		TeamRecord teamReport = bowlingTeamMapper.selectTeamReport(teamName);
		System.out.println("teamReport : "+ teamReport);
		return teamReport;
	}
}
