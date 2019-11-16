package com.tydic.api.tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	public static String getNow() {
		return getNow("yyyy-MM-dd HH:mm:ss");
	}
	public static String getNow(String pattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}
}
