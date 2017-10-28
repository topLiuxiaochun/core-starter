/**
 * 
 */
package com.liuxc.effective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liuxc.entity.UserVO;

/**
 * 第八章 通用程序设计
 * @since:2017年10月28日
 * @author:liuxc
 */
public class CommonUtil {
	
	
	enum Suit { club, diamond, heart, spade	}
	
	enum Rank { ace, deuce, three, four, five, six, seven, eight, nine, ten, jack, queen, king }

	/**
	 * @param args
	 * @since:2017年10月28日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		
		getUserList();
		
//		viewSuit();
	}
	/***********for-each循环优先于传统的循环***********/
	/**
	 * 
	 * 错误写法抛出异常 java.util.NoSuchElementException 原因是外循环在没加判断下一直被内循环调用next方法
	 * 
	 * @since:2017年10月28日
	 * @author:liuxc
	 */
	public static void getUserList() {
		
		Collection<Suit> suits = Arrays.asList(Suit.values());
		Collection<Rank> Ranks = Arrays.asList(Rank.values());
		
		List<UserVO> userList = new ArrayList<UserVO>();
		//错误写法
		
		for (Iterator iterator = suits.iterator(); iterator.hasNext();) {
			for (Iterator iterator2 = Ranks.iterator(); iterator2.hasNext();) {
				System.out.println("userList：" + userList);
				userList.add(new UserVO(iterator.next().toString(), iterator2.next().toString()));			
			}
		}
		
		//修正写法
		/*
		for (Iterator iterator = suits.iterator(); iterator.hasNext();) {
			String suitKey = iterator.next().toString();
			for (Iterator iterator2 = Ranks.iterator(); iterator2.hasNext();) {
				userList.add(new UserVO(suitKey, iterator2.next().toString()));			
			}
		}
		*/
		System.out.println("userList：" + userList);
		
	}

	/**
	 * 改程序不会抛出异常，只会打印重复的值，程序打印结果：
	 * <p>
	 * suitMap：{diamond=diamond, club=club, spade=spade, heart=heart}
	 * 
	 * @since:2017年10月28日
	 * @author:liuxc
	 */
	public static void viewSuit() {
		Collection<Suit> suits = Arrays.asList(Suit.values());
		
		Map<String, String> suitMap = new HashMap<String, String>();
		//错误写法
		
		for (Iterator iterator = suits.iterator(); iterator.hasNext();) {
			for (Iterator iterator2 = suits.iterator(); iterator2.hasNext();) {
				suitMap.put(iterator.next().toString(), iterator2.next().toString());
			}
		}
		
		//修正写法
		/*
		for (Iterator iterator = suits.iterator(); iterator.hasNext();) {
			String key = iterator.next().toString();
			for (Iterator iterator2 = suits.iterator(); iterator2.hasNext();) {
				String value = iterator2.next().toString();
				suitMap.put(key + "_" + value, key + "_" + value);
			}
		}
		*/
		System.out.println("suitMap：" + suitMap);
		System.out.println("suitMap长度：" + suitMap.size());
	}
	/***********for-each循环优先于传统的循环***********/
	
}
