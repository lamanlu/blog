package com.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Created by LamanLu on 2016/11/15.
 */
@Controller
public class AuthController {

    @RequestMapping(value = "/adm-login",method = RequestMethod.GET)
    public String loginView(Principal principal, RedirectAttributes redirectAttributes){
        return principal == null ? "admin/login" : "redirect:/";
    }

}
