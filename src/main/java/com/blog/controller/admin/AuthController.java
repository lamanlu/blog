package com.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LamanLu on 2016/11/15.
 */
@Controller
public class AuthController {

    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String loginView(){
        return "admin/login";
    }

    @RequestMapping(value = "/authuser",method = RequestMethod.POST)
    public String loginAction(){
        return "redirect:/admin/article";
    }
}
