package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.engine.assemble.GameRoleAssembleHandler;
import com.zhiweiwang.gow.exception.GameStatusException;
import com.zhiweiwang.gow.mapper.GameRealMapper;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.Game;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;

@Component("GameNumber")
public class GameNumber implements GameRoleAction {

	Logger log = LoggerFactory.getLogger(GameNumber.class);
	@Autowired
	GameRealMapper gameMapper;

	@Autowired
	PlayerMapper playerMapper;

	@Autowired
	GameRoleAssembleHandler roleHandler;

	// 输入号码成功,你的号码是##,你的身份是##。##
	public ArrayList<String> action(Player player, String gstatus, String command) throws GameStatusException {

		Player otherPlayer = playerMapper.queryPlayerNumberInGame(player.getGameid(), command);

		if (otherPlayer != null) {
			throw new GameStatusException("已经有其他用户使用了该号码，请重新输入号码获取身份。");
		}
		Game game = gameMapper.getGame(player.getGameid());

		int number = Integer.parseInt(command);
		if (number < 1 || number > game.getTotalplayer()) {
			throw new GameStatusException("你输入的数字不正确，请输入1-" + game.getTotalplayer() + "之间的数字");
		}
		Role role = roleHandler.getNextRole(player.getGameid());
		player.setRolename(role.name());
		playerMapper.updatePlayerNumberRole(player.getUserid(), role.name(), command);

		ArrayList<String> values = new ArrayList<String>();
		values.add(command);
		values.add(role.name());
		values.add(role.getSpecialRoleAction());
		return values;
	}

}
