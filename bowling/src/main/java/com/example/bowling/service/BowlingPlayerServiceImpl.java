package com.example.bowling.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingMapper;
import com.example.bowling.mapper.BowlingPlayerMapper;
import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

@Service
@Transactional
public class BowlingPlayerServiceImpl implements BowlingPlayerService{
	@Autowired BowlingPlayerMapper bowlingPlayerMapper;
	@Autowired BowlingMapper bowlingMapper;
	
	@Override
	//playerRecord 선수의 승률을 계산하는 Service
	public List<Map<String,Object>> getYearWinrate(PlayerRecord playerRecord){
		System.out.println("----------------getYearWinrateService-------------------");
		System.out.println("PlayerRecord Service: "+playerRecord);
		List<Map<String,Object>> map = bowlingPlayerMapper.selectYearWinrate(playerRecord);
		System.out.println("selectYearWinrate Map: "+map);
		return map;
	}
	
	@Override
	// playerRecord 한 선수가 하나 하나의 핀이 맞는 확를을 계산하는 Service
	public List<Map<String,Object>> getPinProbability(PlayerRecord playerRecord){
		System.out.println("----------------getPinProbabilityService-------------------");
		System.out.println("PlayerRecord Service: "+playerRecord);
		List<Map<String,Object>> map = bowlingPlayerMapper.selectPinProbability(playerRecord);
		System.out.println("getPinProbability Map: "+map);
		return map;
	}
	
	// playerRecord 한 선수가 게임당 스트라이크를 친 수를 출력하는 service
	@Override
	public List<Map<String, Object>> getStrike(PlayerRecord playerRecord) {
		System.out.println("----------------getStrikeService-------------------");
		System.out.println("playerRecord Service: "+playerRecord);
		List<Map<String,Object>> map= bowlingPlayerMapper.selectGameStrike(playerRecord);
		System.out.println("getStrike Map: "+map);
		return map;
	}
	
	// playerRecord 팀에 소속된 선수의 목록을 불러오는 service
	@Override
	public List<PlayerRecord> getTeamPlayer(Team team) {
		System.out.println("----------------getTeamPlayerService-------------------");
		System.out.println("Team Service: "+team);
		
		List<PlayerRecord> player= bowlingPlayerMapper.selectTeamPlayer(team);
		System.out.println("Player Service: "+player);
		return player;
	}
	
	// playerRecord 팀 목록을 불러오는 service
	@Override
	public List<Team> getTeamList() {
		System.out.println("----------------getTeamListService-------------------");
		return bowlingMapper.selectTeam();
	}
	
	@Override
	// playerRanking 개인랭킹을 불러오는 service
	public List<PlayerRecord> getPlayerRecordList(PlayerRecord playerRecord){
		System.out.println("getPlayerRecordList : "+playerRecord);
		return bowlingPlayerMapper.selectPlayerRanking(playerRecord);
	}
}
