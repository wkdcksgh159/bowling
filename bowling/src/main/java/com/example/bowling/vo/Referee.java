package com.example.bowling.vo;

import lombok.Data;

@Data

public class Referee {
	private int gameNo;
	private int refereeNo;
	private String refereeCountry;
	private String refereeName;
	private int refereeAge;
	private String refereeGender;
}