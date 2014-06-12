package com.zhiweiwang.gow.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.mapper.GameRealMapper;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.mapper.RoleActionMapper;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;

@Component
public class GameEngine {
	
	@Autowired
	PlayerMapper playerMapper;
	
	@Autowired
	GameRealMapper gamerealMapper;
	
	@Autowired
	GameRoleRouter game;
	
	public String deal(Player player, String command) {
		String gstatus = gamerealMapper.getGstatus(player.getGameid());
		if(gstatus == null)
			gstatus = "NULL";
		return game.handle(player, gstatus, command);
		
	}

	public Player newPlayer(String userid) {
		playerMapper.newPlayer(userid, Role.未分配.toString(), PStatus.空闲.toString());
		Player player = new Player();
		player.setUserid(userid);
		player.setRolename(Role.未分配.toString());
		player.setPstatus(PStatus.空闲.toString());
		player.setGameid(0);
		return player;
	}

}
