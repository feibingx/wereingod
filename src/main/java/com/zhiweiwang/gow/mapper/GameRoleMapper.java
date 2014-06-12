package com.zhiweiwang.gow.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GameRoleMapper {

	@Insert("insert into gamerole(gameid, rolename, rolecount, rolecountreal, lastchanged) values(#{gameid},#{rolename},#{rolenumber},#{rolenumber},now()")
	void newGameRole(@Param("gameid") int gameid,
			@Param("rolename") String rolename,
			@Param("rolenumber") int rolenumber);

}
