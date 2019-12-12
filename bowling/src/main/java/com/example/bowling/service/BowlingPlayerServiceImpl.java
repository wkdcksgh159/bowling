package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingMapper;
import com.example.bowling.mapper.BowlingPlayerMapper;
import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerContract;

@Service
@Transactional
public class BowlingPlayerServiceImpl implements BowlingPlayerService{
	@Autowired BowlingPlayerMapper bowlingPlayerMapper;
	@Autowired BowlingMapper bowlingMapper;
	
	// playerRecord 선수의 상세기록을 출력하기 위한 service
	@Override
	public List<PlayerRecord> selectTeamPlayOne(PlayerRecord playerRecord) {
		System.out.println("----------------selectTeamPlayOneService-------------------");
		return bowlingPlayerMapper.selectTeamPlayerOne(playerRecord);
	}
	
	// playerRecord 팀에 소속된 선수의 목록을 불러오는 service
	@Override
	public List<PlayerRecord> selectTeamPlayer(Team team) {
		System.out.println("----------------selectTeamPlayerSerice-------------------");
		System.out.println("Team Service: "+team);
		return bowlingPlayerMapper.selectTeamPlayer(team);
	}
	
	// playerRecord 팀 목록을 불러오는 service
	@Override
	public List<Team> selectTeamList() {
		System.out.println("----------------selectTeamListService-------------------");
		return bowlingMapper.selectTeam();
	}
	
	@Override
	// playerRanking 개인랭킹을 불러오는 service
	public List<PlayerRecord> selectPlayerRecordList(PlayerRecord playerRecord){
		System.out.println("selectPlayerRecordList : "+playerRecord);
		return bowlingPlayerMapper.selectPlayerRanking(playerRecord);
	}
}
