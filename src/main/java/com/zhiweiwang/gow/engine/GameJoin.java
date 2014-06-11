package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.model.Player;

@Component("GameJoin")
public class GameJoin implements GameRoleAction {
 
	public ArrayList<String> action(Player player, String gstatus, String command) {
		
		return null;
	}

}

 