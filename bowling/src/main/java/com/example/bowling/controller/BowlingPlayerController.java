package com.example.bowling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingPlayerService;

@RestController
public class BowlingPlayerController {
	@Autowired BowlingPlayerService bowingPlayerService;
}
