package com.imcs.springmvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String test() {
		
		return "test";
	}
	
	@RequestMapping(value = "/modelmap",method = RequestMethod.GET)
	public String testModelMap(ModelMap modelMap,
			@RequestParam(name = "name") String name,
			HttpSession session) {
		modelMap.addAttribute("test", name);
		session.setAttribute("sessionTest", name);
		
		return "test";
	}
	
	@RequestMapping(value = "/mav",method = RequestMethod.GET)
	public ModelAndView testModelAndView(
			@RequestParam(name = "name") String name,
			HttpSession session) {
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("test", name);
		mav.setViewName("test");
		
		session.setAttribute("sessionTest", name);
		
		return mav;
	}
}
