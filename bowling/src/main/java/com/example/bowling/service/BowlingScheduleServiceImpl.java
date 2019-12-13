package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bowling.mapper.BowlingScheduleMapper;
import com.example.bowling.vo.Schedule;

@Service
public class BowlingScheduleServiceImpl implements BowlingScheduleService{
	@Autowired BowlingScheduleMapper bowlingScheduleMapper;
	
	@Override
	public List<Schedule> getSchedule() {
		System.out.println("getSchedule Service");
		
		return bowlingScheduleMapper.selectSchedule();
	}
}
