package com.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Controller
public class CoreController {

    protected String showNotice(ModelMap modelMap,String message,String url){
        modelMap.addAttribute("message",message);
        modelMap.addAttribute("url",url);
        return "admin/public/notice";
    }

}
