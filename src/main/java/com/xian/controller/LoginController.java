package com.xian.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.entities.AdminEntity;
import com.xian.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    @Autowired
    AdminMapper adminMapper;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        AdminEntity admin = adminMapper.selectOne(new QueryWrapper<AdminEntity>().eq("admin_name", username));
        if(admin != null && admin.getPassword().equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
