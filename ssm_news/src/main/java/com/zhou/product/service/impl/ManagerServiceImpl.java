package com.zhou.product.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.common.service.ServiceUtil;
import com.zhou.product.dao.ManagerDao;
import com.zhou.product.entity.Manager;
import com.zhou.product.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Resource
	private ServiceUtil serviceUtil;
	
	@Resource
	private ManagerDao managerDao;

	public Map<String, Object> queryManagerList(int pageCurrent) {
		String dao = "manager";
		return serviceUtil.queryPages("", "", pageCurrent, dao);
	}

	public void deleteManagerById(int id) {
		managerDao.deleteManagerById(id);
	}

	public void addManager(Manager manager) {
		managerDao.addManager(manager);
	}

	public void updateManager(Manager manager) {
		managerDao.updateManager(manager);
	}

	public Manager queryManagerById(int id) {
		return managerDao.queryManagerById(id);
	}

}
