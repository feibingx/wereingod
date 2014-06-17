package com.zhiweiwang.gow.engine.assemble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.mapper.GameRoleMapper;
import com.zhiweiwang.gow.model.GameRole;
import com.zhiweiwang.gow.model.GameTemplate;
import com.zhiweiwang.gow.model.Role;

@Component
public class GameRoleAssembleHandler {

	protected static Map<Integer, Queue<Role>> assemblerList = new HashMap<Integer, Queue<Role>>();
	
	Logger log = LoggerFactory.getLogger(GameRoleAssembleHandler.class);
	
	@Autowired
	GameRoleMapper gameRoleMapper;
	
	public void addGameRoles(int gameid, List<GameTemplate> template) {
		LinkedList<Role> list = new LinkedList<Role>();
		
		for(GameTemplate gt: template){
			gameRoleMapper.newGameRole(gameid, gt.getRolename(), gt.getRolenumber());
			
			for(int i=0; i<gt.getRolenumber(); i++)
				list.add(Role.valueOf(gt.getRolename()));
		}
		
		Collections.shuffle(list);
		
		log.debug("Game:"+gameid+" suffled list: ",list.toArray());
		
		assemblerList.put(gameid, list);
		
	}

	public synchronized Role getNextRole(int gameid) {
		
		Queue<Role> roleList = assemblerList.get(gameid);
		return roleList.poll();
	}

 
}
