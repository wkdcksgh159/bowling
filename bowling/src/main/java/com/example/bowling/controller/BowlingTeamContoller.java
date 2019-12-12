package com.example.bowling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingTeamService;
import com.example.bowling.vo.TeamChart;
import com.example.bowling.vo.TeamReport;

@RestController
public class BowlingTeamContoller {
	@Autowired
	private BowlingTeamService bowlingTeamService;

	// 해당 팀의 각 핀을 쓰러트린 평균을 가져오는 controller
	@PostMapping("/getTeamPinAvgChart")
	public List<TeamChart> getTeamPinAvgChart(String teamName) {
		System.out.println("bowilng controller getTeamPinAvgChart -----------------------------");
		List<TeamChart> list = bowlingTeamService.getTeamPinAvgChart(teamName);
		System.out.println("list :"+ list);
		return list;
	}
	
	// 해당 팀의 평균 승률을 가져오는 controller
	@PostMapping("/getTeamWinChart")
	public List<TeamChart> getTeamWinChart(String teamName) {
		System.out.println("bowilng controller getTeamWinChart -----------------------------");
		List<TeamChart> list = bowlingTeamService.getTeamWinChart(teamName);
		System.out.println("list :"+ list);
		return list;
	}
	
	// 해당 팀의 평균 스트라이크 횟수를 가져오는 controller
	@PostMapping("/getTeamStrikeChart")
	public List<TeamChart> getTeamStrikeChart(String teamName) {
		System.out.println("bowilng controller getTeamStrikeChart -----------------------------");
		List<TeamChart> list = bowlingTeamService.getTeamStrikeChart(teamName);
		System.out.println("list :"+ list);
		return list;
	}

	// 해당 팀의 기록을 가져오는 controller
	@PostMapping("/getTeamReport")
	public TeamReport getTeamReport(String teamName) {
		System.out.println("bowilng controller getTeamReport -----------------------------");
		return bowlingTeamService.getTeamReport(teamName);
	}
}