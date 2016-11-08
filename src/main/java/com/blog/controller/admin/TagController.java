package com.blog.controller.admin;

import com.blog.dao.TagDao;
import com.blog.entity.Tag;
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
@RequestMapping(value = "/admin/tag")
public class TagController extends CoreController {

    @Autowired
    private TagDao tagDao;

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String index(ModelMap modelMap){

        List<Tag> tags = this.tagDao.findAll();
        modelMap.addAttribute("tags",tags);
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
            this.tagDao.save(tag);
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
            Tag tag = this.tagDao.findOne(id);
            modelMap.addAttribute("tag",tag);
        }catch (Exception ex){
            return ex.toString();
        }

        return "admin/tag/edit";
    }

}
