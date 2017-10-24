/**
 * 
 */
package com.liuxc.method;

import java.util.Arrays;

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
		System.out.println(Arrays.asList(arr));
	}
	
	/**
	 * int数组调用Arrays.asList(arr)方法打印得不到预期结果
	 * @param arr
	 * @since:2017年10月24日
	 * @author:liuxc
	 */
	public static void asListTest(Object[] arr) {
		System.out.println(Arrays.asList(arr));
	}
	
	/******************返回零长度的数组或者集合，而不是null***********************/
	
	/******************为所有导出的API元素编写文档注释***********************/

}
