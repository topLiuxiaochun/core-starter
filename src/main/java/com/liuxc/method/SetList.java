/**
 * 
 */
package com.liuxc.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @since:2017年10月24日
 * @author:liuxc
 */
public class SetList {

	/**
	 * @param args
	 * @since:2017年10月24日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		Set<Integer> numSet = new TreeSet<Integer>();
		List<Integer> numList = new ArrayList<Integer>();
		
		for(int i=-3; i<3; i++){
			numSet.add(i);
			numList.add(i);
		}

		// 由于listremove方法调用重载的移除固定位置的元素，因此不能像预期那样能正常打印，这是因为Java1.5之后加入的新特性自动装箱和拆箱
		for(int i=0; i<3; i++){
			numSet.remove(i);
			numList.remove(i);
		}
		
		System.out.println(numSet + "" + numList);//[-3, -2, -1][-2, 0, 2]
	}

}
