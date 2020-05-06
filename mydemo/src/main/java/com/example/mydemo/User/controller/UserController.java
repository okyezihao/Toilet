package com.example.mydemo.User.controller;

import com.example.mydemo.User.entity.UserEntity;
import com.example.mydemo.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    // controller层 调用 services层
    @Autowired
    UserServiceImpl userServiceImpl;

    // 返回数据
    @RequestMapping("/eachlist")
    public String list(Model model) {
        List<UserEntity> userEntities = userServiceImpl.queryAll();
        model.addAttribute("userEntities", userEntities);
        return "index";
    }

    // 插入 + 更新
    @RequestMapping("/addupdate")
    public String addUpdate(UserEntity userEntity) {
        userServiceImpl.addUpdate(userEntity);
        return "redirect:/eachlist";
    }

    // 删除信息
    @RequestMapping("/delete")
    public String delete(int id) {
        userServiceImpl.delete(id);
        return "redirect:/eachlist";
    }

    // 查询所有
    @RequestMapping("/all")
    @ResponseBody
    public List<UserEntity> queryAll() {
        return userServiceImpl.queryAll();
    }

}
