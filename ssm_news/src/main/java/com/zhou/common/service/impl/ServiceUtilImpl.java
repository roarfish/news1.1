package com.zhou.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.common.service.ServiceUtil;
import com.zhou.common.web.PageObject;
import com.zhou.product.dao.ArticleDao;
import com.zhou.product.dao.ManagerDao;
import com.zhou.product.dao.NavDao;


@Service("serviceUtil")
public class ServiceUtilImpl implements ServiceUtil{
	
	@Resource
	private ManagerDao managerDao;
	
	@Resource
	private NavDao navDao;
	
	@Resource
	private ArticleDao articleDao;
	
	public Map<String, Object> queryPages(String obj, String obj2, int pageCurrent, String dao) {
		
		PageObject page=new PageObject();
		int startIndex=pageCurrent*page.getPageSize();
		Map<String,Object> lists=getPageObject(obj, obj2, startIndex, page.getPageSize(), dao);
		page.setStartIndex(startIndex);
		page.setRowCount((Integer) lists.get("count"));
		page.setPageCurrent(pageCurrent);
		@SuppressWarnings("unchecked")
		List<Object> list=(List<Object>) lists.get("pagesData");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("Page", page);
		map.put("List", list);
		
		return map;
	}
	
	public Map<String,Object> getPageObject(String obj, String obj2, int startIndex, int pageSize, String dao){
		
		Map<String,Object> list=new HashMap<String,Object>();
		if(dao.equals("manager")){
			list.put("pagesData", managerDao.queryManagerByPage(startIndex, pageSize));
			list.put("count", managerDao.queryManagerCount());
			return list;
		}else if(dao.equals("nav")){
			list.put("pagesData", navDao.queryNavByPage(startIndex, pageSize));
			list.put("count", navDao.queryNavCount());
			return list;
		}else if(dao.equals("article")){
			list.put("pagesData", articleDao.queryArticle(obj, obj2, startIndex, pageSize));
			list.put("count", articleDao.queryArticleCount());
			return list;
		}
		return null;
	}
}
