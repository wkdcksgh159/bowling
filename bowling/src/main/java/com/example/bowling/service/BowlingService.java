package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.Game;
import com.example.bowling.vo.GamePlayer;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

public interface BowlingService {
	//addReport 팀 목록을 셀렉트박스에 불러오는 service
	public List<Team> getHomeTeam();
	//addReport 선택한 팀에 속한 선수명단을 불러오는 service
	public List<TeamPlayerName> getTeamPlayer(Team team);
	//addReport 홈팀을 제외한 팀 목록을 셀렉트박스에 불러오는 service
	public List<Team> getAwayTeam(Team team);
	//addReport 게임테이블에 경기를 기록하는 service
	public int addGame(Game game);
	//addReport 홈팀의 구장을 가져오기위한 service
	public Team getStadium(Team team);
	//addReport 선수의 회차마다의 기록을 저장하기 위한 service
	public int addGamePlayer(GamePlayer gamePlayer);
}
