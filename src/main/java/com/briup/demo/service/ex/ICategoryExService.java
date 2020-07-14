package com.briup.demo.service.ex;

import java.util.List;

import com.briup.demo.bean.Article;

public interface ICategoryExService {
	/**
	 * 根据id查找该栏目下所有的文章
	 * @return
	 */
	List<Article> findAllArticlesByCategoryId(Integer id);
}
