package com.blog.controller.admin;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController extends CoreController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String index(ModelMap modelMap){

        List<Category> categories = this.categoryDao.findAll();
        modelMap.addAttribute("categories",categories);
        return "admin/category/index";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addForm(){
        return "admin/category/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addAction(@RequestParam(value = "name", defaultValue = "unknown") String name,
                            @RequestParam(value = "sort", defaultValue = "0") int sort,
                            ModelMap modelMap){
        String id = "";
        System.out.println(name);
        Category category = new Category(name,sort);
        try {
            this.categoryDao.save(category);
            id = String.valueOf(category.getId());
        }catch (Exception ex){
            return ex.toString();
        }

        return showNotice(modelMap,"ID:"+id,"/admin/category");
    }



}
