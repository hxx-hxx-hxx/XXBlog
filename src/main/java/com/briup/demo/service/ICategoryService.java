package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.utils.CustomerException;

/**
 * 关于栏目的Service层
 * @author Administrator
 *
 */
public interface ICategoryService {
	/**
	 * 存储栏目
	 * @param Category
	 * @throws CategoryException
	 */
	void saveOrUpdateCategory(Category category) throws CustomerException;
	/**
	 * 根据ID查找栏目
	 * @param id
	 * @return
	 * @throws CategoryException
	 */
	Category selectCategoryById(Integer id) throws CustomerException;
	/**
	 * 查找所有栏目
	 * @return
	 * @throws CustomerException
	 */
	List<Category> findAllCategorys() throws CustomerException;
	/**
	 * 根据ID删除栏目
	 * @param id
	 * @throws CategoryException
	 */
	void deleteCategoryById(Integer id) throws CustomerException;
}
