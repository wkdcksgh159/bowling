package com.example.bowling.vo;

import lombok.Data;

// addReport 의 선수 목록을 가져오기 위한 vo
@Data
public class TeamPlayerName {
	private String teamName;
	private int playerNo;
	private String playerName;

}
