package com.zhiweiwang.gow.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhiweiwang.gow.mapper.PlayerMapper;
import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.Role;
import com.zhiweiwang.gow.utils.Constants;
import com.zhiweiwang.gow.utils.Utils;

public class UserInteceptor extends HandlerInterceptorAdapter {

	Logger log = LoggerFactory.getLogger(UserInteceptor.class);

	@Autowired
	PlayerMapper playerMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Cookie[] cookies = request.getCookies();
		Cookie co = null;
		log.debug("UserInteceptor ==>");
		if (cookies != null)
			for (Cookie coki : cookies) {
				if ("gow.userid".equals(coki.getName())) {

					String userid = coki.getValue();
					log.debug(userid);
					Player player = playerMapper.get(userid);
					if (player == null) {
						playerMapper.newPlayer(userid, Role.空闲.toString(), PStatus.空闲.toString());
						player = new Player();
						player.setUserid(userid);
						player.setRolename(Role.空闲.toString());
						player.setPstatus(PStatus.空闲.toString());
					} 
					request.getSession().setAttribute(Constants.PLAYER_IN_SESSION, player);
					co = coki;
					co.setMaxAge(Constants.Ten_Years);
					break;
				}
			}

		else {
			String userid = Utils.generationUser();
			log.debug(userid);
			co = new Cookie("gow.userid", userid);
			playerMapper.newPlayer(userid, Role.空闲.toString(), PStatus.空闲.toString());
			co.setMaxAge(Constants.Ten_Years);
		}
		response.addCookie(co);

		return true;
	}

}
