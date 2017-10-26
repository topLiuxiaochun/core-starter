package com.liuxc.serial;

import java.io.Serializable;

public class SerialPerson implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int age;
	
	private Gender gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SerialPerson [name=" + name + ", age=" + age + ", gender="
				+ gender + "]";
	}
	
	
}
