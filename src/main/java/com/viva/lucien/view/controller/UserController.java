package com.viva.lucien.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user.do")
public class UserController {
/*	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;*/
	
	@RequestMapping("")
	public String page(){
		return "user/index";
	}
}
