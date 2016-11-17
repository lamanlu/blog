package com.blog.controller;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;
import com.blog.entity.Category;
import com.blog.entity.Tag;
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.TagService;
import com.blog.service.UserService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by laman on 16-11-6.
 */
@Controller
@RequestMapping(value = "/")
public class Index {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;


    private int pageSize = 20;


    @RequestMapping(value = "/")
    public String Home(@RequestParam(value = "page",defaultValue = "0") int page,
                       ModelMap modelMap){

        Page<Article> articlePage = this.articleService.findPublishedList(page,this.pageSize);

        modelMap.addAttribute("title","Home Page Title");
        modelMap.addAttribute("articles",articlePage.getContent());
        modelMap.addAttribute("dataCount",articlePage.getTotalElements());
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("pageSize",pageSize);
        this.loadPublicData(modelMap);
        return "blog/index";
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String ListByCategory(
            @RequestParam(value = "id", defaultValue = "1") int category_id,
            @RequestParam(value = "page",defaultValue = "0") int page,
            ModelMap modelMap){

        Page<Article> articlePage = this.articleService.findPublishedListByCategory(category_id,page,this.pageSize);

        modelMap.addAttribute("title","Category Page Title");
        modelMap.addAttribute("articles",articlePage.getContent());
        modelMap.addAttribute("dataCount",articlePage.getTotalElements());
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("pageSize",pageSize);
        this.loadPublicData(modelMap);
        return "blog/category";
    }

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public String ListByTag(
            @RequestParam(value = "id", defaultValue = "1") int tag_id,
            @RequestParam(value = "page",defaultValue = "0") int page,
            ModelMap modelMap){

        Page<Article> articlePage = this.articleService.findPublishedListByTagId(tag_id,page,this.pageSize);

        modelMap.addAttribute("title","Tag Page Title");
        modelMap.addAttribute("articles",articlePage.getContent());
        modelMap.addAttribute("dataCount",articlePage.getTotalElements());
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("pageSize",pageSize);
        this.loadPublicData(modelMap);
        return "blog/tag";
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String Detail(
            @RequestParam(value = "id", defaultValue = "0") int id,
            ModelMap modelMap){

        Article article = this.articleService.findById(id);

        modelMap.addAttribute("article",article);

        this.loadPublicData(modelMap);
        return "blog/detail";
    }

    private void loadPublicData(ModelMap modelMap){

        List<Category> categories = this.categoryService.findAllOderBySort();

        List<Tag> tags = this.tagService.findAll();

        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("tags",tags);
    }

//    @Autowired
//    private UserService userService;

//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    @ResponseBody
//    public String test(){
//
//        String username = "admin";
//        String password = "123456";
//        User user = new User();
//        user.setUsername(username);
//        user.setUserpwd(password);
//        user.setRole("ROLE_USER");
//
//        this.userService.createUser(user);
//
//        return "成功";
//    }
}
