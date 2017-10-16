/**
 * 
 */
package com.liuxc.feature;

import com.liuxc.feature.intf.Operation;

/**
 * emulated extensible enum ：使用接口模拟扩展枚举
 * @since:2017年10月14日
 * @author:liuxc
 */
public enum ExtendedOperationEnum implements Operation{

	exp("^") {

		public double apply(double x, double y) {
			return Math.pow(x, y);
		}},
	
	pemainder("%") {

		public double apply(double x, double y) {
			return x % y;
		}};
	
	private final String symbol;

	private ExtendedOperationEnum(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
