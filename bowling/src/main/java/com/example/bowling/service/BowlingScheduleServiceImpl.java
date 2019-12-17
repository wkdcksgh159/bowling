
package com.example.bowling.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bowling.mapper.BowlingScheduleMapper;
import com.example.bowling.vo.Paging;
import com.example.bowling.vo.Schedule;

@Service
public class BowlingScheduleServiceImpl implements BowlingScheduleService{
	@Autowired BowlingScheduleMapper bowlingScheduleMapper;
	
	@Override
	public List<Schedule> getSchedule() {
		System.out.println("calender Lit Service");
		return bowlingScheduleMapper.selectSchedule();
	}
	//스케줄 목록 출력
	@Override
	public List<Schedule> getSchedulePage(int currentPage) {
		System.out.println("getSchedule Service");
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Paging paging = new Paging();
		paging.setBeginRow(beginRow);
		paging.setRowPerPage(rowPerPage);
		//mapper호출
		return bowlingScheduleMapper.selectSchedulePage(paging);
	}
	//gameNo에 해당하는 턴마다에 점수를 출력+프레임 점수
	@Override
	public List<Map<String, Object>> getScheduleOne(int gameNo) {
		System.out.println("service gameNo>:"+gameNo);
		//mapper 호출
		return bowlingScheduleMapper.selectScheduleOne(gameNo);
	}
}