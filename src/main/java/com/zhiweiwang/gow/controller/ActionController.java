package com.zhiweiwang.gow.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiweiwang.gow.engine.GameEngine;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.Player;

@Controller
public class ActionController {

	@Autowired
	PlayerMapper playerMapper;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GameEngine gameEngine;

	@RequestMapping("/action")
	@ResponseBody
	public Map<String, String> process(
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "command", required = false) String command) {
		log.info("user: {} \t command: {}", new Object[] { userid, command });

		Player player = playerMapper.get(userid);
		
		if(player == null)
			player = gameEngine.newPlayer(userid);
		
		String text = gameEngine.deal(player, command);
		
		log.info(text);
		Map<String, String> map = new HashMap<String, String>();
		map.put("text", text);
		return map;
	}

	@RequestMapping("/index")
	public void index() {
	}
}
