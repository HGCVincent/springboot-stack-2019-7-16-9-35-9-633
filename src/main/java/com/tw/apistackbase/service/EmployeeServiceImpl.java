package com.tw.apistackbase.service;


import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        return employeeRepository.getEmployeeByGender(gender);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void deleteEmployee(String employeeId) {
        employeeRepository.delete(employeeId);

    }

}
