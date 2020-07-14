package com.briup.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "测试接口")
public class TestController {
	@RequestMapping("/t")
	@ApiOperation("哇卡拉卡")
	public String test() {
		return "hello";
	}
}
