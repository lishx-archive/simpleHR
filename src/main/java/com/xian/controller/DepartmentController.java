package com.xian.controller;

import com.xian.entities.DepartmentEntity;
import com.xian.entities.EmployeeEntity;
import com.xian.mapper.EmployeeMapper;
import com.xian.service.DepartmentService;
import com.xian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class DepartmentController {
    @Autowired
    EmployeeMapper employeeMapper;


    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;


    @GetMapping("/deps")
    public String listEmployee(Model model){
        Collection<DepartmentEntity> department = departmentService.getall();
        model.addAttribute("deps",department);
        return "dep/list";
    }


    @GetMapping("/dep")
    public String toAddEmployees(Model model){
        return "dep/add";
    }

    @PostMapping("/dep")
    public String addEmployees(DepartmentEntity department){
        if (department.getId() == null){
            departmentService.save(department);
        }else {
            departmentService.updateById(department);
        }
        return "redirect:/deps";
    }




    @GetMapping("/dep/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        DepartmentEntity department = departmentService.getById(id);
        model.addAttribute("dep", department);
        return "dep/add";
    }
    /**
    @PutMapping("/emp")
    public String updateEmp(EmployeeEntity employee){
        System.out.println(employee);
        return "redirect:/emps";
    }


    @PostMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.removeById(id);
        return "redirect:/emps";
    }
*/


}
