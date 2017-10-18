/**
 * 
 */
package com.liuxc.math;

import java.math.BigDecimal;

/**
 * 数学运算
 * @since:2017年10月18日
 * @author:liuxc
 */
public class MathUtil {

	/**
	 * @param args
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		/*加法日志*/
		System.out.println("**加法日志**************************");
		double result = plus(0.06, 0.01);

		System.out.println(result);//0.07
		
		System.out.println(plusDouble(0.06, 0.01));//0.06999999999999999
		
		System.out.println(0.06 + 0.01);//0.06999999999999999
		
		/*减法日志*/
		System.out.println("****减法日志************************");
		result = subtract(1.0, 0.42);

		System.out.println(result);//0.58
		
		System.out.println(subtractDouble(1.0, 0.42));//0.5800000000000001
		
		System.out.println(1.0 - 0.42);//0.5800000000000001
		
		/*乘法日志*/
		System.out.println("******乘法日志**********************");
		result = multiply(4.015, 100);

		System.out.println(result);//401.5
		
		System.out.println(multiplyDouble(4.015, 100));//401.49999999999994
		
		System.out.println(4.015*100);//401.49999999999994
		
		/*除法日志*/
		System.out.println("********除法日志********************");
		result = divide(303.1, 1000);

		System.out.println(result);//0.3031
		
		System.out.println(divideDouble(303.1, 1000));//0.30310000000000004
		
		System.out.println(303.1/1000);//0.30310000000000004
	}
	/**
	 * BigDecimal加法精确运算
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double plus(double x, double y) {
		BigDecimal bx = new BigDecimal(String.valueOf(x));
		BigDecimal by = new BigDecimal(String.valueOf(y));
		return bx.add(by).doubleValue();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double plusDouble(double x, double y) {
		BigDecimal bx = new BigDecimal(x);
		BigDecimal by = new BigDecimal(y);
		return bx.add(by).doubleValue();
	}
	
	/**
	 * BigDecimal减法精确运算
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double subtract(double x, double y) {
		BigDecimal bx = new BigDecimal(String.valueOf(x));
		BigDecimal by = new BigDecimal(String.valueOf(y));
		return bx.subtract(by).doubleValue();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double subtractDouble(double x, double y) {
		return x - y;
	}
	
	/**
	 * BigDecimal乘法精确运算
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double multiply(double x, double y) {
		BigDecimal bx = new BigDecimal(String.valueOf(x));
		BigDecimal by = new BigDecimal(String.valueOf(y));
		return bx.multiply(by).doubleValue();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double multiplyDouble(double x, double y) {
		return x * y;
	}
	
	/**
	 * BigDecimal除法精确运算
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double divide(double x, double y) {
		BigDecimal bx = new BigDecimal(String.valueOf(x));
		BigDecimal by = new BigDecimal(String.valueOf(y));
		return bx.divide(by).doubleValue();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @since:2017年10月18日
	 * @author:liuxc
	 */
	public static double divideDouble(double x, double y) {
		return x / y;
	}

}
