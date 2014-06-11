package com.zhiweiwang.gow.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zhiweiwang.gow.engine.assemble.GameRoleAssembleHandler;
import com.zhiweiwang.gow.mapper.GameRealMapper;
import com.zhiweiwang.gow.mapper.GameTemplateMapper;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.GameTemplate; 
import com.zhiweiwang.gow.model.Player;

@Component("GameCounting")
public class GameCounting implements GameRoleAction {

	@Autowired
	PlayerMapper playerMapper;
	
	@Autowired
	GameRealMapper gameRealMapper;
	
	@Autowired
	GameTemplateMapper gameTemplateMapper;
	
	@Autowired
	GameRoleAssembleHandler rolesHandler;
	
	@Transactional
	public ArrayList<String> action(Player player, String gstatus, String command) {		
		int number = Integer.parseInt(command);
		
		List<GameTemplate> template = gameTemplateMapper.getTemplate(number);
		
		
		//rolesHandler.addGameRoles(template);
		
		return null;
	}

}
