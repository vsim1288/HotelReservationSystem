package com.hotel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ModelAndView getRegister() {
		ModelAndView model = new ModelAndView();
		RegisterForm registerForm = new RegisterForm();
		model.addObject("registerForm", registerForm);
		model.setViewName("register");

		return model;
	}

	@PostMapping
	public ModelAndView register(@Valid RegisterForm registerForm, BindingResult bindingResult) {
		final Logger log = LoggerFactory.getLogger(RegisterController.class);
		
		Users user = new Users();
		UserInformation userInfo = new UserInformation();
		ModelAndView mv = new ModelAndView();

		userInfo.setAddress(registerForm.getAddress());
		userInfo.setFirstName(registerForm.getFirstname());
		userInfo.setLastName(registerForm.getLastname());
		userInfo.setPhone(registerForm.getPhone());

		user.setEnabled((byte)1);
		user.setUsername(registerForm.getUsername());
		user.setPassword(registerForm.getPassword());
		user.setUserInfo(userInfo);

		Users userExists = usersService.get(user);
		log.info("Got user: " + userExists);
		mv.setViewName("register");

		if (userExists != null) {
			log.error("User already exists!");
			bindingResult.rejectValue("username", "error.username", "Username already exists!");
		}

		if(bindingResult.hasErrors()) {
			log.error("Form has errors, sending back for correction!" + registerForm.getUsername());
			mv.setViewName("register");
		} else {
			log.info("Saving new user!");
			
			usersService.saveUser(user);
			
			log.info("Redirecting to login page after successful registration!");
			
			mv.setViewName("login");
		}

		return mv;

	}
}
