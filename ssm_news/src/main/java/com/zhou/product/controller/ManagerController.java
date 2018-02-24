package com.zhou.product.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhou.common.web.JsonResult;
import com.zhou.product.entity.Manager;
import com.zhou.product.service.ManagerService;

@Controller
@RequestMapping("/manager/")
public class ManagerController {
	
	@Resource
	private ManagerService managerService;
	
	/**
	 * 跳调转管理员主页
	 * @return
	 */
	@RequestMapping("listUI")
	public String listUI(){
		return "manager/managerList";
	}
	
	/**
	 * 跳转新增管理员页面
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(){
		return "manager/addManager";
	}
	
	/**
	 * 跳转管理员编辑页面
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(){
		return "manager/editManager";
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("queryManagerList")
	@ResponseBody
	public JsonResult queryManager(int pageCurrent){
		Map<String, Object> map = managerService.queryManagerList(pageCurrent);
		return new JsonResult(map);
	}
	
	/**
	 * 删除管理员信息
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteManagerById")
	@ResponseBody
	public JsonResult deleteMangerById(int id){
		managerService.deleteManagerById(id);
		return new JsonResult();
	}
	
	/**
	 * 新增管理员
	 * @param manager
	 * @return
	 */
	@RequestMapping("addManager")
	@ResponseBody
	public JsonResult addManagerById(Manager manager){
		managerService.addManager(manager);
		return new JsonResult();
	}
	
	/**
	 * 根据id查询管理员信息
	 * @return
	 */
	@RequestMapping("queryManagerById")
	@ResponseBody
	public JsonResult queryManagerById(int id){
		return new JsonResult(managerService.queryManagerById(id));
	}
	
	/**
	 * 修改管理员信息
	 * @param manager
	 * @return
	 */
	@RequestMapping("updateManager")
	@ResponseBody
	public JsonResult updateManager(Manager manager){
		managerService.updateManager(manager);
		return new JsonResult();
	}
}
