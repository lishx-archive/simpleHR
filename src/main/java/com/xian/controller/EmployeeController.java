package com.xian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.entities.DepartmentEntity;
import com.xian.entities.EmployeeEntity;
import com.xian.mapper.EmployeeMapper;
import com.xian.service.DepartmentService;
import com.xian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;


    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;


    @GetMapping("/emps")
    public String listEmployee(Model model){
        Collection<EmployeeEntity> employees = employeeService.getAll();
        model.addAttribute("emps",employees);
        Collection<DepartmentEntity> departments = departmentService.getall();
        Map<Integer,String> maps = new HashMap<>();
        for (DepartmentEntity depart : departments) {
            maps.put(depart.getId(),depart.getDepName());
        }
        model.addAttribute("deptsMap",maps);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmployees(Model model){
        return getString(model);
    }

    @PostMapping("/emp")
    public String addEmployees(EmployeeEntity employee){
        if (employee.getId() == null){
            employeeService.save(employee);
        }else {
            employeeService.updateById(employee);

        }
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        EmployeeEntity employee = employeeService.getById(id);
        model.addAttribute("emp", employee);
        return getString(model);
    }

    private String getString(Model model) {
        Collection<DepartmentEntity> departments = departmentService.getall();
        model.addAttribute("depts",departments);
        Map<Integer,String> maps = new HashMap<>();
        for (DepartmentEntity depart : departments) {
            maps.put(depart.getId(),depart.getDepName());
        }
        model.addAttribute("deptsMap",maps);
        return "emp/add";
    }

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



}
