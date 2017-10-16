package com.liuxc.dozer.converter;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.liuxc.entity.UserPO;
import com.liuxc.entity.UserVO;
/**
 * 使用dozer工具实现实体bean转换。参考 http://blog.csdn.net/windrui/article/details/52116999
 * 
 * @since:2017年10月16日
 * @author:liuxc
 */
public class DozerConverter {

	public static void main(String[] args) {
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("user-dozer-mapping.xml");
		Mapper mapper = new DozerBeanMapper(mappingFiles);
		
		UserPO userPO = new UserPO();
		userPO.setUserId("sss001");
		userPO.setUserName("sssSnow");
		userPO.setNickName("nickSnow");
		userPO.setSex("1");

		UserVO userVO = mapper.map(userPO, UserVO.class);
		
		System.out.println(userVO);
	}

}
