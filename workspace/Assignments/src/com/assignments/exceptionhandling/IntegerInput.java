package com.assignments.exceptionhandling;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class IntegerInput {

	public void inputWithCheckAfterEntering() throws DuplicateIntegerException{
		List<Integer> list = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the size of list: ");
		int size = s.nextInt();
		int i = 0;
		System.out.print("Enter "+ size + " numbers: ");
		while(i<size) {
			int n = s.nextInt();
			list.add(n);
			i++;
		}
		Set<Integer> set = new HashSet<>();
		set.addAll(list);
		s.close();
		if(set.size() != list.size()) {
			throw new DuplicateIntegerException("You can't add duplicates in the list");
		}
		System.out.println("List is: "+list);		
	}
	
	public void inputWithCheckWhileEntering() throws DuplicateIntegerException{
		List<Integer> list = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the size of list: ");
		int size = s.nextInt();
		int i = 0;
		while(i<size) {
			s.close();
			System.out.print("Enter a number: ");
			int n = s.nextInt();
			if(list.contains(n)) {
				throw new DuplicateIntegerException("Can't add duplicate number " + n);
			}
			list.add(n);
			i++;
		}
		System.out.println("List is: "+list);
	}

}

@SuppressWarnings("serial")
class DuplicateIntegerException extends Exception{
	public DuplicateIntegerException(String msg) {
		super(msg);
	}
}
