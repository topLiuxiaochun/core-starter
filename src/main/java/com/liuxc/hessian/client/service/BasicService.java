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
	
	String getSum(Integer a, Integer b);
	
	String notRemoteService();
}
