package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CustomerException;

public interface IArticleService {
	/**
	 * 存储文章
	 * @param Article
	 * @throws ArticleException
	 */
	void saveOrUpdateArticle(Article article) throws CustomerException;
	/**
	 * 根据id查找文章
	 * @param id
	 * @return
	 * @throws ArticleException
	 */
	Article findArticle(Integer id) throws CustomerException;
	/**
	 * 查询文章
	 * @param keyStr 关键字
	 * @param condition 栏目
	 * @return
	 * @throws CustomerException
	 */
	List<Article> findAllArticleByCondition(String keyStr,String condition) throws CustomerException;
	/**
	 * 查找所有文章
	 */
	List<Article> findAllArticles() throws CustomerException;
	/**
	 * 删除文章
	 * @param id
	 * @throws ArticleException
	 */
	void deleteArticle(Integer id) throws CustomerException;
	
}
