package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;

@Component("GameOpen")
public class GameOpen implements GameRoleAction {

	Logger log = LoggerFactory.getLogger(GameOpen.class);

	@Autowired
	PlayerMapper playerMapper;

	public ArrayList<String> action(Player player, String gstatus, String command) {
		playerMapper.updatePlayerRole(player.getUserid(), Role.房主.toString());
		log.debug("{} opened a room. ",player.getUserid());
		return null;
	}

}
