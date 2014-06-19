package com.zhiweiwang.gow.utils;

import java.util.HashMap;
import java.util.Map;

import com.zhiweiwang.gow.model.Role;

public class RoleModelTransfor {

	protected static Map<String, Role> nameMapping = new HashMap<String, Role>(){{
		this.put("cupid", Role.丘比特);
		this.put("seer", Role.先知);
		this.put("witch", Role.女巫);
		this.put("gardian", Role.守卫);
		this.put("roomowner", Role.房主);
		this.put("village", Role.普通村民);
		this.put("sheep", Role.替罪羊);
		this.put("wolves", Role.狼人);
		this.put("hunter", Role.猎人);
		this.put("thief", Role.盗贼);
	}};
	
	public static Role mappingRolename(String englishName){
		return nameMapping.get(englishName);
	}
}
