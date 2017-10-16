/**
 * 
 */
package com.liuxc.feature;

import com.liuxc.feature.intf.Operation;

/**
 * emulated extensible enum using an interface：使用接口模拟扩展枚举
 * </p>
 * 虽然枚举类BaseOperationEnum是不可扩展的，但是接口Operation却是可以扩展的，比如扩展的枚举类ExtendedOperationEnum
 * @since:2017年10月14日
 * @author:liuxc
 */
public enum BaseOperationEnum implements Operation{

	plus("+") {

		public double apply(double x, double y) {
			return x + y;
		}},
	
	minus("-") {

		public double apply(double x, double y) {
			return x - y;
		}},
	
	times("*") {

		public double apply(double x, double y) {
			return x * y;
		}},
	
	divide("/") {

		public double apply(double x, double y) {
			return x / y;
		}};
	
	private final String symbol;

	private BaseOperationEnum(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
