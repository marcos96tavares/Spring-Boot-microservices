package com.example.department_service.Service.Imp;

import com.example.department_service.Dto.DepartmentDto;
import com.example.department_service.Entity.Department;
import com.example.department_service.Repository.DepartmentRepository;
import com.example.department_service.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.DatagramPacket;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {



        Department department = departmentRepository.save(dtoToDepartment(departmentDto));

        return departmentToDto(department);


    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        return departmentToDto(department);
    }


    private Department dtoToDepartment( DepartmentDto departmentDto){

        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
    }

    private DepartmentDto departmentToDto( Department department){

        return new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }



}
