package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerException;

/**
 * 关于链接的service层
 * @author Administrator
 *
 */
public interface ILinkService {
	/**
	 * 保存链接信息
	 * @param link
	 */
	void saveOrUpdateLink(Link link) throws CustomerException;
	/**
	 * 查询所有链接信息
	 */
	List<Link> findAllLinks() throws CustomerException;
	/**
	 * 根据id查询链接信息
	 * @param id
	 * @throws CustomerException
	 */
	Link selectLink(Integer id) throws CustomerException;
	/**
	 * 根据链接名查询链接
	 */
	List<Link> findLinksByName(String name) throws CustomerException;
	/**
	 * 删除链接
	 * @param id
	 * @throws CustomerException
	 */
	void deleteLinkById(Integer id) throws CustomerException;
}
