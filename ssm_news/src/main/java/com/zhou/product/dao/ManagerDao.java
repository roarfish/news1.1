package com.zhou.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.product.entity.Manager;

public interface ManagerDao {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	Manager queryManagerByName(String username);
	
	/**
	 * 管理员数量
	 * @return
	 */
	int queryManagerCount();
	
	/**
	 * 分页查询
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Manager> queryManagerByPage(@Param("startIndex")int startIndex,
									 @Param("pageSize")int pageSize);
	
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
