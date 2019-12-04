package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.Game;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

@Mapper
public interface BowlingMapper {
	//addReport 팀 목록을 셀렉트박스에 불러오는 mapper
	public List<Team> selectTeam();
	//addReport 팀에 속한 선수 명단을 불러오는 mapper
	public List<TeamPlayerName> selectTeamPlayer(Team team);
	//addReport 홈팀을 제외한 팀 목록을 셀렉트박스에 불러오는 mapper
	public List<Team> selectAwayTeam(Team team);
	//addReport 게임테이블에 경기를 기록하는 mapper
	public int insertGame(Game game);
	
	
}