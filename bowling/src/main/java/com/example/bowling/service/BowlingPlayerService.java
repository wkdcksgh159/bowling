package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

public interface BowlingPlayerService {
	//playerRanking 개인 랭킹을 불러오는 service
	public List<PlayerRecord> selectPlayerRecordList(PlayerRecord playerRecord);
	//playerReport 팀의 명단을 불러오는 service
	public List<Team> selectTeamList();
	//playerReport 팀에 소속된 선수를 출력하는 service
	public List<PlayerRecord> selectTeamPlayer(Team team);
	//playerReport 선수의 상세기록을 출력하는 service
	public List<PlayerRecord> selectTeamPlayOne(PlayerRecord playerRecord);
}
