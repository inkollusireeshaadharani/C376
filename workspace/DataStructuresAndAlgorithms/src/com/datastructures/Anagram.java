package com.datastructures;
import java.util.*;
public class Anagram {
	
	
	public static void main(String[] args) {
		Anagram a = new Anagram();
		System.out.println(a.isAnagram("listen","silent"));
	}
	
	
	public boolean isAnagram(String str1, String str2) {
		Map<Character,Integer> map1 = new HashMap<>();
		Map<Character,Integer> map2 = new HashMap<>();
		for(char ch : str1.toCharArray()) {
			map1.put(ch,map1.getOrDefault(ch,0)+1);
		}
		for(char ch : str2.toCharArray()) {
			map2.put(ch,map2.getOrDefault(ch,0)+1);
		}
		if(map1.size()==map2.size()) {
			for(char ch : map1.keySet()) {
				if(map1.get(ch)!=map2.getOrDefault(ch, 0)) {
					return false;
				}
			}
			return true;
		}
		return false;		
	}
	
}
