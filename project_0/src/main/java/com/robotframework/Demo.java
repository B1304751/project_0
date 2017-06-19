package com.robotframework;

public class Demo {
	
	private String name;
	
	public Demo() {}
	
	public int count(int a, int b) {
		return a - b;
	}
	
	public String division(int a, int b) {
		try {
			return String.valueOf((float)(a / b));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public int addition(int a, int b) {
		return a + b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
