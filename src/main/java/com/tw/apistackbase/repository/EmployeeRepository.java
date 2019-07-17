package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private final static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    static {
        employees.put(1,createEmployee(1,"alibaba1",21,"female",8000));
        employees.put(2,createEmployee(2,"tengxun1",22,"male",9000));
        employees.put(3,createEmployee(3,"baidu1",22,"male",10000));
    }

    static public Employee createEmployee(int id,String name,int age,String gender,double salary){
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

    public Employee getEmployeeById(int employeeId) {
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

    public void delete(int employeeId) {
        employees.remove(employeeId);
    }

    public List<Employee> getEmployeesByPageQuery(int page, int pageSize) {
        List<Employee> employeeList = employees.values().stream().collect(Collectors.toList());
        return employeeList.subList((page - 1) * pageSize, page * pageSize);
    }
}
