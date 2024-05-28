package com.example.department_service.Service;

import com.example.department_service.Dto.DepartmentDto;
import com.example.department_service.Entity.Department;

public interface DepartmentService {

DepartmentDto saveDepartment(DepartmentDto departmentDto);

DepartmentDto getDepartmentByCode(String departmentCode);
}
