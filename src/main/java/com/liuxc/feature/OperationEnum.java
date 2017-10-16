/**
 * 
 */
package com.liuxc.feature;


/**
 * 
 * 
 * @since:2017年10月13日
 * @author:liuxc
 */
public enum OperationEnum {

	plus, minus, times, divide;
	
	double apply(double x, double y) {
		switch(this) {
			case plus : return x + y;
			case minus : return x - y;
			case times : return x * y;
			case divide : return x / y;
		}
		throw new AssertionError("Unknown op : " + this);
	}
	
	public static void main(String[] args) {
		
		System.out.println(OperationEnum.plus.apply(2.0, 3.5));
	}
}
