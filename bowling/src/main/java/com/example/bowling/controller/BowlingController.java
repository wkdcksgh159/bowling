package com.example.bowling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingService;
import com.example.bowling.vo.Game;
import com.example.bowling.vo.GamePlayer;
import com.example.bowling.vo.GameResult;
import com.example.bowling.vo.Referee;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

@RestController
public class BowlingController {
	@Autowired
	private BowlingService bowlingService;
	
	@PostMapping("/addGameResult")
	public int addGameResult(GamePlayer gamePlayer) {
		System.out.println("bowilng controller addGameResult -----------------------------");
		bowlingService.addGameResult(gamePlayer);
		return 0;
	}
	
	//add Report 게임이 시작하면 심판이 추가 되게 하기 위한 controller
	@PostMapping("/addReferee")
	public int addReferee(Referee referee) {
		System.out.println("bowilng controller addReferee -----------------------------");
		System.out.println("Controller referee: "+referee);
		int result = bowlingService.addReferee(referee);
		return 0;
	}

	// addReport 심판의 목록을 불러오기위한 controller
	@PostMapping("/getReferee")
	public List<Referee> getReferee(){
		System.out.println("bowilng controller getReferee -----------------------------");
		List<Referee> list = bowlingService.getReferee();
		System.out.println("referee : "+list);
		return list;
	}

	
	//addReport 홈팀과 어웨이팀의 선수를 받아오는 controller
	@PostMapping("/getPlayer")
	public int getPlayer(TeamPlayerName teamPlayerName) {
		System.out.println("bowilng controller getPlayer -----------------------------");
		return 0;
	}
	
	//addReport 선수의 회차마다의 기록을 저장하기 위한 controller
	@PostMapping("/addGamePlayer")
	public int addGamePlayer(GamePlayer gamePlayer) {
		System.out.println("bowilng controller addGamePlayer -----------------------------");
		System.out.println("gamePlayer : "+gamePlayer);
		return bowlingService.addGamePlayer(gamePlayer);
	}

	//addReport 홈팀의 구장을 가져오기위한 controller
	@PostMapping("/getStadium")
	public Team getStadium(Team team) {
		System.out.println("bowilng controller getStadium -----------------------------");
		return bowlingService.getStadium(team);
	}
	
	//addReport 게임테이블에 경기를 기록하는 controller
	@PostMapping("/addGame")
	public Game addGame(Game game) {
		System.out.println("bowilng controller addGame -----------------------------");
		System.out.println("game : "+game);
		return bowlingService.addGame(game);
	}
	
	
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