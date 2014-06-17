package com.zhiweiwang.gow.model;

public class Game {
	protected int id;
	protected int totalplayer;
	protected String rolename;
	protected int rolecount;
	protected int rolecountreal;
	protected String gstatus;
	protected int daycount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalplayer() {
		return totalplayer;
	}

	public void setTotalplayer(int totalplayer) {
		this.totalplayer = totalplayer;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getRolecount() {
		return rolecount;
	}

	public void setRolecount(int rolecount) {
		this.rolecount = rolecount;
	}

	public int getRolecountreal() {
		return rolecountreal;
	}

	public void setRolecountreal(int rolecountreal) {
		this.rolecountreal = rolecountreal;
	}

 

	public String getGstatus() {
		return gstatus;
	}

	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}

	public int getDaycount() {
		return daycount;
	}

	public void setDaycount(int daycount) {
		this.daycount = daycount;
	}

}
