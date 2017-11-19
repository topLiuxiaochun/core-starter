/**
 * 
 */
package com.liuxc.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.liuxc.hessian.client.service.BasicService;

/**
 * 客户端调用类
 * <p>
 * 远程调用框架Hessian客户端代码
 * @author dell
 *
 */
public class BasicClient {

	public static void main(String[] args) throws MalformedURLException {
		String urlName = "http://localhost:8088/core-starter/basic";
		HessianProxyFactory proxy = new HessianProxyFactory();
		BasicService proxyService = (BasicService) proxy.create(BasicService.class, urlName);

		System.out.println(proxyService.sum(5, 9));
		
		try {
			/**
			 * 尝试调用不存在的远程服务则会报错：The service has no method named: notRemoteService
			 */
			proxyService.notRemoteService();
		} catch (Exception e) {
			System.out.println("服务端不存在该方法错误");
			e.printStackTrace();
		}
	}

}

