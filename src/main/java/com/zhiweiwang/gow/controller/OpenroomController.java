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
public class OpenroomController {

	@Autowired
	PlayerMapper playerMapper;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GameEngine gameEngine;


	@RequestMapping("/openroom")
	public void index() {
	}
}
