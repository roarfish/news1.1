package com.zhou.product.service;

import java.util.Map;

import com.zhou.product.entity.Manager;

public interface ManagerService {
	
	/**
	 * 查询管理员信息
	 * @param pageCurrent
	 * @return
	 */
	Map<String, Object> queryManagerList(int pageCurrent);
	
	/**
	 * 删除管理员信息
	 * @param id
	 */
	void deleteManagerById(int id);
	
	/**
	 * 新增管理员
	 * @param manager
	 */
	void addManager(Manager manager);
	
	/**
	 * 修改管理员信息
	 * @param manager
	 */
	void updateManager(Manager manager);
	
	/**
	 * 根据id查询管理员信息
	 * @param id
	 * @return
	 */
	Manager queryManagerById(int id);
}
