package com.assignments.oop;

public class ShapeTest {

	public static void main(String[] args) {
		
		//Using abstract method area
		//Using Polymorphic type Shape
		
		Shape s = new Triangle(5,8);
		System.out.println(s.area());
		
		s = new Rectangle(5,8);
		System.out.println(s.area());
	}

}
