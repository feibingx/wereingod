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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zhiweiwang.gow.engine.GameCounting;
import com.zhiweiwang.gow.engine.GameEngine;
import com.zhiweiwang.gow.engine.GameNumber;
import com.zhiweiwang.gow.engine.assemble.GameRoleAssembleHandler;
import com.zhiweiwang.gow.exception.GameStatusException;
import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.GameTemplate;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;
import com.zhiweiwang.gow.utils.Constants;
import com.zhiweiwang.gow.utils.RoleModelTransfor;

@Controller 
@SessionAttributes(Constants.PLAYER_IN_SESSION)
public class CardNumberController {

 

	Logger log = LoggerFactory.getLogger(this.getClass());


	@Autowired
	GameNumber gameNumber;
 
	@RequestMapping("/card")  
	public ModelAndView card(HttpSession session){
		ModelAndView mav = new ModelAndView("card");
		Integer number =  Integer.parseInt(session.getAttribute(Constants.GAME_NUMBER_IN_SESSION).toString());
		String gameid = session.getAttribute(Constants.GAME_ID_IN_SESSION).toString();
		log.debug("number {}",number);
		log.debug("game id {}", gameid);
		
		mav.addObject("number", number);
		mav.addObject("gameid", gameid);
		return mav;
	}
	
  	@RequestMapping(value="/card",method=RequestMethod.POST)
	//@ResponseBody
	public ModelAndView game(String cardnumber, String nickname, @ModelAttribute(Constants.PLAYER_IN_SESSION)Player player) { //HttpServletRequest request) {
 

  		try {
			ArrayList<String> params = gameNumber.action(player, null, cardnumber); 
		} catch (GameStatusException e) { 
			e.getFeedbackText();
		}
  		 
		return new ModelAndView("redirect:/game");
	}
	
 
 
}
