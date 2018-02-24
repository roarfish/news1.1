package com.zhou.product.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.common.service.ServiceUtil;
import com.zhou.product.dao.NavDao;
import com.zhou.product.entity.Nav;
import com.zhou.product.service.NavService;

@Service
public class NavServiceImpl implements NavService {
	
	@Resource
	private ServiceUtil serviceUtil;
	
	@Resource
	private NavDao navDao;

	public Map<String, Object> queryNavList(int pageCurrent) {
		String dao = "nav";
		return serviceUtil.queryPages("", "", pageCurrent, dao);
	}

	public void deleteNavById(String id) {
		navDao.deleteNavById(id);
	}

	public void addNav(Nav nav) {
		String nav_id=UUID.randomUUID().toString();
		nav.setNav_id(nav_id);
		navDao.addNav(nav);
	}

	public Nav queryNavById(String id) {
		return navDao.queryNavById(id);
	}

	public void updateNav(Nav nav) {
		navDao.updateNav(nav);
	}

	public List<Nav> doQueryAllNavName() {
		return navDao.doQueryAllNavName();
	}

}
