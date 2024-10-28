package com.example.DepartmentRoleSystem.service;


import com.example.DepartmentRoleSystem.model.Department;
import com.example.DepartmentRoleSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    //Get all records
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    //Department registration
    public Department registerDepartment(Department department) {
        return departmentRepository.save(department);
    }


    //Department update
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department does not exist"));

        department.setName(updatedDepartment.getName());
        return departmentRepository.save(department);
    }


    //Department delete
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }


}
