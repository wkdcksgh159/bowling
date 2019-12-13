package com.example.bowling.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingScheduleService;
import com.example.bowling.vo.Schedule;

@RestController
public class BowlingScheduleController {
	@Autowired BowlingScheduleService bowlingScheduleService;
	
	//날짜별 경기 결과를 가져오는 controller
	@PostMapping("/schedule")
	public List<Schedule> getSchedule(){
		System.out.println("bowilng controller getSchedule -----------------------------");
		List<Schedule> list = new ArrayList<Schedule>();
		list = bowlingScheduleService.getSchedule();
		System.out.println("list"+list);
		return list;
	}
}
