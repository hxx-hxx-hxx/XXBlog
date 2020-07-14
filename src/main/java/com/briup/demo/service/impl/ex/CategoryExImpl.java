package com.briup.demo.service.impl.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.service.ex.ICategoryExService;
import com.briup.demo.utils.CustomerException;

@Service
public class CategoryExImpl implements ICategoryExService{
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public List<Article> findAllArticlesByCategoryId(Integer id) throws CustomerException{
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryIdEqualTo(id);
		List<Article> list = articleMapper.selectByExample(example);
		return list;
	}

}
