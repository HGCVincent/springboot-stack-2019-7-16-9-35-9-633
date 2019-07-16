package com.tw.apistackbase.controller;


import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {

    @Resource
    EmployeeServiceImpl employeeService;
//    GET       /employees    #obtain employee list
//    GET       /employees/1  # obtain a certain specific employee
//    GET       /employees?page=1&pageSize=5  #Page query, page equals 1, pageSize equals 5
//    GET       /employees?gender=male   #screen all male employees
//    POST      /employees    # add an employee
//    PUT       /employees/1  #update an employee
//    DELETE    /employees/1  #delete an employee

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/{gender}")
    public List<Employee> findEmployeeByGender(@PathVariable String gender){
        return  employeeService.getEmployeesByGender(gender);
    }

    @GetMapping("/employees/{page}/{pageSize}")
    public List<Employee> findEmployeeByPageAndPageSize(@PathVariable int page,@PathVariable int pageSize){
        return employeeService.getEmployeesByPageQuery(page, pageSize);
    }


    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employId}")
    public void deleteEmployeeById(@PathVariable int employId){
        employeeService.deleteEmployee(employId);
    }
}
