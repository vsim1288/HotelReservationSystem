package com.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@GetMapping({"/", "/welcome"})
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}

	@GetMapping("/booking")
	public ModelAndView booking() {
		return new ModelAndView("booking");
	}
	
	@GetMapping("/gallery")
	public ModelAndView gallery() {
		return new ModelAndView("gallery");
	}
	
	@GetMapping("/contact")
	public ModelAndView contact() {
		return new ModelAndView("contact");
	}
	
	@GetMapping("/404")
	public ModelAndView pageNotFound() {
		return new ModelAndView("404");
	}
	
	@GetMapping("/access-denied")
	public ModelAndView accessDenied() {
		return new ModelAndView("403");
	}
}
