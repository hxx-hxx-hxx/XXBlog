package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与用户相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "用户相关接口")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/addCustomer")
	@ApiOperation("新增用户")
	public Message<String> addCustomer(Customer customer) {
		try {
			customerService.saveCustomer(customer);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}

	@GetMapping("/findCustomer")
	@ApiOperation("查找用户")
	public Message<Customer> selectCustomer(Integer id){
			try {
				Customer customer = customerService.selectCustomerById(id);
					return MessageUtil.success(customer);
			} catch (CustomerException e) {
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
			
	}
	@GetMapping("/deleteCustomer")
	@ApiOperation("删除用户")
	public Message<String> deleteCustomer(Integer id){
			try {
				customerService.deleteCustomerById(id);	
				return MessageUtil.success();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
	}
	@PostMapping("/updateCustomer")
	@ApiOperation("更新用户")
	public Message<Customer> updateCustomer(Customer customer){
			try {
				customerService.updateCustomer(customer);		
				return MessageUtil.success();
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
			}
	}
}
