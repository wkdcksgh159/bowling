package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

public interface BowlingService {
	//addReport 팀 목록을 셀렉트박스에 불러오는 service
	public List<Team> getHomeTeam();
	//addReport 선택한 팀에 속한 선수명단을 불러오는 service
	public List<TeamPlayerName> getTeamPlayer(Team team);
	//addReport 홈팀을 제외한 팀 목록을 셀렉트박스에 불러오는 service
	public List<Team> getAwayTeam(Team team);
	
}
