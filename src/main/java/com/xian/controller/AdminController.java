package com.xian.controller;

import com.xian.entities.AdminEntity;
import com.xian.entities.DepartmentEntity;
import com.xian.service.AdminService;
import com.xian.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collection;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;


    @GetMapping("/admins")
    public String listEmployee(Model model){
        Collection<AdminEntity> adminEntities = adminService.getAll();
        model.addAttribute("admins",adminEntities);
        return "admin/list";
    }


    @GetMapping("/admin")
    public String toAddEmployees(){
        return "admin/add";
    }

    @PostMapping("/admin")
    public String addEmployees(AdminEntity adminEntity){
        if (adminEntity.getId() == null){
            adminService.save(adminEntity);
        }else {
            adminService.updateById(adminEntity);
        }
        return "redirect:/admins";
    }

    @GetMapping("/admin/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        AdminEntity adminEntity = adminService.getById(id);
        model.addAttribute("admin", adminEntity);
        return "admin/add";
    }

    @PostMapping("/admin/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        adminService.removeById(id);
        return "redirect:/admins";
    }
}
