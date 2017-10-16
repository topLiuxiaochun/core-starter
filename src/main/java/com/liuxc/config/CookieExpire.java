/**
 * 
 */
package com.liuxc.config;

/**
 * @author dell
 *
 */
public enum CookieExpire {

	/**
	 * FIFTEEN 15min
	 * THIRTY  30min
	 * FOURTY_FIVE 45min
	 * SIXTY   60min
	 */
	FIFTEEN(15), THIRTY(30), FOURTY_FIVE(45), SIXTY(60);

	private int expireTime; 
	
	private CookieExpire(int expireTime){
		System.out.println(expireTime);
		this.expireTime = expireTime;
	}

	public int getExpireTime() {
		return expireTime * 60;
	}
}
