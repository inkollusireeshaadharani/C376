package com.wileyedge.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wileyedge.model.Student;
import com.wileyedge.service.IService;

@Controller
public class StudentController {
	@Autowired
	private IService service;
	
	@RequestMapping(value="/getform.htm", method = RequestMethod.GET)
	public String showStudForm(Map<String,Student> map) {
		System.out.println("Inside showStudForm()");
		map.put("stud", new Student());
		return "studform";
	}
	
	@RequestMapping(value="/savestud.htm", method = RequestMethod.POST)
	public String persistStudent(@ModelAttribute("stud") Student stud, Model model) {
		System.out.println("Inside persistStudent()");
		System.out.println(stud);
		List<Student> list = new ArrayList<>();
		list.add(stud);	
		service.saveStudents(list);
		return "success";
	}
}
