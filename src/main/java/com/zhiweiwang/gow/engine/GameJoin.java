package com.zhiweiwang.gow.engine;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.exception.GameStatusException;
import com.zhiweiwang.gow.mapper.GameRealMapper;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.Game;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;

@Component("GameJoin")
public class GameJoin implements GameRoleAction {
 
	Logger log = LoggerFactory.getLogger(GameJoin.class);
	@Autowired
	GameRealMapper gameMapper;
	
	@Autowired
	PlayerMapper playerMapper;
	
	public ArrayList<String> action(Player player, String gstatus, String command) throws GameStatusException {

		Game game = gameMapper.getGame(Integer.parseInt(command));
		if(game == null || game.getGstatus() == null){
			throw new GameStatusException("没有找到房间，请重新确认房间号码再输入");
		}
		log.debug("game join room:{}", command);
		
		int count = gameMapper.getRealTotalPlayerCount(command,PStatus.入房成功.toString());
		if(count >= game.getTotalplayer()){
			throw new GameStatusException("房间已满，不能再加入。");
		}
		playerMapper.updatePlayerInGame(player.getUserid(), command, PStatus.入房成功.toString());

		return null;
	}

}

 