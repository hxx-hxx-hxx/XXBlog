package com.briup.demo.controller.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.service.ex.IIndexResultService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(description = "查询所有")
public class IndexResultController {
	@Autowired
	private IIndexResultService indexResultServce;
	
	@GetMapping("/findAll")
	@ApiOperation("查找所有")
	public Message<IndexResult> findAll(){
		IndexResult result = indexResultServce.findAll();
		return MessageUtil.success(result);
	}
}
