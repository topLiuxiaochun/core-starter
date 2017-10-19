/**
 * 
 */
package com.liuxc.hessian.client.service;

/**
 * 客户端服务接口必须和服务端接口保持一致
 * @author dell
 *
 */
public interface BasicService {

	String getIntfName();
	
	/**
	 * 两数之和
	 * @param a
	 * @param b
	 * @return
	 * @since:2017年10月19日
	 * @author:liuxc
	 */
	String sum(Integer a, Integer b);
	
	String notRemoteService();
}
