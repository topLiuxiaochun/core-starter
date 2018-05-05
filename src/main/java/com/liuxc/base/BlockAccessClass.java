/**
 * 
 */
package com.liuxc.base;

/**
 * 代码块隔离性以及变量的访问【初始化之前】
 * 
 * @since 2018年5月5日
 * @author liuxc
 */
public class BlockAccessClass {

	private int count;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BlockAccessClass().doAccessNonInitiation();

	}
	
	/**
	 * 代码块作用域问题
	 * 
	 * @since 2018年5月5日
	 * @author liuxc
	 */
	public void doIsolation() {
		boolean enabledBlock = true;
		
		if (enabledBlock) {
			boolean blocking = true;
		}
		
//		System.out.println(blocking);//根本无法访问变量blocking
		
		System.err.println(count);
	}
	
	/**
	 * 所有变量，包括全局还是局部变量使用前都必须必须初始化，只是全局变量在类加载阶段就已经初始化而已。
	 * 
	 * @since 2018年5月5日
	 * @author liuxc
	 */
	public void doAccessNonInitiation() {
		Object obj;
				
		try {
			obj = Class.forName("com.liuxc.entity.UserVO").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// The local variable obj may not have been initialized
//		System.out.println(obj);
		
		System.err.println(count);
	}
	
	public void doAccessInitiation() {
		Object obj = null;
				
		try {
			obj = Class.forName("com.liuxc.entity.UserVO").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(obj);
		
		System.err.println(count);
	}

}
