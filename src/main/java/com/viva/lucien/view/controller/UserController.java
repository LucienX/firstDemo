package com.viva.lucien.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author qiaoxing
 *
 * @time:2017年4月10日 下午4:24:35
 * @Description:用户控制类
 */
@Controller
@RequestMapping("/user.do")
public class UserController {
/*	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;*/
	
	/***
	 * 导页
	 * @return index.jsp页面
	 */
	@RequestMapping("")
	public String page(){
		return "user/index";
	}
}
