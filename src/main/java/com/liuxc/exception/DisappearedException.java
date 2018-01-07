/**
 * 
 */
package com.liuxc.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 消失的异常
 * @since:2018年1月7日
 * @author:liuxc
 */
public class DisappearedException {

	/**
	 * @param args
	 * @since:2018年1月7日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		try {
			show();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		try {
			catchAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * finally里面的异常抑制了catch中异常抛出
	 * @throws DataAccessException
	 * @since:2018年1月7日
	 * @author:liuxc
	 */
	@SuppressWarnings("unused")
	public static void show() throws DataAccessException {
		
		try {
			Integer i = Integer.parseInt("java");
		} catch (NumberFormatException e) {
			throw new DataAccessException(e);
		} finally {
			try {
				int result = 2/0;
			} catch (ArithmeticException e) {
				throw new DataAccessException(e);
			}
		}
	}

	public static void catchAll() throws IOException {
		
		FileInputStream input = null;
		IOException ioe = null;
		
		try {
			input = new FileInputStream("data.txt");
		} catch (IOException e) {
			ioe = e;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					if (ioe != null) {
						ioe.addSuppressed(e);
					} else {
						ioe = e;
					}
				}
			}
			if (ioe != null) {
				throw ioe;
			}
		}
	}
}
