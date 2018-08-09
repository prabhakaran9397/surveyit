package com.visa.training.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView hello() {
		Map<String, Object> data = new HashMap<>();
		data.put("todayDate", new Date());
		data.put("greeting", "Hello");
		return new ModelAndView("helloView", data);
	}
	
	@RequestMapping(value="/world", method=RequestMethod.GET)
	public String world(Map<String, Object> data) {
		data.put("todayDate", new Date());
		data.put("greeting", "World");
		return "helloView";
	}
}
