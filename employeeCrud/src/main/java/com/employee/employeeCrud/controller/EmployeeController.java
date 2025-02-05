package com.employee.employeeCrud.controller;

import com.employee.employeeCrud.dto.EmployeeDto;
import com.employee.employeeCrud.dto.EmployeeResponse;
import com.employee.employeeCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }
    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id,employeeDto);
    }
    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Integer id){
        return employeeService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping
    public EmployeeResponse viewAllEmployee(
            @RequestParam (defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize)
    {
        return employeeService.viewAllEmployee(pageNo,pageSize);
    }

}
