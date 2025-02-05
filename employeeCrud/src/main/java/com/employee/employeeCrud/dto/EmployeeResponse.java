package com.employee.employeeCrud.dto;

import java.util.List;

public class EmployeeResponse {
    private List<EmployeeDto> employees;
    private int currentPage;
    private int totalpages;
    private long totalElements;


    public EmployeeResponse(List<EmployeeDto> employees, int currentPage, int totalpages, long totalElements) {
        this.employees = employees;
        this.currentPage = currentPage;
        this.totalpages = totalpages;
        this.totalElements = totalElements;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
