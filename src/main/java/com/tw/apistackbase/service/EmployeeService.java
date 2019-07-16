package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee getEmployeeById(String id);

    public List<Employee> getEmployeesByGender(String gender);

    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(String employeeId);
}
