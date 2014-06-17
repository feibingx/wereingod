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
	public void newPlayer(@Param("userid") String userid, @Param("rolename") String rolename, @Param("pstatus") String pstatus);

	@Update("update player set pstatus=#{pstatus} where userid=#{userid}")
	public int updatePlayerStatus(@Param("userid") String userid, @Param("pstatus") String pstatus);

	@Update("update player set rolename=#{rolename} where userid=#{userid}")
	public void updatePlayerRole(@Param("userid")String userid, @Param("rolename")String rolename);

	@Update("update player set rolename=#{rolename}, cardnumber=#{number} where userid=#{userid}")
	public void updatePlayerNumberRole(@Param("userid")String userid, @Param("rolename")String rolename,@Param("number") String command);

	@Select("select * from player where gameid=#{gameid} and cardnumber=#{number}")
	public Player queryPlayerNumberInGame(@Param("gameid")int gameid,@Param("number") String command);

	@Update("update player set gameid=#{gameid},rolename=#{rolename} where userid=#{userid}")
	public void updatePlayerInGame(@Param("userid")String userid,@Param("gameid") String gameid,@Param("rolename") String role);
}
