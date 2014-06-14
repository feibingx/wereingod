package com.zhiweiwang.gow.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GameRealMapper {

	@Select("select confvalue from sysconf where confname=#{confname}")
	public String get(@Param("confname") String confname);

	@Select("select gstatus from gamereal where id=#{gameid}")
	public String getGstatus(@Param("gameid") int gameid);

	@Select("select max(gameid) from gamereal")
	public int getMaxGameid();

	@Insert("insert into gamereal(gameid, totalplayer, gstatus, daycount, lastchanged) values(#{gameid},#{totalplayer},#{gstatus},#{daycount},now())")
	public void newGameOpen(@Param("gameid") int gameid, @Param("totalplayer") int totalplayer, @Param("gstatus") String gstatus,
			@Param("daycount") int daycount);

	// @Insert("")
}
