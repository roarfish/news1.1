package com.zhou.common.service.impl;

import javax.annotation.Resource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zhou.common.web.ShiroToken;
import com.zhou.product.dao.ManagerDao;
import com.zhou.product.entity.Manager;

public class ShiroRealm extends AuthorizingRealm{
	
	@Resource
	private ManagerDao managerDao;

	/**
	 * 权限授予
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 密码与账户的认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1. 把 AuthenticationToken 转换为 UsernamePasswordToken (ShiroToken)
		ShiroToken upToken = (ShiroToken) token;
		// 2. 从 UsernamePasswordToken 中来获取 username
		String username = upToken.getUsername();
		// 3.判断管理员是否存在，若存在，返回user对象
		Manager manager = managerDao.queryManagerByName(username);
		// 4.判断管理员是否存在
		if (manager == null) {
			throw new AccountException("管理员账户错误!");
		}
		// 5.通过SimpleAuthenticationInfo对象自动完成密码比对
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, manager.getManager_pwd(), getName());
		return info;
	}
	
}
