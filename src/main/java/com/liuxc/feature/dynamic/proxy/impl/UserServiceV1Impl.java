package com.liuxc.feature.dynamic.proxy.impl;

import com.liuxc.feature.dynamic.proxy.UserServiceV1;

public class UserServiceV1Impl implements UserServiceV1 {

	@Override
	public String getUserInfo(String name, String dept) {
		return "第一版接口实现";
	}

}
