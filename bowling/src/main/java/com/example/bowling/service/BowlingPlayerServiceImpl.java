package com.example.bowling.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingMapper;
import com.example.bowling.mapper.BowlingPlayerMapper;
import com.example.bowling.vo.Paging;
import com.example.bowling.vo.PlayerInforMation;
import com.example.bowling.vo.PlayerRecord;
import com.example.bowling.vo.Team;

@Service
@Transactional
public class BowlingPlayerServiceImpl implements BowlingPlayerService{
	@Autowired BowlingPlayerMapper bowlingPlayerMapper;
	@Autowired BowlingMapper bowlingMapper;
	
	@Override
	//playerInforMation 선수의 정보를 출력하는 Service
	public PlayerInforMation getPlayerInforMation(String playerName) {
		System.out.println("bowilng serviceImpl getPlayerReport -----------------------------");
		System.out.println("playerName : " + playerName);
		PlayerInforMation playerInforMation = bowlingPlayerMapper.selectPlayerInforMation(playerName);
		System.out.println("playerInforMation : "+ playerInforMation);
		return playerInforMation;
	}
	
	
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
	public List<PlayerRecord> getPlayerRecordList(PlayerRecord playerRecord,int currentPage){
		System.out.println("getPlayerRecordList : "+playerRecord+",page:"+currentPage);
		int rowPerPage=3;
		int beginRow = (currentPage-1)*rowPerPage;
		
		Paging paging = new Paging();
		paging.setBeginRow(beginRow);
		paging.setRowPerPage(rowPerPage);
		playerRecord.setPaging(paging);
		return bowlingPlayerMapper.selectPlayerRanking(playerRecord);
	}
	
	@Override
	// playerRanking 개인 랭킹 마지막 페이지를 불러오는 service
	public int getLastPage(PlayerRecord playerRecord) {
		System.out.println("getLastPage");
		int totalCount=bowlingPlayerMapper.selectTotalCount(playerRecord);
		System.out.println("전체 행:"+totalCount);
		int rowPerPage=3;
		int lastPage = totalCount/rowPerPage;
		if(totalCount%rowPerPage!=0) {
			lastPage+=1;
		}
		System.out.println("마지막 페이지"+lastPage);
		return lastPage;
	}
}
