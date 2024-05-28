package com.example.employee_service.Service.Impl;

import com.example.employee_service.Dto.APIResponseDto;
import com.example.employee_service.Dto.DepartmentDto;
import com.example.employee_service.Dto.EmployeeDto;
import com.example.employee_service.Entity.Employee;
import com.example.employee_service.Repository.EmployeeRepository;
import com.example.employee_service.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeRepository.save(DtoToEmployee(employeeDto));
        return employeeToDto(employee);
    }



    @Override
    public APIResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findEmployeeByEmployeeId(id);
        EmployeeDto employeeDto = employeeToDto(employee);

        DepartmentDto departmentDto = webClient
                .get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(employeeDto);

        return apiResponseDto;

    }


    private EmployeeDto employeeToDto (Employee employee){

        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getEmployeeFirstName(),
                employee.getEmployeeLastName(),
                employee.getEmployeeEmail(),
                employee.getDepartmentCode()
        );
    }
    private Employee DtoToEmployee(EmployeeDto employeeDto){

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
    }
}
