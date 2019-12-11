package com.example.bowling.vo;




public class Referee {
	private int gameNo;
	private int refereeNo;
	private String refereeCountry;
	private String refereeName;
	private int refereeAge;
	private String refereeGender;
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	public int getRefereeNo() {
		return refereeNo;
	}
	public void setRefereeNo(int refereeNo) {
		this.refereeNo = refereeNo;
	}
	public String getRefereeCountry() {
		return refereeCountry;
	}
	public void setRefereeCountry(String refereeCountry) {
		this.refereeCountry = refereeCountry;
	}
	public String getRefereeName() {
		return refereeName;
	}
	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}
	public int getRefereeAge() {
		return refereeAge;
	}
	public void setRefereeAge(int refereeAge) {
		this.refereeAge = refereeAge;
	}
	public String getRefereeGender() {
		return refereeGender;
	}
	public void setRefereeGender(String refereeGender) {
		this.refereeGender = refereeGender;
	}
	@Override
	public String toString() {
		return "Referee [gameNo=" + gameNo + ", refereeNo=" + refereeNo + ", refereeCountry=" + refereeCountry
				+ ", refereeName=" + refereeName + ", refereeAge=" + refereeAge + ", refereeGender=" + refereeGender
				+ "]";
	}
	
}