package com.liuxc.feature;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(OperationDependOnConstantEnum.divide.apply(8, 4));
		
		System.err.println(OperationEnum.values().length);
		
		System.err.println(OperationDependOnConstantEnum.getSymbol());
	}

}
