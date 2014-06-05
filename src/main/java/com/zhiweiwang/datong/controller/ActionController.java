package com.zhiweiwang.datong.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActionController {

	@RequestMapping("/action")
	public Map<String, String> process(String userid, String command) {
		 return null;
	}

	@RequestMapping("/index")
	public void index(){}
}
