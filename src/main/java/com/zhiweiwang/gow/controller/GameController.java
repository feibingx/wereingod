package com.zhiweiwang.gow.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zhiweiwang.gow.engine.GameCounting;
import com.zhiweiwang.gow.engine.GameEngine;
import com.zhiweiwang.gow.engine.assemble.GameRoleAssembleHandler;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.GameTemplate;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;
import com.zhiweiwang.gow.utils.Constants;
import com.zhiweiwang.gow.utils.RoleModelTransfor;

@Controller 
public class GameController {

	@Autowired
	PlayerMapper playerMapper;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GameEngine gameEngine;

	@Autowired
	GameCounting gameCounting;
 
  	@RequestMapping(value="/game",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> game(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		
		Enumeration<?> names = request.getParameterNames(); 
		while (names.hasMoreElements()) {
			String name = names.nextElement().toString();
			String value = request.getParameter(name);
			log.info(name + ":" + value);
			
			map.put(name,value);
		}
		
		return map;
	}
	
	@RequestMapping("game")
	public void getGame(){}
 
}
