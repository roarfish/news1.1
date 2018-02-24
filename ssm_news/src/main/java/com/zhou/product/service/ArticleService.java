package com.zhou.product.service;

import java.util.Map;

import com.zhou.product.entity.Article;

public interface ArticleService {

	Map<String, Object> queryArticleList(String nav_id, String article_title, int pageCurrent);

	void deleteArticleById(String id);

	Article queryArticleById(String id);

	void updateArticle(Article article);

	void addArticle(Article article);

}
