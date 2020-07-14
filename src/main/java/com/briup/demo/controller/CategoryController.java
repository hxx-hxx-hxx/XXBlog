package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与栏目相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "栏目相关接口")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/addCategory")
	@ApiOperation("新增栏目")
	public Message<String> addCategory(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	@PostMapping("/updateCategory")
	@ApiOperation("修改栏目")
	public Message<String> updateCategory(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	@GetMapping("/findCategory")
	@ApiOperation("根据ID查找栏目类别")
	public Message<Category> selectLink(Integer id){
			try {
				Category category = categoryService.selectCategoryById(id);
					return MessageUtil.success(category);
			} catch (CustomerException e) {
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
			
	}
	@GetMapping("/findAllCategory")
	@ApiOperation("查找所有栏目")
	public Message<List<Category>> selectAllLinks(){
			try {
					List<Category> list = categoryService.findAllCategorys();
					return MessageUtil.success(list);
			} catch (CustomerException e) {
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
			
	}
	@GetMapping("/deleteCategory")
	@ApiOperation("根据ID删除栏目类别")
	public Message<String> deleteLink(Integer id){
			try {
				categoryService.deleteCategoryById(id);
				return MessageUtil.success();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
	}
}
