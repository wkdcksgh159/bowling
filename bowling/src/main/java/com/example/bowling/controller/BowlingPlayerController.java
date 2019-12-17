package com.example.bowling.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingPlayerService;
import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

@RestController
public class BowlingPlayerController {
	@Autowired BowlingPlayerService bowlingPlayerService;
	
	//playerRecord 선수의 승률을 계산하는 Controller
	@PostMapping("/getYearWinrate")
	public List<Map<String,Object>> getYearWinrate(PlayerRecord playerRecord){
		System.out.println("----------------getYearWinrateContoller-------------------");
		System.out.println("PlayerRecord Contoller: "+playerRecord);
		return bowlingPlayerService.getYearWinrate(playerRecord);
	}
	
	// playerRecord 한 선수가 하나 하나의 핀이 맞는 확를을 계산하는 Controller
	@PostMapping("/getPinProbability")
	public List<Map<String,Object>> getPinProbability(PlayerRecord playerRecord){
		System.out.println("----------------getPinProbabilityController-------------------");
		System.out.println("PlayerRecord Controller: "+playerRecord);
		return bowlingPlayerService.getPinProbability(playerRecord);
	}
	
	// playerRecord 한 선수가 게임당 스트라이크를 친 수를 출력하는 Controller
	@PostMapping("/getStrike")
	public List<Map<String, Object>> getStrike(PlayerRecord playerRecord){
		System.out.println("----------------getStrikeController-------------------");
		System.out.println("PlayerRecord Controller: "+playerRecord);
		return bowlingPlayerService.getStrike(playerRecord);
	}
	
	// playerReport 팀에 소속된 선수를 불러오는 controller
	@PostMapping("/getTeamPlayer")
	public List<PlayerRecord> getTeamPlayer(Team team){
		System.out.println("----------------getTeamPlayerController-------------------");
		System.out.println("Controller Team: "+team);
		return bowlingPlayerService.getTeamPlayer(team);
	}
	
	// playerReport 팀목록을 불러오는 controller
	@PostMapping("/getTeam")
	public List<Team> getTeam(){
		System.out.println("----------------getTeamListController-------------------");
		return bowlingPlayerService.getTeamList();
	}
	
	// playerRanking 개인랭킹을 불러오는 controller
	@PostMapping("/playerRecord")
	public List<PlayerRecord> getPlayerRecordList(PlayerRecord playerRecord) {
		System.out.println("getPlayerRecordList : "+playerRecord);
		return bowlingPlayerService.getPlayerRecordList(playerRecord);
	}
}
