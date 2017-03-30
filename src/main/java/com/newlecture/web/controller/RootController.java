package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
	
	@RequestMapping("/index")
	public String index(){
		return "/WEB-INF/views/index.jsp";
	}
	

	
}
