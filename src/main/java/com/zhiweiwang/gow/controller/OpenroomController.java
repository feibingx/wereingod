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
public class OpenroomController {

	@Autowired
	PlayerMapper playerMapper;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GameEngine gameEngine;

	@Autowired
	GameCounting gameCounting;

	@Autowired
	PlayerMapper playMapper;

	@RequestMapping("/open")
	public void index(String userid, HttpSession session) {
		if (userid == null)
			return;
		Player player = playMapper.get(userid);
		if (player == null) {
			log.debug("new player: {}", userid);
			playMapper.newPlayer(userid, Role.空闲.toString(), PStatus.空闲.toString());
			player = new Player();
			player.setRolename(Role.空闲.toString());
			player.setPstatus(PStatus.空闲.toString());
		}
		session.setAttribute(Constants.PLAYER_IN_SESSION, player);
	}

	@RequestMapping("/openroom")
	public void index2() {
	}

	@RequestMapping(value = "/openroom", method = RequestMethod.POST)
	public void openroom(HttpServletRequest request) {
		log.info("openroom");
		String number = request.getParameter("totalnumber");

		Enumeration<?> names = request.getParameterNames();
		List<GameTemplate> templates = new ArrayList<GameTemplate>();
		while (names.hasMoreElements()) {
			String name = names.nextElement().toString();
			String value = request.getParameter(name);
			log.info(name + ":" + value);

			if ("off".equals(value) == false && RoleModelTransfor.mappingRolename(name) != null) {
				GameTemplate t = new GameTemplate();
				t.setRolename(RoleModelTransfor.mappingRolename(name).toString());
				t.setTotalplayer(Integer.parseInt(number));
				if ("on".equals(value) == true) {
					t.setRolenumber(1);
				} else {
					t.setRolenumber(Integer.parseInt(value));
				}
				templates.add(t);
			}
		}

		// TODO player
		Player player = (Player) request.getSession().getAttribute(Constants.PLAYER_IN_SESSION);
		gameCounting.createNewGame(player, number, templates);

		log.info("ok");
	}
}
