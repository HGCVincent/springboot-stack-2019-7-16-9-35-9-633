package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getEmployeeById(int id);

    List<Employee> getEmployeesByGender(String gender);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    List<Employee> getEmployeesByPageQuery(int page, int pageSize);
}
