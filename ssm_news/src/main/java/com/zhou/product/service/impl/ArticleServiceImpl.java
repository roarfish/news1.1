package com.zhou.product.service.impl;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.common.service.ServiceUtil;
import com.zhou.product.dao.ArticleDao;
import com.zhou.product.entity.Article;
import com.zhou.product.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ServiceUtil serviceUtil;
	
	@Resource
	private ArticleDao articleDao;
	
	public Map<String, Object> queryArticleList(String nav_id, String article_title, int pageCurrent) {
		String dao = "article";
		return serviceUtil.queryPages(nav_id, article_title, pageCurrent, dao);
	}

	public void deleteArticleById(String id) {
		articleDao.deleteArticleById(id);
	}

	public void addArticle(Article article) {
		article.setArticle_id(UUID.randomUUID().toString());
		articleDao.addArticle(article);
	}

	public Article queryArticleById(String id) {
		return articleDao.queryArticleById(id);
	}

	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

}
