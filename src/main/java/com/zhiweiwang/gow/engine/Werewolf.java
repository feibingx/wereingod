package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.model.Player;

@Component("werewolf")
public class Werewolf extends Villager implements GameRoleAction {

	public ArrayList<String> action(Player player, String gstatus, String command) {
		// TODO Auto-generated method stub
		return null;
	}

}
