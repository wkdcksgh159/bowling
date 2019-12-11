package com.example.bowling.vo;


public class TeamReport {
	private int totalGame;
	private int totalScore;
	private int avgScore;
	private int avgWin;
	private int win;
	private int lose;
	private int draw;
	public int getTotalGame() {
		return totalGame;
	}
	public void setTotalGame(int totalGame) {
		this.totalGame = totalGame;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}
	public int getAvgWin() {
		return avgWin;
	}
	public void setAvgWin(int avgWin) {
		this.avgWin = avgWin;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	@Override
	public String toString() {
		return "TeamReport [totalGame=" + totalGame + ", totalScore=" + totalScore + ", avgScore=" + avgScore
				+ ", avgWin=" + avgWin + ", win=" + win + ", lose=" + lose + ", draw=" + draw + "]";
	}
}