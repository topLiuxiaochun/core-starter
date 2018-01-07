/**
 * 
 */
package com.liuxc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * @since:2017年12月20日
 * @author:liuxc
 */
public class FunctionLambda {

	/**
	 * @param args
	 * @since:2017年12月20日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		List<Integer> idList = map(Arrays.asList("lambdas","in","action"), (String s)-> s.length());

		System.out.println(idList);
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for(T t : list){
			result.add(f.apply(t));
		}
		return result;
	}
}
