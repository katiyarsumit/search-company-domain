package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.CompanyDomain;

@Controller
public class SearchEngineController {
	@Autowired
	CompanyDomain companyDomain;
	
	@RequestMapping(value="/")
public ModelAndView welcomepage() {
	ModelAndView mv=new ModelAndView("welcomepage");
	return mv;
}
	
	@RequestMapping(value="/searchEngine")
public ModelAndView searchEngine() {
	ModelAndView mv=new ModelAndView("searchEngine");
	return mv;
}
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public ModelAndView getFile(@RequestParam("file") MultipartFile file) {
		String message="";
		String downloadUrl="";
		ModelAndView mv=new ModelAndView("searchEngine");
		if(!file.isEmpty())
		{
			String Url=companyDomain.convertFile(file);
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
