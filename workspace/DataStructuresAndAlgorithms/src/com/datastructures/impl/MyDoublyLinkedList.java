package com.datastructures.impl;

import com.datastructures.exp.ListIndexOutOfBounds;

public class MyDoublyLinkedList<T> {
	//Node will work just fine w/o <>
	protected class Node{
		T data;
		Node next;
		Node prev;
		
		public Node() {
			
		}
		
		public Node(T data) {
			this.data =  data;
		}
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
	}
	//data
	protected Node head;
	protected Node tail;
	protected int size = 0;
	
	//getters
	public Node getHead() {
		return head;
	}
	public Node getTail() {
		return tail;
	}
	public int size() {
		return size;
	}
	
	public void addFirst(T data) {
		Node node = new Node(data);
		node.next = head;
		node.prev = null;
		head = node;
		if(tail==null) {
			tail = head;
		}
		size++;
	}
	
	public void add(T data) {
		addLast(data);
	}
			
	public void addLast(T data) {
		if(head==null) {
			addFirst(data);
			return;
		}

		Node node = new Node(data);
		
		node.prev = tail;
		tail.next = node;
		node.next = null;
		tail = node;
		
		size++;
	}
	
	//Inserting at a particular position
	public void insert(int index, T data){
		if(index==0) {
			addFirst(data);
		}
		else if(index==size) {
			addLast(data);
		}
		else if(index<0 || index>size) {
			throw new ListIndexOutOfBounds(index + " index doesn't exist! ");
		}
		else {
			Node curr = head;
			
			for(int i = 0; i < index ; i++) {
				curr = curr.next;
			}
			Node node = new Node(data);
			node.prev = curr.prev;
			node.next = curr;
			curr.prev.next = node;
			curr.prev=node;
			size++;		
		}
	}
	
	//toString() -- traversing
	@Override
	public String toString() {
		if(head==null) return "";
		String res="";
		Node temp = head;
		while(temp.next!=null) {
			res = res + temp.data + ", ";
			temp = temp.next;
		}
		return "MDLL[" + res + temp.data + "]";
	}
	
	//print list
	public void printList() {
		System.out.println(this.toString());
	}
	
	//size()
	//refer getters and setters
		
	//get method -- gets the data at that index
	public T get(int index){
		if(index>=size || index < 0) {
			throw new ListIndexOutOfBounds("No element at index: "+index);
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	//getFirst
	public T getFirst(){
		return get(0);
	}
	
	//getFirst
	public T getLast() {
		return get(size-1);
	}
	
	//delete methods
	
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
		head.prev=null;
		size--;
		return data;
	}
	//deleteLast
	public T deleteLast() {
		if(head==tail) {
			return deleteFirst();
		}
		
		T val = tail.data;
		tail = tail.prev;
		tail.next = null;
		size--;
		return val;
	}
	//delete -- at an index
	public T delete(int index){
		if(index<0 || index>=size) {
			throw new ListIndexOutOfBounds("Index out of bounds!!");
		}
		else if(index==0) {
			return deleteFirst();
		}
		else if(index==size-1) {
			return deleteLast();
		}
		Node curr = head;
		for(int i = 0 ; i < index;i++) {
			curr = curr.next;
		}
		T val = curr.data;
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		size--;
		return val;
	}
	//reverse traversal
	
	public String reverse() {
		if(head==null) return "";
		String res="";
		Node temp = tail;
		while(temp.next!=null) {
			res = res + temp.data + ", ";
			temp = temp.next;
		}
		return "MDLL[" + res + temp.data + "]";
	}
}









