/**
 * 
 */
package com.liuxc.exception;

/**
 * 统一数据访问层异常。JDK1.7之后在抛出异常构造方法中传入捕捉到的异常
 * @since:2018年1月7日
 * @author:liuxc
 */
public class DataAccessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAccessException() {
		super();
	}

	public DataAccessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	
	
}
