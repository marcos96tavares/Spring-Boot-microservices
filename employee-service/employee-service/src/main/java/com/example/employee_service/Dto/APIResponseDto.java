package com.example.employee_service.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
}
