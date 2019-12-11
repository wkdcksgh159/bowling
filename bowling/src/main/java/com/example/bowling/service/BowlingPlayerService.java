package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.PlayerRecord;

public interface BowlingPlayerService {
	// 개인 랭킹을 불러오는 interface service
	public List<PlayerRecord> selectPlayerRecordList(PlayerRecord playerRecord);

}
