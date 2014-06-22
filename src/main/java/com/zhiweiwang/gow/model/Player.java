package com.zhiweiwang.gow.model;

public class Player {
	protected String userid;
	protected int gameid;
	protected String rolename;
	protected String cardnumber;
	protected String isAlive;
	protected String acted;
	protected String lover;
	protected String pstatus;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(String isAlive) {
		this.isAlive = isAlive;
	}

	public String getActed() {
		return acted;
	}

	public void setActed(String acted) {
		this.acted = acted;
	}

	public String getLover() {
		return lover;
	}

	public void setLover(String lover) {
		this.lover = lover;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	
	@Override
	public String toString(){
		return "[userid]"+userid+" [rolename]"+rolename;
	}

}
