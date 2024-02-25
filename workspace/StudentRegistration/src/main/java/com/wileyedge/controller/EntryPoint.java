package com.wileyedge.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EntryPoint() {
        
    }
    
    @Override
   	public void init() throws ServletException {
   		System.out.println("Inside init() of EntryPoint "+this.getServletConfig().toString());
   	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet() of EntryPoint");
    	RequestDispatcher rd =  request.getRequestDispatcher("index.html");
    	System.out.println("forwarding the request to html from EntryPoint");
    	rd.forward(request, response);   	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
