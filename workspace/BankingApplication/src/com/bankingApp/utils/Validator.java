package com.bankingApp.utils;

import java.time.LocalDate;

public class Validator {
	
	private static int[] currentDate() {
		int[] res=new int[3];
		String today = LocalDate.now().toString();
		String[] words = today.split("-");
		res[0] = Integer.parseInt(words[2]);
		res[1] = Integer.parseInt(words[1]);
		res[2] = Integer.parseInt(words[0]);
		
		return res;
	}
	
	
	public static boolean isEligibleForSalary(String dob) {
		
		if(!isValidDob(dob)) return  false;
		
		String[] date = dob.split("/");
		
		int year = Integer.parseInt(date[2]);
		
		if(year > 2005) return false;
		
		
		return true;
	}
	

	public static boolean isFutureDate(int day, int month, int year) {

		int[] today = currentDate();
		
		if(year > today[2]) return true;
		if(year == today[2] && month > today[1]) return true;
		if(year == today[2] && month == today[1] && day > today[0]) return true;
		return false;
	}
	
	
	
	public static boolean isValidDob(String dob) {
		String[] date = dob.split("/");
		if(date.length > 3) return false;
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		
		if(isFutureDate(day,month,year)) return false;
		
		if(month > 12 || month < 1 || day<1 || day>31) return false;
		
		if(month==2) {
			if(day>29 || (day==29 && year%100 ==0 && year%400 !=0) || (day==29 && year%4 != 0)) return false;
		}
		else if(month==4||month==6||month==9||month==11) {
			if(day>30) return false;
		}
		
		return true;
	}
	
	public static boolean isValidMobileNo(int mob)
	{
    
		int dig = (int)Math.log10(mob) + 1 ;
	    return dig==9;
	}
	
	public static boolean isValidName(String name)
	{
	    for (char c : name.toCharArray())
	    {
            if (!Character.isLetter(c) || c!=' ')
            {
                return false;
            }
	    }
	    return true;
	}
	
	
}
