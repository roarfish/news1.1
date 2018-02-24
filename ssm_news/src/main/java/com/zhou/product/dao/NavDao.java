package com.zhou.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.product.entity.Nav;

public interface NavDao {
	
	/**
	 * 分类数量
	 * @return
	 */
	int queryNavCount();
	
	/**
	 * 分页查询
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Nav> queryNavByPage(@Param("startIndex")int startIndex,
							 @Param("pageSize")int pageSize);
	
	/**
	 * 删除分类信息
	 * @param id
	 */
	void deleteNavById(String id);
	
	/**
	 * 新增分类
	 * @param Nav
	 */
	void addNav(Nav nav);
	
	/**
	 * 修改分类信息
	 * @param Nav
	 */
	void updateNav(Nav nav);
	
	/**
	 * 根据id查询分类信息
	 * @param id
	 * @return
	 */
	Nav queryNavById(String id);

	/**
	 * 查询全部分类名称
	 * @return
	 */
	List<Nav> doQueryAllNavName();

}
