package com.zhiweiwang.gow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhiweiwang.gow.model.GameTemplate;

public interface GameTemplateMapper {
	
	@Select("select confvalue from sysconf where confname=#{confname}")
	public String get(@Param("confname") String confname);

	@Select("select totalnumber, rolename, rolenumber from gametemplate where totolnumber=#{number}")
	public List<GameTemplate> getTemplate(@Param("number")int number);
	
}
