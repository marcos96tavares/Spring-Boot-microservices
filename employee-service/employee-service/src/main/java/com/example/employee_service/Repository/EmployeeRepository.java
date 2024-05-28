package com.example.employee_service.Repository;

import com.example.employee_service.Dto.EmployeeDto;
import com.example.employee_service.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByEmployeeId(Long id);
}
