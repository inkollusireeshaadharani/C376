package com.wileyedge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wileyedge.dao.StudentDao;
import com.wileyedge.model.Student;

public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentRegistrationServlet() {
    	
    }

    public void init() throws ServletException {
   		System.out.println("Inside init() of StudentRegistrationServlet "+this.getServletConfig().toString());
   	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("Inside doPost() of StudentRegistrationServlet");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        long mobileNo = Long.parseLong(request.getParameter("mobileNo"));
        String address = request.getParameter("address");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setMobileNo(mobileNo);
        student.setAddress(address);

        request.setAttribute("student", student);
        
        String jdbcUrl = getServletContext().getInitParameter("jdbcUrl");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        System.out.println("MySQL credentials accessed");
        StudentDao studentDao = new StudentDao(jdbcUrl, jdbcUsername, jdbcPassword);
        studentDao.saveStudent(student);
        System.out.println(student);

        RequestDispatcher rd = request.getRequestDispatcher("success.jsp"); 
        System.out.println("Forwarding request to success.jsp");
        rd.forward(request, response);
    }

}
