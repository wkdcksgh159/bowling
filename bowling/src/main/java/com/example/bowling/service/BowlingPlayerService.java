package com.example.bowling.service;

import java.util.List;
import java.util.Map;

import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

public interface BowlingPlayerService {
	//playerRanking 개인 랭킹을 불러오는 service
	public List<PlayerRecord> getPlayerRecordList(PlayerRecord playerRecord);
	//playerReport 팀의 명단을 불러오는 service
	public List<Team> getTeamList();
	//playerReport 팀에 소속된 선수를 출력하는 service
	public List<PlayerRecord> getTeamPlayer(Team team);
	// playerRecord 한 선수가 게임당 스트라이크를 친 수를 출력하는 service
	public List<Map<String,Object>> getStrike(PlayerRecord playerRecord);
}
