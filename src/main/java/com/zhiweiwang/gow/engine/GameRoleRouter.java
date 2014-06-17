package com.zhiweiwang.gow.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.zhiweiwang.gow.exception.GameStatusException;
import com.zhiweiwang.gow.mapper.RoleActionMapper;
import com.zhiweiwang.gow.model.Player;
import com.zhiweiwang.gow.model.RoleAction;

@Component(value = "game")
public class GameRoleRouter implements ApplicationContextAware {

	Logger log = LoggerFactory.getLogger(GameRoleRouter.class);

	ApplicationContext appContext;

	@Autowired
	RoleActionMapper roleActionMapper;

	public void setApplicationContext(ApplicationContext _appContext) throws BeansException {
		this.appContext = _appContext;

	}

	public String handle(Player player, String gstatus, String c) {

		String command = transforCommand(c);
		log.debug("transfor command: {}", command);
		RoleAction roleAction = roleActionMapper.getRoleAction(player.getRolename(), gstatus,command);
		if (roleAction == null) {
			return help(player, gstatus);
		}
		GameRoleAction node = (GameRoleAction) appContext.getBean(roleAction.getBeanId());
		String text;
		try {
			text = fixString(roleAction.getFeedback(), node.action(player, gstatus, c));
		} catch (GameStatusException e) {
			text = e.getFeedbackText();
		}

		//gameStatusRunner(text);
		return text;
		// ender swapper 
	}

	private String help(Player player, String gstatus) {
		List<RoleAction> roleAction = roleActionMapper.getRoleActionHelp(player.getRolename(), gstatus);
		String string = "命令不合法。用户<"+player.getUserid()+">当前状态是："+player.getRolename()+" 可以使用的命令有：";
		for(RoleAction ra:roleAction){
			string +=ra.getCommandtext()+"/";
		}
		return string;
	}

	private String fixString(String feedback, ArrayList<String> values) {
		if (values == null)
			return feedback;
		String[] strings = feedback.split("##");
		StringBuffer text = new StringBuffer();

		int i = 0;
		for (i = 0; i < values.size(); i++) {
			text.append(strings[i]);
			text.append(values.get(i));
		}
		for (; i < strings.length ; i++)
			text.append(strings[i]);
		return text.toString();
	}

	private String transforCommand(String command) {
		try {
			int number = Integer.parseInt(command);
			if (number > -1)
				return "number";
		} catch (NumberFormatException e) {
			return command;
		}
		return command;
	}

}
