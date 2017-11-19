/**
 * 
 */
package com.liuxc.hessian.server;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.liuxc.entity.UserVO;

/**
 * 服务端暴露接口供rpc调用
 * @since:2017年10月17日
 * @author:liuxc
 */
public interface BasicService {

	String getIntfName();
	
	/**
	 * 两数之和
	 * @param a
	 * @param b
	 * @return
	 * @since:2017年10月19日
	 * @author:liuxc
	 */
	String sum(Integer a, Integer b);
	/**
	 * 获取所有用户
	 * @return
	 * @since:2017年11月19日
	 * @author:liuxc
	 */
	JSONArray listUserAll();
}
