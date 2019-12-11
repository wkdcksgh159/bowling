package com.example.bowling.vo;


public class TeamPlayerContract {
	private String teamName;
	private int playerNo;
	private String contractStart;
	private String contractEnd;
	private int salary;
	private int transferfee;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getPlayerNo() {
		return playerNo;
	}
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	public String getContractStart() {
		return contractStart;
	}
	public void setContractStart(String contractStart) {
		this.contractStart = contractStart;
	}
	public String getContractEnd() {
		return contractEnd;
	}
	public void setContractEnd(String contractEnd) {
		this.contractEnd = contractEnd;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getTransferfee() {
		return transferfee;
	}
	public void setTransferfee(int transferfee) {
		this.transferfee = transferfee;
	}
	@Override
	public String toString() {
		return "TeamPlayerContract [teamName=" + teamName + ", playerNo=" + playerNo + ", contractStart="
				+ contractStart + ", contractEnd=" + contractEnd + ", salary=" + salary + ", transferfee=" + transferfee
				+ "]";
	}

}
