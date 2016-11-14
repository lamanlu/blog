package com.blog.controller.admin;

import com.blog.dao.ArticleDao;
import com.blog.dao.CategoryDao;
import com.blog.dao.TagDao;
import com.blog.entity.Article;
import com.blog.entity.Category;
import com.blog.entity.Tag;
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController extends CoreController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private TagDao tagDao;

    //文章状态
    private static HashMap<Byte,String> status = new HashMap<Byte, String>();

    public ArticleController() {
        setStatus();
    }

    private static void setStatus(){
        status.put((byte)-1,"已删除");
        status.put((byte)0,"草稿");
        status.put((byte)1,"已发布");
    }

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String index(@RequestParam(value = "page",defaultValue = "0") int page,
            ModelMap modelMap){

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,this.pageSize,sort);
        Page<Article> articlePage = this.articleDao.findAll(pageable);


        modelMap.addAttribute("articles",articlePage.getContent());
        modelMap.addAttribute("dataCount",articlePage.getTotalElements());
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("pageSize",pageSize);
        modelMap.addAttribute("status",status);
        return "admin/article/index";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addView(ModelMap modelMap){

        List<Tag> tags = this.tagDao.findAll();
        List<Category> categories = this.categoryDao.findAll();

        modelMap.addAttribute("tags",tags);
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("status",status);
        return "admin/article/add";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editView(@RequestParam(value = "id", defaultValue = "0") int id,
            ModelMap modelMap){

        Article article = this.articleDao.findOne(id);

        List<Tag> tags = this.tagDao.findAll();
        List<Category> categories = this.categoryDao.findAll();

        modelMap.addAttribute("tags",tags);
        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("status",status);
        modelMap.addAttribute("article",article);
        return "admin/article/edit";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Article article,
                       ModelMap modelMap){

        try {
            this.articleDao.save(article);
            int id = article.getId();
        }catch (Exception ex){
            return ex.toString();
        }

        return showNotice(modelMap,"保存成功","/admin/article");
    }

}
