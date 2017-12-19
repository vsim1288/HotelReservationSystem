package com.hotel.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.entity.UserInformation;
import com.hotel.entity.Users;
import com.hotel.form.RegisterForm;
import com.hotel.service.UsersService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	@Autowired
	private UsersService usersService;

	@GetMapping
	public String getRegister(Map<String, Object> model) {
		RegisterForm registerForm = new RegisterForm();
		model.put("registerForm", registerForm);

		return "register";
	}

	@PostMapping
	public ModelAndView register(@ModelAttribute("registerForm") RegisterForm registerForm, Map<String, Object> model) {
		String status;
		Users user = new Users();
		UserInformation userInfo = new UserInformation();
		ModelAndView mv = new ModelAndView();

		userInfo.setAddress(registerForm.getAddress());
		userInfo.setEmail(registerForm.getUsername());
		userInfo.setFirstName(registerForm.getFirstname());
		userInfo.setLastName(registerForm.getLastname());
		userInfo.setPhone(registerForm.getPhone());

		user.setEnabled(1);
		user.setUsername(registerForm.getUsername());
		user.setPassword(registerForm.getPassword());
		user.setUserInfo(userInfo);

		status = "found";//usersService.findByUsername(user);
		mv.setViewName("register");

		if (status.equals("found")) {
			model.put("status", "User exists!");
			
			

			return mv;
		}

		if (status.equals("error")) {
			mv.getModel().put("status", "Something went wrong!");

			return mv;
		}

		mv.getModel().put("status", "Registration successful");

		return mv;

	}
}
