package com.zhiweiwang.gow.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GameRealMapper {
	
	@Select("select confvalue from sysconf where confname=#{confname}")
	public String get(@Param("confname") String confname);

	@Select("select gstatus from gamereal where id=#{gameid}")
	public String getGstatus(@Param("gameid")String gameid);
	
	//@Insert("")
}
