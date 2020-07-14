package com.briup.demo.controller.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.service.ex.ICategoryExService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 根据栏目id级联查询栏目下所有文章
 * @author Administrator
 *
 */
@RestController
@Api(description = "查询栏目下对应文章接口")
public class CategoryExController {
	@Autowired
	private ICategoryExService categoryExService;
	
	@PostMapping("/findAllArticles")
	@ApiOperation("查询该栏目下文章")
	public Message<List<Article>> findAllArticlesByCategoryId(Integer id) {
		try {
			List<Article> list = categoryExService.findAllArticlesByCategoryId(id);
			return MessageUtil.success(list);
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	
}
