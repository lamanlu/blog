package com.blog.controller;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by laman on 16-11-6.
 */
@Controller
@RequestMapping(value = "/")
public class Index {

    @Autowired
    private ArticleDao articleDao;

    private int pageSize = 20;

    @RequestMapping(value = "/")
    public String Home(@RequestParam(value = "page",defaultValue = "0") int page,
                       ModelMap modelMap){

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,this.pageSize,sort);
        Page<Article> articlePage = this.articleDao.findByStatusGreaterThan((byte) 0,pageable);

        modelMap.addAttribute("title","Home Page Title");
        modelMap.addAttribute("articles",articlePage.getContent());
        modelMap.addAttribute("dataCount",articlePage.getTotalElements());
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("pageSize",pageSize);
        return "blog/index";
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String Detail(
            @RequestParam(value = "id", defaultValue = "0") int id,
            ModelMap modelMap){

        Article article = this.articleDao.getOne(id);

        System.out.println(article.getCreate_time());

        modelMap.addAttribute("article",article);
        return "blog/detail";
    }
}
