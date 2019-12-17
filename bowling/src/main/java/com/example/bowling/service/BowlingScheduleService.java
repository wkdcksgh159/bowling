package com.example.bowling.service;

import java.util.List;
import java.util.Map;

import com.example.bowling.vo.Schedule;

public interface BowlingScheduleService {
	public List<Schedule> getSchedulePage(int currentPage);
	
	public List<Schedule> getSchedule();
	
	public List<Map<String,Object>> getScheduleOne(int gameNo);
	
	public int getLastPage();
}
