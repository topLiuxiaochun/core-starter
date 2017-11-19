package com.liuxc.feature.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 拦截UserServiceV1的getUserInfo接口，调用入口是UserServiceV2中getUserInfo方法。
 * 
 * @since:2017年11月20日
 * @author:liuxc
 */
public class ProxyAdaptor implements InvocationHandler {
	
	private UserServiceV1 userServiceV1;

	public ProxyAdaptor(UserServiceV1 userServiceV1) {
		this.userServiceV1 = userServiceV1;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		if("getUserInfo".equals(methodName)) {
			String name = "0001";
			String dept = "3020";
			
			Method methodV1 = UserServiceV1.class.getMethod(methodName, new Class<?>[]{String.class, String.class});
			return methodV1.invoke(userServiceV1, new Object[]{name, dept});
		} else {
			return method.invoke(proxy, args);
		}
	}

}
