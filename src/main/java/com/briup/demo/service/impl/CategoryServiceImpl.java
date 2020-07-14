package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.ArticleExample.Criteria;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryMapper cm;
	@Autowired
	private ArticleMapper am;
	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		if(category == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空！");
		}
		CategoryExample example = new CategoryExample();
		example.createCriteria().andNameEqualTo(category.getName());
		List<Category> list = cm.selectByExample(example);
		if(list.size()>0)
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目已存在！");
		if(category.getId()==null) {
				cm.insert(category);
		}else {
			cm.updateByPrimaryKey(category);
		}

	}

	@Override
	public Category selectCategoryById(Integer id) throws CustomerException {
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查询id不得为空");
		}
		Category category = cm.selectByPrimaryKey(id);
		if(category!=null)
			return category;
		else
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "查询的栏目不存在");
	}

	@Override
	public void deleteCategoryById(Integer id) throws CustomerException {
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "删除的id不得为空");
		}	
			ArticleExample example = new ArticleExample();
			Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(id);
			am.deleteByExample(example);
			cm.deleteByPrimaryKey(id);
	}

	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		CategoryExample example = new CategoryExample();
		List<Category> list = cm.selectByExample(example);
		return list;
	}

}
