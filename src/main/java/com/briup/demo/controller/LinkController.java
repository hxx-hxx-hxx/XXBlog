package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Link;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与链接相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "链接相关接口")
public class LinkController {
	@Autowired
	private ILinkService linkService;
	
	@PostMapping("/addLink")
	@ApiOperation("新增链接")
	public Message<String> addLink(Link link) {
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}

	@GetMapping("/findLink")
	@ApiOperation("查找链接")
	public Message<Link> selectLink(Integer id){
			try {
				Link link = linkService.selectLink(id);
					return MessageUtil.success(link);
			} catch (CustomerException e) {
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
			
	}
	
	@GetMapping("/findAllLink")
	@ApiOperation("查找所有链接")
	public Message<List<Link>> selectLinks(){
				List<Link> list = linkService.findAllLinks();
				return MessageUtil.success(list);		
	}
	@GetMapping("/findLinksByName")
	@ApiOperation("根据链接名查找链接")
	public Message<List<Link>> selectLinksByName(String name){
				List<Link> list = linkService.findLinksByName(name);
				return MessageUtil.success(list);		
	}
	
	@GetMapping("/deleteLink")
	@ApiOperation("删除链接")
	public Message<String> deleteLink(Integer id){
			try {
				linkService.deleteLinkById(id);			
				return MessageUtil.success();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
	}
	
	@PostMapping("/updateLink")
	@ApiOperation("更新链接")
	public Message<String> updateLink(Link link){
			try {
				linkService.saveOrUpdateLink(link);		
				return MessageUtil.success();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
	}
}
