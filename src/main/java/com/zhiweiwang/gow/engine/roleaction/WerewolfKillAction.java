package com.zhiweiwang.gow.engine.roleaction;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.engine.GameRoleAction;
import com.zhiweiwang.gow.model.Player;

@Component("WerewolfKill")
public class WerewolfKillAction implements GameRoleAction {

	public ArrayList<String> action(Player player, String gstatus, String command) {

		return null;
	}
 

}
