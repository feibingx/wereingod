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
import com.zhiweiwang.gow.model.GStatus;
import com.zhiweiwang.gow.model.GameTemplate;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;

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
	public ArrayList<String> action(Player player, String gstatus, String command) {

		List<GameTemplate> template = gameTemplateMapper.getTemplate(command);
		return createNewGame(player, command, template);
	}

	public ArrayList<String> createNewGame(Player player, String command, List<GameTemplate> template) {
		int number = Integer.parseInt(command);

		int gameid = 0;

		try {
			gameid = gameRealMapper.getMaxGameid() + number;
		} catch (Exception e) {
			gameid = 100;
		}

		gameRealMapper.newGameOpen(gameid, number, GStatus.准备开始.toString(), 0);

		log.debug("new game opened {}", gameid);

		rolesHandler.addGameRoles(gameid, template);

		playerMapper.updatePlayerInGame(player.getUserid(), "" + gameid, PStatus.入房成功.toString());
		player.setGameid(gameid);
		ArrayList<String> returns = new ArrayList<String>();

		returns.add(command);
		returns.add("" + gameid);
		returns.add(command);
		return returns;
	}

}
