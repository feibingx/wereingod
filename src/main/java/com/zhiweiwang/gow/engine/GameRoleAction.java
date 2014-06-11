package com.zhiweiwang.gow.engine;

import java.util.ArrayList; 

import com.zhiweiwang.gow.model.Player;

public interface GameRoleAction {

	public ArrayList<String> action(Player player, String gstatus, String command);
	
}
