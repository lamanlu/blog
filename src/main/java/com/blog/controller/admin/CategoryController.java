package com.blog.controller.admin;

import com.blog.entity.Category;
import com.blog.entity.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by laman on 16-11-7.
 */
@Controller
@RequestMapping(value = "/admin/category/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addView(){
        return "admin/category/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String addAction(
            @RequestParam(value = "name",defaultValue = "unknown") String name,
            @RequestParam(value = "sort",defaultValue = "0") int sort){
        String id = "";
        Category category = new Category(name,sort);
        try {
            this.categoryRepository.save(category);
            id = String.valueOf(category.getId());
        }catch (Exception ex){
            return ex.toString();
        }

        return "ID:"+id;
    }
}
