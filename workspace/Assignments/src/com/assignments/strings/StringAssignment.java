package com.assignments.strings;

public class StringAssignment {
	//1
	public static void separate(String str) {
		char ch = '-';
		char[] chArr = str.toCharArray();
		String temp="";
		for(int i = chArr.length-1; i > 0; i-- ) {
			temp = temp + chArr[i] + ch;
		}
		temp = temp + chArr[0];
		System.out.println(temp);
		
	}
	//2
	public static void replaceAndAppend(String str) {
		String str1 = "";
		String str2 = "";
		for(char ch : str.toCharArray()) {
			if(ch=='x') str2 = str2+ch;
			else str1 = str1+ch;
		}
		str = str1+str2;
		System.out.println(str);
	}
	//3
	public static void replaceFirstLast(String str) {
		if(str.length()>1) {
			char ch1 = str.charAt(0);
			char chLast = str.charAt(str.length()-1);
			
			str = chLast + str.substring(1,str.length()-1) + ch1;
		} 
		
		System.out.print(str);
	}
	
	//4
	public static void maxLenSubstr(String str) {
		String[] strArr = str.split(" ");
		int max = 0;
		String temp="";
		for(String s : strArr) {
			if(s.length()>max) {
				max=s.length();
				temp = s;
			}
		}
		System.out.println(temp);		
	}
	
	//5
	public static void firstLetters(String str) {
		String[] strArr = str.split(" ");
		
		String temp="";
		for(String s : strArr) {
			temp = temp + s.charAt(0);
		}
		System.out.println(temp);		
	}
		
	//6
	public static void nthLetters(String str) {
		String[] strArr = str.split(" ");
		
		String temp="";
		for(int i = 0;i<strArr.length;i++) {
			temp = temp + strArr[i].charAt(i);
		}
		temp = temp.toUpperCase();
		System.out.println(temp);		
	}
	//7
	public static void nextLetters(String str) {
		for(char ch : str.toCharArray()) {
			if(ch!=' ') {
				System.out.print((char)(ch+1));
			}
			else {
				System.out.print(' ');
			}
		}
	}
		
	public static void main(String[] args) {
		
	}

}
