package com.blog.controller.admin;

import com.blog.entity.Tag;
import com.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping(value = "/admin/tag")
public class TagController extends CoreController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", defaultValue = "0") int page,
            ModelMap modelMap){

        Page<Tag> tags = this.tagService.findAllByPage(page,this.pageSize);
        modelMap.addAttribute("tags",tags.getContent());
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("pageSize",this.pageSize);
        modelMap.addAttribute("dataCount",tags.getTotalElements());
        return "admin/tag/index";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addForm(){
        return "admin/tag/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveAction(Tag tag, ModelMap modelMap){
        String msg = "";
        try {
            this.tagService.save(tag);
            msg = "保存成功";
        }catch (Exception ex){
            msg = ex.toString();
        }
        return showNotice(modelMap,msg,"/admin/tag");
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editForm(@RequestParam(value = "id", defaultValue = "0") int id,
            ModelMap modelMap){

        try {
            Tag tag = this.tagService.findOne(id);
            modelMap.addAttribute("tag",tag);
        }catch (Exception ex){
            return ex.toString();
        }

        return "admin/tag/edit";
    }

}
