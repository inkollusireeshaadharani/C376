package com.datastructures.impl;

import com.datastructures.exp.EmptyQueueException;
import com.datastructures.exp.QueueIsFullException;

public class MyQueue<T> extends MyDoublyLinkedList<T> {
	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void enque(T data) throws QueueIsFullException{
		if(isFull()) {
			throw new QueueIsFullException("Queue is Full! Cannot enque "+data);
		}
		addLast(data);
	}
	public T deque()  throws EmptyQueueException{
		if(isEmpty()){
			throw new EmptyQueueException("Queue is Empty! Cannot deque");
		}
		return deleteFirst();
	}
	public boolean isFull() {
		return this.size()==capacity;
	}
	public boolean isEmpty() {
		return this.size()==0;
	}
}
