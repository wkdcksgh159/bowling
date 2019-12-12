package com.example.bowling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingPlayerService;
import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerContract;

@RestController
public class BowlingPlayerController {
	@Autowired BowlingPlayerService bowlingPlayerService;
	
	// playerReport 선수의 상세기록을 출력하기위한 controller
	@PostMapping("/getTeamPlayerOne")
	public List<PlayerRecord> selectTeamPlayerOne(PlayerRecord playerRecord){
		System.out.println("----------------selecTeamPlayerOneController-------------------");
		System.out.println("Controller PlayerRecord: "+playerRecord);
		return bowlingPlayerService.selectTeamPlayOne(playerRecord);
	}
	
	// playerReport 팀에 소속된 선수를 불러오는 controller
	@PostMapping("/getTeamPlayer")
	public List<PlayerRecord> selecTeamPlayer(Team team){
		System.out.println("----------------selecTeamPlayerController-------------------");
		System.out.println("Controller Team: "+team);
		return bowlingPlayerService.selectTeamPlayer(team);
	}
	
	// playerReport 팀목록을 불러오는 controller
	@PostMapping("/getTeam")
	public List<Team> selectTeam(){
		System.out.println("----------------selectTeamListController-------------------");
		return bowlingPlayerService.selectTeamList();
	}
	
	// playerRanking 개인랭킹을 불러오는 controller
	@PostMapping("/playerRecord")
	public List<PlayerRecord> selectPlayerRecordList(PlayerRecord playerRecord) {
		System.out.println("selectPlayerRecordList : "+playerRecord);
		return bowlingPlayerService.selectPlayerRecordList(playerRecord);
	}
}
