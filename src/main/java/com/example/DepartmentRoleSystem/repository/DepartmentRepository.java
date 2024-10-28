package com.example.DepartmentRoleSystem.repository;

import com.example.DepartmentRoleSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long> {
}
