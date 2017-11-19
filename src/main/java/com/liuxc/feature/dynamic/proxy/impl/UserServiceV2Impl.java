package com.liuxc.feature.dynamic.proxy.impl;

import com.liuxc.feature.dynamic.proxy.UserServiceV2;

public class UserServiceV2Impl implements UserServiceV2 {

	@Override
	public String getUserInfo(String userName) {
		return "第二版接口实现";
	}

}
