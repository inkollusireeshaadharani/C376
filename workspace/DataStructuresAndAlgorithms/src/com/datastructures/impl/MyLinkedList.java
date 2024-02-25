package com.datastructures.impl;

import com.datastructures.exp.ListIndexOutOfBounds;

class Node<T>{
	T data;
	Node<T> next;
	
	public Node() {
		
	}
	
	public Node(T data) {
		this.data =  data;
	}
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}

public class MyLinkedList<T> {
	
	//data
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	//getters
	public Node<T> getHead() {
		return head;
	}
	public Node<T> getTail() {
		return tail;
	}
	public int size() {
		return size;
	}
	
	//add methods
	public void addFirst(T data) {
		Node<T> node = new Node<>(data);
		node.next = head;
		head = node;
		if(tail==null) {
			tail = head;
		}
		size++;
	}
	
	//adding -- at the end
	public void add(T data) {
		addLast(data);
	}
			
	public void addLast(T data) {
		Node<T> node = new Node<>(data);
		if(head==null) {
			addFirst(data);
			return;
		}
		tail.next=node;
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
			Node<T> prev = head;
			
			for(int i = 0; i < index-1 ; i++) {
				prev = prev.next;
			}
			
			Node<T> node = new Node<>(data);
			node.next = prev.next;
			prev.next=node;
			size++;		
		}
	}
	
	//toString() -- traversing
	@Override
	public String toString() {
		if(head==null) return "";
		String res="";
		Node<T> temp = head;
		while(temp.next!=null) {
			res = res + temp.data + ", ";
			temp = temp.next;
		}
		return "MyLinkedList [" + res + temp.data + "]";
	}
	
	//print list
	public void printList() {
		System.out.println(this.toString());
	}
	
	//size()
	//refer getters and setters
	
	//get method
	public T get(int index){
		if(index>=size || index < 0) {
			throw new ListIndexOutOfBounds("No element at index: "+index);
		}
		Node<T> temp = head;
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
	public T getLast(){
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
		T val = head.data;
		head = head.next;
		size--;
		return val;
	}
	//deleteLast
	public T deleteLast(){
		if(head==tail) {
			return deleteFirst();
		}
		Node<T> prevToTail = head;
		for(int i = 0 ; i < size-2;i++) {
			prevToTail = prevToTail.next;
		}
		T val = tail.data;
		prevToTail.next = null;
		tail = prevToTail;
		size--;
		return val;
	}
	//delete -- at an index
	public T delete(int index){
		if(index==0) {
			return deleteFirst();
		}
		else if(index==size-1) {
			return deleteLast();
		}
		if(index<0 || index>=size) {
			throw new ListIndexOutOfBounds("Index out of bounds!!");
		}
		Node<T> prevToTail = head;
		for(int i = 0 ; i < index-1;i++) {
			prevToTail = prevToTail.next;
		}
		T val = prevToTail.next.data;
		prevToTail.next = prevToTail.next.next;
		size--;
		return val;
	}
	

}
