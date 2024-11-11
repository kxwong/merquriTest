package com.example.demo;

class Student {
	public String name;
	public String gender;

	public Student(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", gender=").append(gender).append("]");
		return builder.toString();
	}

}
