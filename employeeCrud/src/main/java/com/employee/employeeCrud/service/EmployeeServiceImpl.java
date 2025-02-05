package com.employee.employeeCrud.service;

import com.employee.employeeCrud.dto.EmployeeDto;
import com.employee.employeeCrud.dto.EmployeeResponse;
import com.employee.employeeCrud.model.Employee;
import com.employee.employeeCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(),employeeDto.getName(),employeeDto.getAddress(),employeeDto.getSalary());
        employee=employeeRepository.save(employee);
        return new EmployeeDto(employee.getId(),employee.getName(),employee.getAddress(),employee.getSalary());
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee with such ID doesnt exists"));
        employee.setAddress(employeeDto.getAddress());
        employee.setSalary(employeeDto.getSalary());
        employee=employeeRepository.save(employee);
        return new EmployeeDto(employee.getId(), employee.getName(),employee.getAddress(),employee.getSalary());
    }

    @Override
    public EmployeeDto getById(Integer id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee with such id doesnt exists"));
        return new EmployeeDto(employee.getId(), employee.getName(), employee.getAddress(), employee.getSalary());
    }

    @Override
    public EmployeeResponse viewAllEmployee(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        List<EmployeeDto> employees = employeePage.getContent().stream()
                .map(e -> new EmployeeDto(e.getId(), e.getName(), e.getAddress(), e.getSalary()))
                .collect(Collectors.toList());

        return new EmployeeResponse(
                employees,
                employeePage.getNumber(),    // Current page number
                employeePage.getTotalPages(), // Total pages
                employeePage.getTotalElements() // Total elements (fix: use getTotalElements() instead of getTotalPages())
        );
    }


    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
