package com.briup.demo.service;

import com.briup.demo.bean.Customer;
import com.briup.demo.utils.CustomerException;

/**
 * 关于用户的service层
 * @author Administrator
 *
 */
public interface ICustomerService {
	/**
	 * 存储用户
	 * @param customer
	 * @throws CustomerException
	 */
	void saveCustomer(Customer customer) throws CustomerException;
	/**
	 * 查找用户
	 * @param id
	 * @return
	 * @throws CustomerException
	 */
	Customer selectCustomerById(Integer id) throws CustomerException;
	/**
	 * 删除用户
	 * @param id
	 * @throws CustomerException
	 */
	void deleteCustomerById(Integer id) throws CustomerException;
	/**
	 * 修改用户信息
	 * @param customer
	 * @throws CustomerException
	 */
	void updateCustomer(Customer customer) throws CustomerException;
}
