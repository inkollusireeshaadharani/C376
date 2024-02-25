package com.wileyedge.model;

public class Student {
	private String Name;
	private int age;
	private long mobileNo;
	private String Address;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", age=" + age + ", mobileNo=" + mobileNo + ", Address=" + Address + "]";
	}
}
