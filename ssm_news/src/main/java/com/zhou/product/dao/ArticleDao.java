package com.zhou.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.product.entity.Article;
import com.zhou.product.entity.ArticlePojo;

public interface ArticleDao {

	/**
	 * 分页查询
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<ArticlePojo> queryArticle(
			@Param("nav_id")String nav_id,
			@Param("article_title")String article_title,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	
	/**
	 * 查询新闻数量
	 * @return
	 */
	int queryArticleCount();
	
	/**
	 * 删除新闻信息
	 * @param id
	 */
	void deleteArticleById(String id);
	
	/**
	 * 新增新闻
	 * @param Article
	 */
	void addArticle(Article article);
	
	/**
	 * 修改新闻信息
	 * @param Article
	 */
	void updateArticle(Article article);
	
	/**
	 * 根据id查询新闻信息
	 * @param id
	 * @return
	 */
	Article queryArticleById(String id);
	
}
