package com.example.DepartmentRoleSystem.controller;


import com.example.DepartmentRoleSystem.model.Position;
import com.example.DepartmentRoleSystem.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/positions")
public class PositionController {


    @Autowired
    private PositionService positionService;


    //Get all records
    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }


    //Position registration
    @PostMapping("/register")
    public Position registerPosition(@RequestBody Position position) {
        return positionService.registerPosition(position);
    }


    //Position update
    @PutMapping("/register/{id}")
    public Position updatePosition(@PathVariable Long id, @RequestBody Position position) {
        return positionService.updatePosition(id, position);
    }

    //Position delete
    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable Long id) {
        positionService.deletePosition(id);
    }



}
