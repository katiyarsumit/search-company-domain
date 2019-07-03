package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.SearchEmail;

@Controller
public class SearchEmailController {
	@Autowired
	SearchEmail searchEmail;
	
	@RequestMapping(value="/searchEmail")
public ModelAndView searchEmail() {
	ModelAndView mv=new ModelAndView("searchEmail");
	return mv;
}
	
	@RequestMapping(value="/uploadEmail", method=RequestMethod.POST)
	public ModelAndView getEmailFile(@RequestParam("file") MultipartFile file) {
		String message="";
		String downloadUrl="";
		ModelAndView mv=new ModelAndView("searchEngine");
		if(!file.isEmpty())
		{
			String Url=searchEmail.searchEmail(file);
			if(!Url.isEmpty())
				{
					message="<span>File Converted SuccessFully...</span>";
					downloadUrl=Url;
					
				}
			else
				{
					message="File Not Converted Please Try Again...";
				}
		}
		else 
		{
				message="Please Upload File...";
		}
	mv.addObject("message",message);
	mv.addObject("downloadUrl",downloadUrl);
return mv;
	}
}
