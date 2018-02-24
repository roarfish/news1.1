package com.zhou.product.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhou.common.util.MyFuns;
import com.zhou.common.web.JsonResult;
import com.zhou.product.entity.Article;
import com.zhou.product.entity.ArticlePojo;
import com.zhou.product.service.ArticleService;

@Controller
@RequestMapping("/article/")
public class ArticleController {

	@Resource
	private ArticleService articleService;
	
	/**
	 * 跳调转文章管理主页
	 * @return
	 */
	@RequestMapping("listUI")
	public String listUI(){
		return "article/articleList";
	}
	
	/**
	 * 跳转新增文章管理页面
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(){
		return "article/addArticle";
	}
	
	/**
	 * 跳转文章管理编辑页面
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(){
		return "article/editArticle";
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("queryArticleList")
	@ResponseBody
	public JsonResult queryArticle(String nav_id, String article_title, int pageCurrent){
		Map<String, Object> map = articleService.queryArticleList(nav_id,article_title,pageCurrent);
		return new JsonResult(map);
	}
	
	/**
	 * 删除新闻信息
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteArticleById")
	@ResponseBody
	public JsonResult deleteArticleById(String id){
		articleService.deleteArticleById(id);
		return new JsonResult();
	}
	
	/**
	 * 新增新闻
	 * @param article
	 * @return
	 */
	@RequestMapping("addArticle")
	@ResponseBody
	public JsonResult addArticleById(Article article){
		articleService.addArticle(article);
		return new JsonResult();
	}
	
	/**
	 * 根据id查询新闻信息
	 * @return
	 */
	@RequestMapping("queryArticleById")
	@ResponseBody
	public JsonResult queryArticleById(HttpServletRequest requset,String id){
		Article a = articleService.queryArticleById(id);
		return new JsonResult(a);
	}
	
	/**
	 * 修改新闻信息
	 * @param article
	 * @return
	 */
	@RequestMapping("updateArticle")
	@ResponseBody
	public JsonResult updateArticle(Article article){
		articleService.updateArticle(article);
		return new JsonResult();
	}
}
