package com.liuxc.entity;

import java.io.Serializable;

public class UserVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String customerId;
	
	private String customerName;
	
	private String nickName;
	
	private String sex;

	public UserVO() {
		super();
	}

	public UserVO(String customerName, String nickName) {
		super();
		this.customerName = customerName;
		this.nickName = nickName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserVO [customerId=" + customerId + ", customerName="
				+ customerName + ", nickName=" + nickName + ", sex=" + sex
				+ "]";
	}
	
	
}
