package com.zhiweiwang.gow.engine.assemble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.mapper.GameRoleMapper;
import com.zhiweiwang.gow.model.GameRole;
import com.zhiweiwang.gow.model.GameTemplate;
import com.zhiweiwang.gow.model.Role;

@Component
public class GameRoleAssembleHandler {

	protected static Map<Integer, List<Role>> assemblerList = new HashMap<Integer, List<Role>>();
	
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
		assemblerList.put(gameid, list);
		
	}

 
}
