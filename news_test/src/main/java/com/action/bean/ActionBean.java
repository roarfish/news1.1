package com.action.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Article;
import com.entity.ArticlePojo;
import com.entity.Manager;
import com.entity.Nav;
import com.sql.SqlHelper;

public class ActionBean {
	/**
	 * 页面展示全部管理员信息
	 * @return
	 */
	public String queryManagerAll(){
		SqlHelper sqlhelper=new SqlHelper();
		List<Manager> list=sqlhelper.queryManagerAll();
		StringBuffer tabHtml =new StringBuffer();
		int i=1;
		for(Manager manager:list){
			tabHtml.append("<tr>"
					+ "<td class=\"text-center\"><input type=\"radio\" name=\"box\" value=\""+manager.getManager_id()+"\"></td>"
					+ "<td class=\"text-center\">"+(i++)+"</td>"
					+ "<td class=\"text-center\">"+manager.getManager_id()+"</td>"
					+ "<td>"+manager.getManager_name()+"</td>"
					+ "<td><input type=\"button\" value=\"修改\" onclick=\"updateManager(this);\"></td>"
					+ "</tr>");
		}
		sqlhelper.destroy();
		return tabHtml.toString();
	}
	/**
	 * 查询全部新闻类别信息
	 * @return
	 */
	public String queryNavAll(){
		SqlHelper sqlhelper=new SqlHelper();
		List<Nav> list=sqlhelper.queryNavAll();
		StringBuffer tabHtml =new StringBuffer();
		for(Nav nav:list){
			tabHtml.append("<tr>"
					+ "<td class=\"text-center\"><input type=\"radio\" name=\"box\" value=\""+nav.getNav_id()+"\"></td>"
					+ "<td class=\"text-center\">"+nav.getNav_name()+"</td>"
					+ "<td>"+nav.getNav_feight()+"</td>"
					+ "<td><input type=\"button\" value=\"修改\" onclick=\"updateNav(this);\"></td>"
					+ "</tr>");
		}
		sqlhelper.destroy();
		return tabHtml.toString();
	}
	public List<Nav> queryNavForList(){
		SqlHelper sqlhelper=new SqlHelper();
		List<Nav> list=sqlhelper.queryNavAll();
		sqlhelper.destroy();
		return list;
	}
	
	public List<ArticlePojo> queryArticleAll(){
		List<ArticlePojo> list=null;
		SqlHelper sqlhelper=new SqlHelper();
		list=sqlhelper.queryArticleAll();
		sqlhelper.destroy();
		return list;
	}
	
	public Map queryArticleByPage(int p,String nav_id,String article_title){
		Map map = new HashMap();
		SqlHelper sqlHelper = new SqlHelper();
		map.put("list", sqlHelper.queryArticleMapByPage(p,nav_id,article_title));
		map.put("rows", sqlHelper.queryArticleCount(nav_id,article_title));
		map.put("navList", sqlHelper.queryNavAll());
		sqlHelper.destroy();
		return map;
	}
	
	public List<Map> queryArticleForCondition(int p,String nav_id,String article_title){
		SqlHelper sqlhelper=new SqlHelper();
		List<Map> map=sqlhelper.queryArticleMapByPage(p,nav_id,article_title);
		sqlhelper.destroy();
		return map;
	}
	
	public int queryArticleCount(){
		SqlHelper sqlhelper=new SqlHelper();
		int totalPage=sqlhelper.queryArticleCount();
		sqlhelper.destroy();
		return totalPage;
	}
	
	public Map queryArticleMap4Edit(String article_id){
		Map map = new HashMap();
		SqlHelper sqlHelper = new SqlHelper();
		map.put("navList", sqlHelper.queryNavAll());//查询出所有的分类List
		map.put("article", sqlHelper.queryArticleById(article_id));//根据新闻的主键ID查询出此条新闻 article
		sqlHelper.destroy();
		return map;
	}
	/**
	 * 根据ID查询新闻类别信息
	 * @param manager_id
	 * @return
	 */
	public Nav queryNavById(String nav_id){
		SqlHelper sqlhelper=new SqlHelper();
		Nav nav=sqlhelper.queryNavById(nav_id);
		sqlhelper.destroy();
		return nav;
	}
	/**
	 * 根据ID查询管理员信息
	 * @param manager_id
	 * @return
	 */
	public Manager queryManagerById(String manager_id){
		SqlHelper sqlhelper=new SqlHelper();
		Manager manager=sqlhelper.queryManagerById(manager_id);
		sqlhelper.destroy();
		return manager;
	}
	/**
	 * 根据选中ID进行批量删除
	 */
	public void deleteManagerById(String manager_id){
		SqlHelper sqlhelper=new SqlHelper();
		sqlhelper.deleteManager(manager_id);
		sqlhelper.destroy();
	}
	/**
	 * 根据选中ID进行删除
	 */
	public void deleteNavById(String nav_id){
		SqlHelper sqlhelper=new SqlHelper();
		sqlhelper.deleteNav(nav_id);
		sqlhelper.destroy();
	}
}
