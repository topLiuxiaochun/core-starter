/**
 * 
 */
package com.liuxc.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 抛出异常中封装捕捉到的异常
 * @since:2018年1月7日
 * @author:liuxc
 */
public class DataAccessGateway {

	@SuppressWarnings({ "unused", "resource" })
	public void load() throws DataAccessException {
		try {
			
			FileInputStream input = new FileInputStream("data.txt");
			
		} catch (IOException e) {
			throw new DataAccessException(e);
		}
		
	}
}
