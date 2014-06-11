package com.zhiweiwang.gow.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;

public interface PlayerMapper {

	@Select("select * from player where userid=#{userid}")
	public Player get(@Param("userid") String userid);

	@Insert("Insert into player(userid, rolename, pstatus) values(#{userid},#{rolename},#{pstatus})")
	public void newPlayer(@Param("userid") String userid,
			@Param("rolename") String rolename,
			@Param("pstatus") String pstatus);

	@Update("update player set pstatus=#{pstatus} where userid=#{userid}")
	public int updatePlayerStatus(@Param("userid")String userid,@Param("pstatus") String pstatus);
}
