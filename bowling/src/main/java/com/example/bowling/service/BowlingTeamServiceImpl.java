package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingTeamMapper;
import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamReport;

@Service
@Transactional
public class BowlingTeamServiceImpl implements BowlingTeamService {

	@Autowired
	private BowlingTeamMapper bowlingTeamMapper;
	
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 serviceImpl
	@Override
	public List<TeamChart> getTeamStrikeChart(String teamName) {
		System.out.println("bowilng serviceImpl getTeamStrikeChart -----------------------------");
		return bowlingTeamMapper.selectTeamStrikeChart(teamName);
	}
	
	// 해당 팀의 기록을 가져오는 serviceImpl
	@Override
	public TeamReport getTeamReport(String teamName) {
		System.out.println("bowilng serviceImpl getTeamReport -----------------------------");
		TeamReport teamReport = bowlingTeamMapper.selectTeamReport(teamName);
		System.out.println("teamReport : "+ teamReport);
		return teamReport;
	}
}
