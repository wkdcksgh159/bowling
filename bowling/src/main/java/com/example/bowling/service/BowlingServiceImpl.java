package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingMapper;
import com.example.bowling.vo.Game;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerName;

@Service
@Transactional
public class BowlingServiceImpl implements BowlingService {
	@Autowired
	private BowlingMapper bowlingMapper;
	
	//addReport 게임테이블에 경기를 기록하는 serviceImpl
	@Override
	public int addGame(Game game) {
		System.out.println("bowilng serviceImpl addGame -----------------------------");
		return bowlingMapper.insertGame(game);
	}
	
	
	//addReport 홈팀을 제외한 팀 목록을 셀렉트박스에 불러오는 serviceImpl
	@Override
	public List<Team> getAwayTeam(Team team) {
		System.out.println("bowilng serviceImpl getAwayTeam -----------------------------");
		return bowlingMapper.selectAwayTeam(team);
	}
	
	
	//addReport 선택한 팀의 속한 선수 목록을 불러오는 serviceImpl
	@Override
	public List<TeamPlayerName> getTeamPlayer(Team team){
		System.out.println("bowilng serviceImpl getTeamPlayer -----------------------------");
		System.out.println("Team: "+team);
		return bowlingMapper.selectTeamPlayer(team);
	}
	
	//addReport 팀 목록을 셀렉트박스에 불러오는 serviceImpl
	@Override
	public List<Team> getHomeTeam() {
		System.out.println("bowilng serviceImpl getTeam -----------------------------");
		return bowlingMapper.selectTeam();
	}
}
