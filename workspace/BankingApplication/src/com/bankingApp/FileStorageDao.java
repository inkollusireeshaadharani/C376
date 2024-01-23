package com.bankingApp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.List;


public class FileStorageDao {

	public void serialize(List<Customer> list) {
		File file = new File("D:\\C376\\customers.ser");
		FileOutputStream fos=null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			
			oos = new ObjectOutputStream(bos);
			oos.writeObject(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Serialization Successful");
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> deSerialize(List<Customer> list) {
		InputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("D:\\C376\\customers.ser");
			bis = new BufferedInputStream(fis);
			
			ois = new ObjectInputStream(bis);
			
			
			Object obj = ois.readObject();
			if(obj instanceof List) {
				list = (List<Customer>) obj; 
				for(Customer c : list) {
					c.printCustomerData();
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully Loaded Customers Data");
//		System.out.println("==============================================================================================");
		return list;
	}

}
