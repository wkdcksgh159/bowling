package com.example.bowling.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.Paging;
import com.example.bowling.vo.Schedule;

@Mapper
public interface BowlingScheduleMapper {
	//날짜별 경기 기록을 불러오는 mapper
	public List<Schedule> selectSchedulePage(Paging paging);
	
	public List<Schedule> selectSchedule();
 	
	public List<Map<String,Object>> selectScheduleOne(int gameNo);
}
