package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView mv=new ModelAndView("user");
		return mv;
	}
	
}
