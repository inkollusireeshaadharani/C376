package com.datastructures.impl;

import com.datastructures.exp.EmptyStackException;
import com.datastructures.exp.StackOverflow;

public class MyStack<T> extends MyLinkedList<T> {
	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void push(T data) throws StackOverflow{
		if(isFull()) {
			throw new StackOverflow("Stack is Full! Cannot push "+data);
		}
		addLast(data);
	}
	public T pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("Stack is Empty! Cannot pop");
		}
		return deleteLast();
	}
	public T peek() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyStackException("Stack is Empty! Cannot peek");
		}
		return getLast();
	}
	public boolean isFull() {
		return this.size()==capacity;
	}
	public boolean isEmpty() {
		return this.size()==0;
	}
	
}
