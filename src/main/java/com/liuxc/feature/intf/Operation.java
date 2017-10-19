/**
 * 
 */
package com.liuxc.feature.intf;

/**
 * 枚举接口：可以根据具体业务灵活扩展，具体的枚举类实现该接口即可。
 * @since:2017年10月16日
 * @author:liuxc
 */
public interface Operation {

	double apply(double x, double y);
}
