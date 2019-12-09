package com.example.bowling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bowling.mapper.BowlingPlayerMapper;

@Service
@Transactional
public class BowlingPlayerServiceImpl implements BowlingPlayerService{
	@Autowired BowlingPlayerMapper bowilngPlayerMapper;
}
