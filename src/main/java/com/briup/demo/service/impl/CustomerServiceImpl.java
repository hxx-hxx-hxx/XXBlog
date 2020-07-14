package com.briup.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Customer;
import com.briup.demo.mapper.CustomerMapper;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerMapper cm;
	@Override
	public void saveCustomer(Customer customer) throws CustomerException {
		if(customer == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空！");
		}
		cm.insert(customer);
	}

	@Override
	public Customer selectCustomerById(Integer id) throws CustomerException {
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查询id不得为空");
		}
		Customer customer = cm.selectByPrimaryKey(id);
		if(customer!=null)
			return customer;
		else
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查询的用户不存在");
	}

	@Override
	public void deleteCustomerById(Integer id) throws CustomerException {
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "删除的id不得为空");
		}
		Customer customer = cm.selectByPrimaryKey(id);
		if(customer!=null)
			cm.deleteByPrimaryKey(id);
		else
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "删除的用户不存在");


	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		if(customer==null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数不得为空！");
		}
		Customer customer2 = cm.selectByPrimaryKey(customer.getId());
		if(customer2!=null)
			cm.updateByPrimaryKey(customer);
		else
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "更改的用户不存在");

	}

	

}
