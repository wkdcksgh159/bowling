package com.example.bowling.service;

import java.util.List;
import java.util.Map;

import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

public interface BowlingPlayerService {
	//playerRanking 마지막 페이지를 불러오는 service
	public int getLastPage(PlayerRecord playerRecord);
	//playerRanking 개인 랭킹을 불러오는 service
	public List<PlayerRecord> getPlayerRecordList(PlayerRecord playerRecord,int currentPage);
	//playerReport 팀의 명단을 불러오는 service
	public List<Team> getTeamList();
	//playerReport 팀에 소속된 선수를 출력하는 service
	public List<PlayerRecord> getTeamPlayer(Team team);
	// playerRecord 한 선수가 게임당 스트라이크를 친 수를 출력하는 service
	public List<Map<String,Object>> getStrike(PlayerRecord playerRecord);
	// playerRecord 한 선수가 하나 하나의 핀이 맞는 확를을 계산하는 Mapper
	public List<Map<String,Object>> getPinProbability(PlayerRecord playerRecord);
	//playerRecord 선수의 승률을 계산하는 Service
	public List<Map<String,Object>> getYearWinrate(PlayerRecord playerRecord);
}
