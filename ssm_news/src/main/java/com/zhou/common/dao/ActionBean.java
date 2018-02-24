package com.zhou.common.dao;

import java.util.HashMap;
import java.util.Map;


public class ActionBean {
	
	public Map<String,String> queryArticleMap4Edit(String article_id){
		Map<String,String> map = new HashMap<String,String>();
		SqlHelper sqlHelper = new SqlHelper();
		map.put("content", sqlHelper.queryArticleById(article_id));//根据新闻的主键ID查询出此条新闻 article
		sqlHelper.destroy();
		return map;
	}
}
