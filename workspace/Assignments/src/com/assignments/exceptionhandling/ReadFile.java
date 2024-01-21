package com.assignments.exceptionhandling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {

	public void read() throws FileNotFoundException{
		InputStream fis;
		try {
			fis = new FileInputStream("D:\\C376\\test.txt");
		}
		catch(FileNotFoundException fe) {
			throw new FileNotFoundException("File doesn't exist!");
		}
		
		InputStream bis = new BufferedInputStream(fis);
		int ch = 0;
		while(ch!=-1) {
			try {
				ch = bis.read();
				System.out.println((char)ch);
			} 
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
			finally {
				try {
					bis.close();
				} 
				catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
	}
	
}
