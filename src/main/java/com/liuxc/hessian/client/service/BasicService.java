/**
 * 
 */
package com.liuxc.hessian.client.service;

/**
 * 客户端服务接口
 * @author dell
 *
 */
public interface BasicService {

	String getIntfName();
	
	String getSum(Integer a, Integer b);
	
	String notRemoteService();
}
