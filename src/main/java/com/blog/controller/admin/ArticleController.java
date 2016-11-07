package com.blog.controller.admin;

import com.blog.entity.Article;
import com.blog.entity.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LamanLu on 2016/11/7.
 */
@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addView(){

        return "admin/article/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String addAction(Article article){
        String id = "";
        try {
            articleRepository.save(article);
            id = String.valueOf(article.getId());
        }catch (Exception ex){
            return "Add Error :"+ex.toString();
        }
        return "保存成功，ID："+id;
    }

}
