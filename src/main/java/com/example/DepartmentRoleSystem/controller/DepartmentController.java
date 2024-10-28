package com.example.DepartmentRoleSystem.controller;


import com.example.DepartmentRoleSystem.model.Department;
import com.example.DepartmentRoleSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Get all records
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    //Department registration
    @PostMapping ("/register")
    public Department registerDepartment(@RequestBody Department department) {
        return departmentService.registerDepartment(department);
    }

    //Department update
    @PutMapping("/register/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    //Department delete
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }


}
