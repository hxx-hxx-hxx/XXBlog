package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Link;
import com.briup.demo.bean.LinkExample;
import com.briup.demo.bean.LinkExample.Criteria;
import com.briup.demo.mapper.LinkMapper;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 操作链接的service功能类
 * @author Administrator
 *
 */
@Service
public class LinkServiceImpl implements ILinkService {
	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public void saveOrUpdateLink(Link link) throws CustomerException {
		//参数为引用类型要判断是否为空
		if(link == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空！");
		}
		if(link.getId()==null) {
			linkMapper.insert(link);
		}else {
			linkMapper.updateByPrimaryKey(link);
		}  
	}

	@Override
	public Link selectLink(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查询id不得为空");
		}
		Link link = linkMapper.selectByPrimaryKey(id);
		if(link!=null)
			return link;
		else
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查询的链接不存在");
	}

	@Override
	public void deleteLinkById(Integer id) throws CustomerException {
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "删除的id不得为空");
		}
		Link link = linkMapper.selectByPrimaryKey(id);
		if(link!=null)
			linkMapper.deleteByPrimaryKey(id);
		else
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "删除的链接不存在");
	}

	@Override
	public List<Link> findAllLinks() throws CustomerException {
		LinkExample example = new LinkExample();
		//Criteria criteria = example.createCriteria();
		List<Link> list = linkMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Link> findLinksByName(String name) throws CustomerException {
		LinkExample example = new LinkExample();
		name=name==null?"" : name.trim();
		if("".equals(name)) {
			return linkMapper.selectByExample(example);
		}
		else {
			Criteria criteria = example.createCriteria();
			criteria.andNameLike("%"+name+"%");
			List<Link> list = linkMapper.selectByExample(example);
			return list;
		}
	}

}
