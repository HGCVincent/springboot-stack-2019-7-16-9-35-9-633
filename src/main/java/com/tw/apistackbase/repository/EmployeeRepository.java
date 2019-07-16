package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private final static Map<String, Employee> employees = new HashMap<String, Employee>();

    static {
        employees.put("1",createEmployee("1","alibaba1",21,"female",8000));
        employees.put("2",createEmployee("2","tengxun1",22,"male",9000));
        employees.put("3",createEmployee("3","baidu1",22,"male",10000));
    }

    static public Employee createEmployee(String id,String name,int age,String gender,double salary){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setSalary(salary);
        return employee;
    }

    public List<Employee> getAll() {
        return employees.values().stream().collect(Collectors.toList());
    }

    public Employee getEmployeeById(String employeeId) {
        return employees.get(employeeId);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return employees.values().stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(),employee);
    }

    public void update(Employee employee) {
        employees.put(employee.getId(),employee);
    }

    public void delete(String employeeId) {
        employees.remove(employeeId);
    }
}
