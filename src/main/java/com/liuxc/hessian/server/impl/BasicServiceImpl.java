/**
 * 
 */
package com.liuxc.hessian.server.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.caucho.hessian.server.HessianServlet;
import com.liuxc.entity.UserVO;
import com.liuxc.hessian.server.BasicService;

/**
 * 服务端暴露接口实现
 * @since:2017年10月17日
 * @author:liuxc
 */
public class BasicServiceImpl extends HessianServlet implements BasicService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getIntfName() {
		return this.getClass().getSuperclass().getName();
	}

	@Override
	public String sum(Integer a, Integer b) {
		Integer sum = a + b;
		return sum.toString();
	}

	@Override
	public JSONArray listUserAll() {
		List<UserVO> userList = new ArrayList<UserVO>();
		for(int i=0; i<=45; i++) {
			UserVO user = new UserVO();
			user.setCustomerId("" + i);
			user.setCustomerName("顾客" + i);
			user.setSex(i/2==0?"女":"男");
			user.setNickName("");
			userList.add(user);
		}
		JSONArray userArray = new JSONArray();
		userArray.add(userList);
		return userArray;
	}

}
