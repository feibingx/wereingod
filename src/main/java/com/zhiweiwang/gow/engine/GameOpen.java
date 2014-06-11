package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;

@Component("GameOpen")
public class GameOpen implements GameRoleAction {

	@Autowired
	PlayerMapper playerMapper;
	
	public ArrayList<String> action(Player player, String gstatus, String command) {		
		playerMapper.updatePlayerStatus(player.getUserid(), PStatus.房主.toString());		
		return null;
	}

}
