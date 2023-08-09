package com.pblgllgs.departmentservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pblgllgs.departmentservice.dto.DepartmentDto;
import com.pblgllgs.departmentservice.entity.Department;
import com.pblgllgs.departmentservice.exception.ResourceNotFoundException;
import com.pblgllgs.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Department department = objectMapper.convertValue(departmentDto, Department.class);
        Department departmentSaved = departmentRepository.save(department);
        return objectMapper.convertValue(departmentSaved, DepartmentDto.class);
    }

    @Override
    public DepartmentDto findByDepartmentCode(String code) {
        Department departmentDb =
                departmentRepository.findByDepartmentCode(code).orElseThrow(
                        () -> new ResourceNotFoundException("Department", "code", code)
                );
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(departmentDb, DepartmentDto.class);
    }
}
