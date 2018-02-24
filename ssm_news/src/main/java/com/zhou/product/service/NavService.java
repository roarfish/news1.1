package com.zhou.product.service;

import java.util.List;
import java.util.Map;

import com.zhou.product.entity.Nav;

public interface NavService {

	Map<String, Object> queryNavList(int pageCurrent);

	void deleteNavById(String id);

	void addNav(Nav nav);

	Nav queryNavById(String id);

	void updateNav(Nav nav);

	List<Nav> doQueryAllNavName();

}
