package com.briup.demo.service.impl.ex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.Link;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.service.ILinkService;
import com.briup.demo.service.ex.ICategoryExService;
import com.briup.demo.service.ex.IIndexResultService;
import com.briup.demo.utils.CustomerException;

@Service
public class IndexResultExImpl implements IIndexResultService{

	@Autowired
	private ILinkService linkservice;
	@Autowired
	private ICategoryExService categoryExService;
	@Autowired
	private ICategoryService categoryService;
	/**
	 * 返回所有保存的页面数据
	 */
	@Override
	public IndexResult findAll() throws CustomerException{
		IndexResult result = new IndexResult();//保存了页面所有的数据
		List<Link> links = linkservice.findAllLinks();//查找所有link
		result.setLinks(links);//将link赋值给result
		List<CategoryEx> categoryExs = new ArrayList<CategoryEx>();//保存所有栏目及其级联的文章
		List<Category> categories = categoryService.findAllCategorys();//查找所有栏目
		for(Category category:categories) {
			List<Article> articles = categoryExService.findAllArticlesByCategoryId(category.getId());
			CategoryEx ex = new CategoryEx();
			ex.setId(category.getId());
			ex.setCode(category.getCode().intValue());
			ex.setName(category.getName());
			ex.setArticles(articles);
			categoryExs.add(ex);
		}
		result.setCategoryExs(categoryExs);
		return result;
	}

}
