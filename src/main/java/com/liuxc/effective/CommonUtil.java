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
import java.util.Random;

import com.liuxc.entity.UserPO;
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
		
//		getUserList();
		
//		viewSuit();
		
//		randomInt(30);
		
		appendWithStringClazz();
		
		appendWithStringBuilderClazz();
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
	
	/***********了解和使用类库***********/
	
	/**
	 * 产生0到某个上界之间的随机整数
	 * @param n
	 * @return
	 * @since:2017年10月28日
	 * @author:liuxc
	 */
	public static int randomInt(int n) {
		Random r = new Random();
		System.out.println(r.nextInt(n));
		return r.nextInt(n);
	}
	/***********了解和使用类库***********/
	
	/***********想要得到精确的答案，请避免使用float和double***********/
	/*float和double只提供近似的值而设计的，特别不适合用于货币计算*/
	
	/***********想要得到精确的答案，请避免使用float和double***********/
	/*
	什么时候使用装箱基本类型？他们有几个合理的用处。第一个是作为集合中的元素、键和值。你不能将基本类型放入集合中，因此必须使用装箱基本类型。
	这是一种更通用的特例。在参数化类型中，必须使用装箱基本类型作为类型参数，因为Java不允许使用基本类型。
	*/
	
	/***********基本类型优先于装箱基本类型***********/
	
	/***********如果其他类型更合适，则尽量避免使用字符串***********/
	
	private static final ThreadLocal<UserPO> local = new ThreadLocal<UserPO>();
	
	
	/***********如果其他类型更合适，则尽量避免使用字符串***********/
	
	/***********当心字符串连接的性能***********/
	
	/**
	 * 时间开销随着项目数量呈平方级增加。原则很简单，不要使用字符串连接操作符连接多个字符串，除非性能无关紧要。相反应该使用StringBuilder的append方法。
	 * 另外使用字符数组，或者每次操作一个字符串，而不是将他们组合起来。
	 * 
	 * @return
	 * @since:2017年10月29日
	 * @author:liuxc
	 */
	public static String appendWithStringClazz() {
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		String result = "";
		for (int i = 0; i < 30; i++) {
			result += "使用实例：Hibernate的session，工具类HibernateUtil中用于session管理。ThreadLocal在spring的事务管理，包括Hibernate的session管理等都有出现，在web开发中，有时会用来管理用户会话 HttpSession，web交互中这种典型的一请求一线程的场景似乎比较适合使用ThreadLocal，但是需要特别注意的是，由于此时session与线程关联，而tomcat这些web服务器多会采用线程池机制，也就是说线程是可复用的，所以在每一次进入的时候都需要重新进行set，或者在结束时及时remove。";
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(endTime);
		System.out.println(totalTime);
		return result;
	}
	/**
	 * 时间开销随着项目数量呈线性级增加
	 * @return
	 * @since:2017年10月29日
	 * @author:liuxc
	 */
	public static String appendWithStringBuilderClazz() {
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 50; i++) {
			sb.append("使用实例：Hibernate的session，工具类HibernateUtil中用于session管理。ThreadLocal在spring的事务管理，包括Hibernate的session管理等都有出现，在web开发中，有时会用来管理用户会话 HttpSession，web交互中这种典型的一请求一线程的场景似乎比较适合使用ThreadLocal，但是需要特别注意的是，由于此时session与线程关联，而tomcat这些web服务器多会采用线程池机制，也就是说线程是可复用的，所以在每一次进入的时候都需要重新进行set，或者在结束时及时remove。");
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(endTime);
		System.out.println(totalTime);
//		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***********当心字符串连接的性能***********/
	
	/***********通过接口引用对象***********/
	/*
	1，如果没有合适的接口存在，完全可以使用类而不是接口来引用对象。例如，考虑值类，比如String和BigInteger。记住，值类很少会用多个实现编写。他们通常是final的，并且很少有对应的接口。
	2，不存在适当接口类型的第二种情形，对象属于一个框架，而框架的基本类型是类，不是接口。如果对象属于这种基于类的框架，就应该用哪个相关的基类(往往是抽象类)来引用这个对象，而不是用他的实现类。java.util.TimerTask抽象类就属于这情形。
	3，不存在适当接口类型的最后一种类型就是，类实现了接口，但是它提供了接口中不存在的额外方法，例如LinkedHashMap。
	*/
	/***********通过接口引用对象***********/
	
}
