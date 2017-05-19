package com.high.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class PageController {

	@RequestMapping("/{module}/{page}.do")
	public String page(@PathVariable String module,@PathVariable String page){
		return module+"/"+page;
	}
}
