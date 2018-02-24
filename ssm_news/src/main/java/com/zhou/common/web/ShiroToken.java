package com.zhou.common.web;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;


/**
 * 进一步封装token
 * @author zhoup
 *
 */
public class ShiroToken extends UsernamePasswordToken implements Serializable{

	private static final long serialVersionUID = 3786270830745970773L;

	public ShiroToken(String username,String pwd){
		super(username, pwd);//相当于( UsernamePasswordToken token = new UsernamePasswordToken(username, password);)
		this.pwd=pwd;
	}
	
	private String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
