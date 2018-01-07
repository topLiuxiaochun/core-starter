/**
 * 
 */
package com.liuxc.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Java SE7新特性之try-with-resources语句。参考地址http://blog.csdn.net/jackiehff/article/details/17765909
 * 
 * @since:2018年1月7日
 * @author:liuxc
 */
public class FileReaderUtil {

	/**
	 * @param args
	 * @since:2018年1月7日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		try {
			String content = read("C:/liuxc_resource/超爱财金融/凌杂个人资料/个人介绍.txt");
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String read(String path) throws FileNotFoundException, IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
			StringBuilder builder = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(String.format("%n"));
			}
			return builder.toString();
		}
	}
}
