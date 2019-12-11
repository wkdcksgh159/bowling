package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.PlayerRecord;

@Mapper
public interface BowlingPlayerMapper {
	// 개인 랭킹을 불러오는 mapper
	public List<PlayerRecord> selectPlayerRanking(PlayerRecord playerRecord);
}
