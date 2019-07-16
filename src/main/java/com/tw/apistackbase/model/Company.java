package com.tw.apistackbase.model;

import java.util.List;

public class Company {
    private String companyName;
    private int EmployeesNumber;
    private List<Employee> employees;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeesNumber() {
        return EmployeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        EmployeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
