package com.assignments.multithreading;

class OddThread implements Runnable{

	@Override
	public void run() {
		for(int i = 1;i<=20;i++) {
			if(i%2 != 0) {
				System.out.println(i);
			}
		}
	}
	
}

class EvenThread implements Runnable{
	
	@Override
	public void run() {
		for(int i = 1;i<=20;i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
	}
	
}

public class OddEven {
	public static void main(String[] args) {
		Thread t1 = new Thread(new OddThread());
		Thread t2 = new Thread(new EvenThread());
		
		t1.start();
		t2.start();
	}
}
