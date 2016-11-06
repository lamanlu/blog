package com.blog.controller;

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

    @RequestMapping(value = "/")
    public String Home(ModelMap modelMap){
        modelMap.addAttribute("title","Home Page Title");
        modelMap.addAttribute("hello","Hello My Blog Home Page !");
        return "blog/index";
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String Detail(
            @RequestParam(value = "id", defaultValue = "0") int id,
            ModelMap modelMap){

        modelMap.addAttribute("id",id);
        return "blog/detail";
    }
}
