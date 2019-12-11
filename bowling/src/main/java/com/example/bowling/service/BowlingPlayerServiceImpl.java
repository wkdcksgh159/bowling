package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingPlayerMapper;
import com.example.bowling.vo.PlayerRecord;

@Service
@Transactional
public class BowlingPlayerServiceImpl implements BowlingPlayerService{
	@Autowired BowlingPlayerMapper bowilngPlayerMapper;
	
	@Override
	// playerRanking 개인랭킹을 불러오는 service impl
	public List<PlayerRecord> selectPlayerRecordList(PlayerRecord playerRecord){
		System.out.println("selectPlayerRecordList : "+playerRecord);
		
		
		return bowilngPlayerMapper.selectPlayerRanking(playerRecord);
	}
}
