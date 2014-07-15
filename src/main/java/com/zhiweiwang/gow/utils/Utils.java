package com.zhiweiwang.gow.utils;

import java.util.UUID;

public class Utils {

	public static String generationUser() {
		// TODO 
		UUID uuid = UUID.randomUUID();      

		return uuid.toString();
	}

}
