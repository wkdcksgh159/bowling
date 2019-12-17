package com.example.bowling.vo;


public class PlayerRecord {
	// 개인기록을 입력하기 위한 VO
	private int rank;
	private int playerNo;
	private String playerName;
	private int strikeAvg;
	private int spareAvg;
	private int score;
	private String winRate;
	private int win;
	private int lose;
	private int draw;
	private int matchGame;
	private int scoreAvg;
	private String gender;
	private String column;
	private Paging paging;
	@Override
	public String toString() {
		return "PlayerRecord [rank=" + rank + ", playerNo=" + playerNo + ", playerName=" + playerName + ", strikeAvg="
				+ strikeAvg + ", spareAvg=" + spareAvg + ", score=" + score + ", winRate=" + winRate + ", win=" + win
				+ ", lose=" + lose + ", draw=" + draw + ", matchGame=" + matchGame + ", scoreAvg=" + scoreAvg
				+ ", gender=" + gender + ", column=" + column + ", paging=" + paging + "]";
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getPlayerNo() {
		return playerNo;
	}
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getStrikeAvg() {
		return strikeAvg;
	}
	public void setStrikeAvg(int strikeAvg) {
		this.strikeAvg = strikeAvg;
	}
	public int getSpareAvg() {
		return spareAvg;
	}
	public void setSpareAvg(int spareAvg) {
		this.spareAvg = spareAvg;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getWinRate() {
		return winRate;
	}
	public void setWinRate(String winRate) {
		this.winRate = winRate;
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
	public int getMatchGame() {
		return matchGame;
	}
	public void setMatchGame(int matchGame) {
		this.matchGame = matchGame;
	}
	public int getScoreAvg() {
		return scoreAvg;
	}
	public void setScoreAvg(int scoreAvg) {
		this.scoreAvg = scoreAvg;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
}
