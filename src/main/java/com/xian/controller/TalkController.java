package com.xian.controller;

import com.xian.entities.DepartmentEntity;
import com.xian.entities.EmployeeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TalkController {


    @PostMapping("/talk/message")
    public String listEmployee(){

        

        return "talk/list";
    }


}
