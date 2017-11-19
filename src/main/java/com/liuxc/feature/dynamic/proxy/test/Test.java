package com.liuxc.feature.dynamic.proxy.test;

import com.liuxc.feature.dynamic.proxy.ProxyFactory;
import com.liuxc.feature.dynamic.proxy.UserServiceV1;
import com.liuxc.feature.dynamic.proxy.UserServiceV2;
import com.liuxc.feature.dynamic.proxy.impl.UserServiceV1Impl;

public class Test {

	public static void main(String[] args) {
		UserServiceV1 service = new UserServiceV1Impl();
		UserServiceV2 service2 = ProxyFactory.createProxy(service);
		
		System.out.println(service2.getUserInfo(""));
	}

}
