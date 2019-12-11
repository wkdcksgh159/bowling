package com.example.bowling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingPlayerService;
import com.example.bowling.vo.PlayerRecord;

@RestController
public class BowlingPlayerController {
	@Autowired BowlingPlayerService bowingPlayerService;
	
	// playerRanking 개인랭킹을 불러오는 controller
	@PostMapping("/playerRecord")
	public List<PlayerRecord> selectPlayerRecordList(PlayerRecord playerRecord) {
		System.out.println("selectPlayerRecordList : "+playerRecord);
		return bowingPlayerService.selectPlayerRecordList(playerRecord);
	}
}
