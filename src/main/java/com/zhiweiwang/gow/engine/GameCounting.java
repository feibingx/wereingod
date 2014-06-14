package com.zhiweiwang.gow.engine;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger log = LoggerFactory.getLogger(GameCounting.class);

	@Transactional
	public ArrayList<String> action(Player player, String gstatus,
			String command) {
		int number = Integer.parseInt(command);

		int gameid = 0;

		try {
			gameid = gameRealMapper.getMaxGameid() + number;
		} catch (Exception e) {
			gameid = 100;
		}

		gameRealMapper.newGameOpen(gameid, number, gstatus, 0);

		log.debug("new game opened {}", gameid);
		
		List<GameTemplate> template = gameTemplateMapper.getTemplate(number);

		rolesHandler.addGameRoles(gameid, template);

		
		ArrayList<String> returns=new ArrayList<String>();

		returns.add(command);
		returns.add(""+gameid);
		return returns;
	}

}
