package com.zhou.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhou.common.service.ShiroService;
import com.zhou.common.web.JsonResult;

@Controller
public class LoginController {
	
	@Resource
	private ShiroService shiroService;
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		return "login";
	}
	
	@RequestMapping("indexUI")
	public String go2Index(){
		return "main";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(String username,String pwd){
		shiroService.login(username, pwd);
		return new JsonResult();
	}
	
	
}
