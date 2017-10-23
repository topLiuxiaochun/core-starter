/**
 * 
 */
package com.liuxc.method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 《effective Java》之慎用重载
 * @since:2017年10月22日
 * @author:liuxc
 */
public class OverloadDesign {
	
	public static String classify(Set<?> s) {
		return "set";
	}
	
	public static String classify(List<?> list) {
		return "list";
	}
	
	public static String classify(Collection<?> collection) {
		return "collection";
	}

	/**
	 * @param args
	 * @since:2017年10月22日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		Collection<?>[] collections = {
				new HashSet<String>(),
				new ArrayList<String>(),
				new HashMap<String, String>().values()};

		for (Collection<?> c : collections) {
			System.out.println(classify(c));// 打印三次collection。因为重载时调用哪个方法是编译期决定的。
		}
	}

}
