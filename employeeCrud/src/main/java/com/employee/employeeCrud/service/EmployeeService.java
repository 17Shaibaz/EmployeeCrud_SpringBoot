package com.employee.employeeCrud.service;

import com.employee.employeeCrud.dto.EmployeeDto;
import com.employee.employeeCrud.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Integer id,EmployeeDto employeeDto);
    EmployeeDto getById(Integer id);
    public EmployeeResponse viewAllEmployee(int pageNo, int pageSize);
    void deleteEmployee(Integer id);
}
