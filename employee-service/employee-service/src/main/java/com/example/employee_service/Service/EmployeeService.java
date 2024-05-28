package com.example.employee_service.Service;

import com.example.employee_service.Dto.APIResponseDto;
import com.example.employee_service.Dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
