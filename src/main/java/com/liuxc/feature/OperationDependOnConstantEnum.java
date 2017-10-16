/**
 * 
 */
package com.liuxc.feature;

/**
 * 特定于常量的方法实现.
 * </p>
 * 扩展常量时绝不会忘记提供apply方法，因为该方法紧跟在每个常量声明之后。即使真的忘了，编译器也会提示，因为枚举类型中的抽象方法必须被它常量中的具体方法覆盖。
 * @since:2017年10月13日
 * @author:liuxc
 */
public enum OperationDependOnConstantEnum {

	plus("+") {

		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x + y;
		}},
	
	minus("-") {

		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x - y;
		}},
	
	times("*") {

		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x * y;
		}},
	
	divide("/") {

		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return x / y;
		}};
	
	private final String symbol;
	
	/**
	 * 构造方法不能为public和protected
	 * </p>
	 * 在类加载时调用
	 * @param symbol
	 */
	private OperationDependOnConstantEnum(String symbol) {
		
		System.err.println("init instance");
		this.symbol = symbol;
	}

	/**
	 * 一般都要重写toString和valueOf方法
	 */
	public String toString(){
		return super.toString();
	}
	public static String getSymbol(){
		return OperationDependOnConstantEnum.plus.symbol;
	}
	abstract double apply(double x, double y);
	
	public static void main(String[] args) {
//		System.err.println("加法结果" + OperationDependOnConstantEnum.plus.apply(8, 4));
//		System.err.println("减法结果" + OperationDependOnConstantEnum.minus.apply(8, 4));
//		System.err.println("乘法结果" + OperationDependOnConstantEnum.times.apply(8, 4));
//		System.err.println("除法结果" + OperationDependOnConstantEnum.divide.apply(8, 4));
//		
		System.err.println(OperationDependOnConstantEnum.divide.toString());
		System.err.println(getSymbol());
	}
}
