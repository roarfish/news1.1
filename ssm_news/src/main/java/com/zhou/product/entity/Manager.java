package com.zhou.product.entity;
/**
 * 管理员信息
 * @author zhoup
 *
 */
public class Manager {
	//管理员ID
	private String manager_id;
	//管理员姓名
	private String manager_name;
	//管理员密码
	private String manager_pwd;
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_pwd() {
		return manager_pwd;
	}
	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd;
	}
	
	
}
