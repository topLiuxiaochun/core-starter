package com.liuxc.math;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class RandomUtil {

	private static SimpleDateFormat defaultDateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	
	public static void main(String[] args) {
		String num1 = String.valueOf( ((Math.random() * 9 + 1)));
		System.out.println(num1);
		String num = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
		System.out.println(num);
		
		System.out.println(makeUUIDWithTime());
	}

	/**
	 * 生成uuid加入时间处理
	 * @return
	 */
	public static synchronized String makeUUIDWithTime() {
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid=" + uuid.toString());
		String uuidStr = uuid.toString().replaceAll("-", "");
		System.out.println("uuidStr=" + uuidStr);
		StringBuilder sb = new StringBuilder();
		String currentTime = defaultDateFormat.format(new Date());
		System.out.println("currentTime=" + currentTime);
		sb.append(currentTime).append(uuidStr.substring(currentTime.length(), 32));
		return sb.toString();
	}
}
