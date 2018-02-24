package com.zhou.product.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhou.common.web.JsonResult;
import com.zhou.product.entity.Nav;
import com.zhou.product.service.NavService;

@Controller
@RequestMapping("/nav/")
public class NavController {

	@Resource
	private NavService navService;
	
	/**
	 * 跳调转分类主页
	 * @return
	 */
	@RequestMapping("listUI")
	public String listUI(){
		return "nav/navList";
	}
	
	/**
	 * 跳转新增分类页面
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(){
		return "nav/addNav";
	}
	
	/**
	 * 跳转分类编辑页面
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(){
		return "nav/editNav";
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("queryNavList")
	@ResponseBody
	public JsonResult queryNav(int pageCurrent){
		Map<String, Object> map = navService.queryNavList(pageCurrent);
		return new JsonResult(map);
	}
	
	@RequestMapping("doQueryAllNavName")
	@ResponseBody
	public JsonResult doQueryAllNavName(){
		return new JsonResult(navService.doQueryAllNavName());
	}
	
	/**
	 * 删除管理员信息
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteNavById")
	@ResponseBody
	public JsonResult deleteNavById(String id){
		navService.deleteNavById(id);
		return new JsonResult();
	}
	
	/**
	 * 新增管理员
	 * @param nav
	 * @return
	 */
	@RequestMapping("addNav")
	@ResponseBody
	public JsonResult addNavById(Nav nav){
		navService.addNav(nav);
		return new JsonResult();
	}
	
	/**
	 * 根据id查询管理员信息
	 * @return
	 */
	@RequestMapping("queryNavById")
	@ResponseBody
	public JsonResult queryNavById(String id){
		return new JsonResult(navService.queryNavById(id));
	}
	
	/**
	 * 修改管理员信息
	 * @param nav
	 * @return
	 */
	@RequestMapping("updateNav")
	@ResponseBody
	public JsonResult updateNav(Nav nav){
		navService.updateNav(nav);
		return new JsonResult();
	}
}
