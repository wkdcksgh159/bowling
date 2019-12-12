package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;
import com.example.bowling.vo.TeamPlayerContract;

@Mapper
public interface BowlingPlayerMapper {	
	// playerRanking 개인 랭킹을 불러오는 mapper
	public List<PlayerRecord> selectPlayerRanking(PlayerRecord playerRecord);
	// playerReport 팀에 소속된 선수를 출력하는 mapper
	public List<PlayerRecord> selectTeamPlayer(Team team);
	// playerReport 선수의 상세정보를 출력하는 mapper
	public List<PlayerRecord> selectTeamPlayerOne(PlayerRecord playerRecord);
}
