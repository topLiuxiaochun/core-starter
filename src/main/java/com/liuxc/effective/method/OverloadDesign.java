/**
 * 
 */
package com.liuxc.effective.method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 《effective Java》之慎用重载，然而重写则不会出现这样的问题，重写是在运行时确定具体的实例方法进行调用
 * @since:2017年10月22日
 * @author:liuxc
 */
public class OverloadDesign {
//	方法1
	public static String classify(Set<?> s) {
		return "set";
	}
//	方法2
	public static String classify(List<?> list) {
		return "list";
	}
//	方法3
	public static String classify(Collection<?> collection) {
		return "collection";
	}
//	方法4能替换掉方法1/2/3的程序意图，这是最佳修正方式
	public static String basicClassify(Collection<?> collection) {
		return collection instanceof Set ? "Set" : collection instanceof List ? "List" : "collection"; 
		
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
			System.out.println(basicClassify(c));// 打印三次collection。因为重载时调用哪个方法是编译期决定的。
		}
	}

}
