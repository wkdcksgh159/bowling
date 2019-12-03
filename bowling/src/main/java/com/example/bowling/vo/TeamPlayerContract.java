package com.example.bowling.vo;

import lombok.Data;

@Data
public class TeamPlayerContract {
	private String teamName;
	private int playerNo;
	private String contractStart;
	private String contractEnd;
	private int salary;
	private int transferfee;

}
