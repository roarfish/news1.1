package com.zhou.common.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.zhou.common.exception.ServiceException;
import com.zhou.common.service.ShiroService;
import com.zhou.common.web.ShiroToken;

/**
 * 进行密码与账户检查
 * @author zhoup
 *
 */
@Service
public class ShiroServiceImpl implements ShiroService {

	public void login(String username, String pwd) {
		Subject subject = SecurityUtils.getSubject();
		// 把用户名和密码封装为 ShiroToken 对象
		ShiroToken token = new ShiroToken(username, pwd);
		try {
			// 登录认证 - 调用自定义realm
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			throw new ServiceException("密码或账号错误!");
		}catch (AuthenticationException e) {
			e.printStackTrace();
			throw new ServiceException("认证失败!");
		}
	}

}
