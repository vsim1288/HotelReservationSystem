package com.hotel.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hotel.form.RegisterForm;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	@RequestMapping(method = RequestMethod.GET)
	public String getRegister(Map<String, Object> model) {
		RegisterForm registerForm = new RegisterForm();
		model.put("registerForm", registerForm);

		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void register(@ModelAttribute("registerForm") RegisterForm registerForm, Map<String, Object> model) {
		System.out.println(registerForm);
	}
}
