package com.example.bowling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingService;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

@RestController
public class BowlingController {
	@Autowired
	private BowlingService bowlingService;
	
	//addReport away 팀 명단을 불러오는 controller
	@PostMapping("/getAwayTeam")
	public List<Team> getAwayTeam(Team team) {
		System.out.println("bowilng controller getAwayTeam -----------------------------");
		//홈팀을 제외한 팀 데이터를 저장하는 리스트
		List<Team> list = bowlingService.getAwayTeam(team);
		System.out.println("list : "+list);
		return list;
	}
	
	//addReport 팀을 선택하고 선택한 팀에 속한 선수명단을 불러오는 controller
	@PostMapping("/getHomeTeamPlayer")
	public List<TeamPlayerName> getHomeTeamPlayer(Team team) {
		System.out.println("bowilng controller getHomeTeam -----------------------------");
		System.out.println("team : "+team);
		
		//팀에 속한 선수명단을 불러오는 리스트
		//List<TeamPlayerName> list = bowlingService.getTeamPlayer(team);
		//System.out.println("list : "+list);
		
		return bowlingService.getTeamPlayer(team);
	}
	
	//addReport home 팀 명단을 불러오는 controller
	@PostMapping("/getHomeTeam")
	public List<Team> getHomeTeam() {
		System.out.println("bowilng controller getHomeTeam -----------------------------");
		//전체 팀 데이터를 저장하는 리스트
		List<Team> list = bowlingService.getHomeTeam();
		System.out.println("list : "+list);
		return list;
	}
}