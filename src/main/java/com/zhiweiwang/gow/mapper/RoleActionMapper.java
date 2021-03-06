package com.zhiweiwang.gow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhiweiwang.gow.model.RoleAction;

public interface RoleActionMapper {
	@Select("Select * from roleaction where rolename=#{rolename} and gstatus=#{gstatus} and command=#{command}")
	RoleAction getRoleAction(@Param("rolename") String rolename, @Param("gstatus") String gstatus,
			@Param("command")String command);
	
	@Select("Select * from roleaction where rolename=#{rolename} and gstatus=#{gstatus}")
	List<RoleAction> getRoleActionHelp(String rolename, String gstatus);

	// RoleAction getRoleAction(@Param("rolename") String rolename,
	// @Param("gstatus") String gstatus,@Param("command") String command);

}
