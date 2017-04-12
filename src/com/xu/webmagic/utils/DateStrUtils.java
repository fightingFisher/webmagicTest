package com.xu.webmagic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStrUtils {
	public static Date StrChangeDate(String sb) {
		Date result = null;
		try {
			SimpleDateFormat biaozhun = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			result = biaozhun.parse(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
