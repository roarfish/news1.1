package com.entity;
/**
 * 文章
 * @author zhoup
 *
 */
public class Article {
	//文章的UUID
	private String article_id;
	//文章的标题
	private String article_title;
	//发布时间
	private String article_date;
	//文章的内容
	private String article_content;
	//分类的ID
	private String nav_id;
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_date() {
		return article_date;
	}
	public void setArticle_date(String article_date) {
		this.article_date = article_date;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
	
	
}
