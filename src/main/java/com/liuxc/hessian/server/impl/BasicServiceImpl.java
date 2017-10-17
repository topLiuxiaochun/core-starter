/**
 * 
 */
package com.liuxc.hessian.server.impl;

import com.caucho.hessian.server.HessianServlet;
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
	public String getSum(Integer a, Integer b) {
		Integer sum = a + b;
		return sum.toString();
	}

}
