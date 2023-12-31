package com.pblgllgs.departmentservice.controller;

import com.pblgllgs.departmentservice.dto.DepartmentDto;
import com.pblgllgs.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> findDepartmentById(@PathVariable("departmentCode") String code) {
        return new ResponseEntity<>(departmentService.findByDepartmentCode(code),HttpStatus.OK);
    }

}
