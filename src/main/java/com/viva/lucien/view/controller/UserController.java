package com.viva.lucien.view.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viva.lucien.model.User;
import com.viva.lucien.service.UserService;

/**
 * 
 * @author qiaoxing
 *
 * @time:2017年4月10日 下午4:24:35
 * @Description:用户控制类
 */
@Controller
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	/***
	 * 导页
	 * @return index.jsp页面
	 */
	@RequestMapping("/user.do")
	public String page(){
		return "user/index";
	}
	
	@RequestMapping(value="/create.do",method=RequestMethod.POST)
	private User create(String name){
		User user=new User();
		user.setName(name);
		return 	userService.save(user);
		
	}
	
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	private ModelAndView register(String name){
		 ModelAndView mav=null;  
		User user=new User();
		user.setName(name);
			/*	userService.save(user);*/
		 //  request.setAttribute("user", user);  
	try {
			  mav = new ModelAndView();  
		        mav.setViewName("success");  
		        mav.addObject("user", user);  
		        mav.addObject("msg", "注册成功了，可以去登陆了");  
		        return mav;
		}catch (Exception e) {
				mav.setViewName("error");  
		        mav.addObject("user", null);  
		        mav.addObject("msg", "注册失败");  
		        return mav;  
		}
		
	}
	
	
}
