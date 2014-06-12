package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.model.Player;

@Component("GameJoin")
public class GameJoin implements GameRoleAction {
 
	Logger log = LoggerFactory.getLogger(GameJoin.class);
	
	public ArrayList<String> action(Player player, String gstatus, String command) {
		log.debug("game join");
		return null;
	}

}

 