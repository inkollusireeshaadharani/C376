package com.assignments.multithreading;

public class HelloWorldThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Hello World using Runnable");
	}

}
