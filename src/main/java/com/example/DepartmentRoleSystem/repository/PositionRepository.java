package com.example.DepartmentRoleSystem.repository;


import com.example.DepartmentRoleSystem.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    // Method to find all positions of a specific department using its ID
    List<Position> findByDepartmentId(Long departmentId);

}
