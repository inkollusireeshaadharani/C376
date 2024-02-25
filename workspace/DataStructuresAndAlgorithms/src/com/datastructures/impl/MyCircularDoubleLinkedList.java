package com.datastructures.impl;

import com.datastructures.exp.ListIndexOutOfBounds;

public class MyCircularDoubleLinkedList<T> extends MyDoublyLinkedList<T>{
	
	public void addFirst(T data) {
		Node node = new Node(data);
		if(head==null) {
			head=tail=node;
			size++;
			return;
		}
		
		node.next = head;
		node.prev = tail;
		head.prev = node;
		tail.next = node;
		head = node;
		size++;
	}
	
	public void addLast(T data) {
		if(head==null) {
			addFirst(data);
			return;
		}

		Node node = new Node(data);
		
		node.next = head;
		node.prev = tail;
		head.prev = node;
		tail.next = node;
		tail = node;
		size++;
	}
	
	//toString() -- traversing
	@Override
	public String toString() {
		if(head==null) return "";
		String res="";
		Node temp = head;
		while(temp.next!=tail) {
			res = res + temp.data + ", ";
			temp = temp.next;
		}
		return "MCLL[" + res + temp.data + ", "+ tail.data + "]";
	}
	
	//deleteFirst
	public T deleteFirst(){
		if(head==null) {
			throw new ListIndexOutOfBounds("Index out of bounds!!");
		}
		else if(head==tail) {
			T data = head.data;
			tail=head=null;
			return data;
		}
		T data = head.data;
		head = head.next;
		tail.next = head;
		head.prev=tail;
		size--;
		return data;
	}
	//deleteLast
	public T deleteLast(){
		if(head==tail) {
			return deleteFirst();
		}
		
		T data = tail.data;
		tail = tail.prev;
		tail.next = head;
		head.prev=tail;
		size--;
		return data;
	}
	
	public String reverse() {
		String res="";
		Node temp = tail;
		while(temp.prev!=head) {
			res = res + temp.data + ", ";
			temp = temp.prev;
		}
		return "MCLL[" + res + temp.data + ", "+ head.data + "]";
	}
	
	public T get(int index){
		if(index < 0) {
			throw new ListIndexOutOfBounds("No element at index: "+index);
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	//getNode
	//we have a functionality to traverse starting at a node and ending there
}
