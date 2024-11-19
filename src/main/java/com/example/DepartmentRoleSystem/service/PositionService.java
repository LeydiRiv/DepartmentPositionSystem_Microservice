package com.example.DepartmentRoleSystem.service;


import com.example.DepartmentRoleSystem.model.Department;
import com.example.DepartmentRoleSystem.model.Position;
import com.example.DepartmentRoleSystem.repository.DepartmentRepository;
import com.example.DepartmentRoleSystem.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {


    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    //Get all records
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }


    //Position registration
    public Position registerPosition(Position position) {

        if(position.getName() == null || position.getName().isEmpty()){
            throw new RuntimeException("Error: The position name cannot be null or empty.");
        }

        // Check if the department exists before creating a position
        if (position.getDepartment() != null) {
            Long departmentId = position.getDepartment().getId();

            Department department = departmentRepository.findById(departmentId).orElse(null);

            // Throw an exception if the specified department does not exist
            if (department == null) {
                throw new RuntimeException("Error: The specified department does not exist.");
            }
            //Assign the found deparment to the position
            position.setDepartment(department);
        }
        return positionRepository.save(position);
    }


    // Method to get positions by department Id
    public List<Position> findByDepartmentId(Long departmentId) {
        // Calls the repository to find positions based on department Id
        return positionRepository.findByDepartmentId(departmentId);
    }


    //Position update
    public Position updatePosition (Long id, Position updatePosition){
       if (updatePosition.getName() == null || updatePosition.getName().isEmpty()){
            throw new RuntimeException("Error: The position name cannot be null or empty");
       }

        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: The specified position does not exist"));

        position.setName(updatePosition.getName());
        return positionRepository.save(position);
    }

    //Position delete
    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }

}
