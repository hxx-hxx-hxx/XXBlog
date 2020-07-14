package com.briup.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.IArticleService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public void saveOrUpdateArticle(Article article) throws CustomerException {
		if(article == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空！");
		}
		if(article.getId()==null) {
			article.setPublishdate(new Date());
			article.setClicktimes(0);
			articleMapper.insert(article);
		}
		else {
			articleMapper.updateByPrimaryKey(article);
		}

	}

	@Override
	public Article findArticle(Integer id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);	
		return article;
	}

	@Override
	public void deleteArticle(Integer id) throws CustomerException {
		articleMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<Article> findAllArticles() {
		ArticleExample example = new ArticleExample();
		List<Article> list = articleMapper.selectByExample(example);
		return list;
	}


	@Override
	public List<Article> findAllArticleByCondition(String keyStr, String condition) throws CustomerException {
		keyStr=keyStr==null?"" : keyStr.trim();
		condition=condition==null?"" : condition.trim();
		ArticleExample example = new ArticleExample();
		if("".equals(keyStr) && "".equals(condition)) {
			//返回所有文章
			List<Article> list = articleMapper.selectByExample(example);
			return list;
		}
		else if(!"".equals(keyStr) && "".equals(condition)) {
			example.createCriteria().andTitleLike("%"+keyStr+"%");
			return articleMapper.selectByExample(example);
		}
		else if(!"".equals(condition) && "".equals(keyStr)) {
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(condition);
			List<Category> list = categoryMapper.selectByExample(categoryExample);
			if(list.size()>0) {
				example.createCriteria().andCategoryIdEqualTo(list.get(0).getId());
			}
			else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE, "无指定的搜索栏目");
			}
			return articleMapper.selectByExample(example);
		}
		else if(!"".equals(keyStr) && !"".equals(condition)) {
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(condition);
			List<Category> list = categoryMapper.selectByExample(categoryExample);
			if(list.size()>0) {
				example.createCriteria().andCategoryIdEqualTo(list.get(0).getId()).andTitleLike("%"+keyStr+"%");
			}
			else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE, "无指定的搜索栏目");
			}
			return articleMapper.selectByExample(example);
		}
		return null;
	}

}
