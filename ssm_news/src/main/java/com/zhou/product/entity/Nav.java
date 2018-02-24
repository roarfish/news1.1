package com.zhou.product.entity;
/**
 * 分类情况
 * @author zhoup
 *
 */
public class Nav {
	//分类的UUID
	private String nav_id;
	//分类的名称
	private String nav_name;
	//排序的权重，越大越往后
	private int nav_feight;
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
	public String getNav_name() {
		return nav_name;
	}
	public void setNav_name(String nav_name) {
		this.nav_name = nav_name;
	}
	public int getNav_feight() {
		return nav_feight;
	}
	public void setNav_feight(int nav_feight) {
		this.nav_feight = nav_feight;
	}
	
	
}
