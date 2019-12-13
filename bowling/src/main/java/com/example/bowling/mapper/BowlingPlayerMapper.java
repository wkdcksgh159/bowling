package com.example.bowling.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

@Mapper
public interface BowlingPlayerMapper {	
	// playerRecord 한 선수가 게임당 스트라이크를 친 수를 출력하는 Mapper
	public List<Map<String,Object>> selectGameStrike(PlayerRecord playerRecord);
	// playerRanking 개인 랭킹을 불러오는 mapper
	public List<PlayerRecord> selectPlayerRanking(PlayerRecord playerRecord);
	// playerReport 팀에 소속된 선수를 출력하는 mapper
	public List<PlayerRecord> selectTeamPlayer(Team team);
}
