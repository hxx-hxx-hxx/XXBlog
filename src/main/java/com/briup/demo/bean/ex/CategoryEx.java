package com.briup.demo.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Article;

import io.swagger.annotations.ApiParam;

/**
 * 保存栏目的所有数据
 * @author Administrator
 *
 */
public class CategoryEx implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
    
	@ApiParam(required = true,value="栏目编号")
    private Integer code;
    
    @ApiParam(required = true,value="栏目名称")
    private String name;
    
    private List<Article> articles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public CategoryEx(Integer id, Integer code, String name, List<Article> articles) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.articles = articles;
	}

	public CategoryEx() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
