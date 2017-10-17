/**
 * 
 */
package com.liuxc.hessian.server;

/**
 * 服务端暴露接口供rpc调用
 * @since:2017年10月17日
 * @author:liuxc
 */
public interface BasicService {

	String getIntfName();
	
	String getSum(Integer a, Integer b);
}
