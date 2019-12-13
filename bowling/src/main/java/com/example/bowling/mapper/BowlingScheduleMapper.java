package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.Schedule;

@Mapper
public interface BowlingScheduleMapper {
	//날짜별 경기 기록을 불러오는 mapper
	public List<Schedule> selectSchedule();
}
