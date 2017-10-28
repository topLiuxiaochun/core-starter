/**
 * 
 */
package com.liuxc.effective.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liuxc.entity.UserVO;

/**
 * 方法设计遵循原则
 * @since:2017年10月24日
 * @author:liuxc
 */
public class MethodUtil {

	/**
	 * @param args
	 * @since:2017年10月24日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		int[] orderArr = new int[]{1,3,5,7,9};
		asListTest(orderArr);// [[I@c2e1f26]
		
		String[] objArr = new String[]{"1","3","5","7","9"};
		asListTest(objArr);// [1, 3, 5, 7, 9]
		
		Integer[] integerArr = new Integer[]{1,3,5,7,9};
		asListTest(integerArr);// [1, 3, 5, 7, 9]
		
		toStringTest(orderArr);
		
		list2Array();
	}
	
	/******************慎用重载***********************/
	
	
	/******************慎用可变参数***********************/
	/**
	 * int数组调用Arrays.asList(arr)方法打印得不到预期结果
	 * @param arr
	 * @since:2017年10月24日
	 * @author:liuxc
	 */
	public static void asListTest(int[] arr) {
		System.out.println("Arrars.asList(int[] o):" + Arrays.asList(arr));
	}
	
	/**
	 * int数组调用Arrays.asList(arr)方法打印得不到预期结果
	 * @param arr
	 * @since:2017年10月24日
	 * @author:liuxc
	 */
	public static void asListTest(Object[] arr) {
		System.out.println("Arrars.asList(Object[] o):" + Arrays.asList(arr));
	}
	/**
	 * Java 1.5发行版中 Arrays类得到了补充完整的Arrays.toString方法，专门为了将任何类型的数组转变成字符串而设计的。
	 * @param arr
	 * @since:2017年10月25日
	 * @author:liuxc
	 */
	public static void toStringTest(int[] arr) {
		System.out.println("Arrars.toString(int[] o):" + Arrays.toString(arr));
	}
	
	/******************返回零长度的数组或者集合，而不是null***********************/
	public static final UserVO[] EMPTY_TABLE = new UserVO[0];
	public static UserVO[] list2Array() {
		UserVO user1 = new UserVO();
		user1.setCustomerId("c001");
		user1.setCustomerName("jame");
		UserVO user2 = new UserVO();
		user2.setCustomerId("c002");
		user2.setCustomerName("jame2");
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(user1);
		userList.add(user2);
		userList.clear();
		return userList.toArray(EMPTY_TABLE);
		
	}
	
	/******************为所有导出的API元素编写文档注释***********************/

}
