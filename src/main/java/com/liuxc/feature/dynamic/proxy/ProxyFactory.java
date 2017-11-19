package com.liuxc.feature.dynamic.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static UserServiceV2 createProxy(UserServiceV1 service) {
		ProxyAdaptor adaptor = new ProxyAdaptor(service);
		
		// TODO 为什么需要UserServiceV1的类加载器？
		ClassLoader cl = service.getClass().getClassLoader();
		
		return (UserServiceV2) Proxy.newProxyInstance(cl, new Class<?>[]{UserServiceV2.class}, adaptor);
	}
}
