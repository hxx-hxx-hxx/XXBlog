package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.service.IArticleService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与文章相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "文章相关接口")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
	@PostMapping("/addArticle")
	@ApiOperation("新增文章")
	public Message<String> addArticle(Article article) {
		try {
			articleService.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
	@PostMapping("/updateArticle")
	@ApiOperation("更新文章")
	public Message<Article> updateArticle(Article article){
		try {
			articleService.saveOrUpdateArticle(article);		
			return MessageUtil.success();
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
		}
	}
	
	@GetMapping("/findArticle")
	@ApiOperation("根据id查找文章")
	public Message<Article> selectArticle(Integer id){
		Article article = articleService.findArticle(id);
		return MessageUtil.success(article);	
	}
	
	@GetMapping("/findAllArticles")
	@ApiOperation("查找所有文章")
	public Message<List<Article>> selectAllArticles(){
			List<Article> list = articleService.findAllArticles();
			return MessageUtil.success(list);	
	}
	@GetMapping("/findAllArticlesByCondition")
	@ApiOperation("根据关键字查找文章")
	public Message<List<Article>> selectArticlesByCondition(String keyStr,String condition){
		List<Article> list = articleService.findAllArticleByCondition(keyStr, condition);
		return MessageUtil.success(list);	
	}
	@GetMapping("/deleteArticle")
	@ApiOperation("删除文章")
	public Message<String> deleteLink(Integer id){
		articleService.deleteArticle(id);			
		return MessageUtil.success();	
	}
}