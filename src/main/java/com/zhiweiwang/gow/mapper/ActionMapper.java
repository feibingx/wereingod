package com.zhiweiwang.gow.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhiweiwang.gow.model.PStatus;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.WerewolfKill;

public interface ActionMapper {

	@Select("select * from player where userid=#{userid}")
	public WerewolfKill get(@Param("userid") String userid);


}
