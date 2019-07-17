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

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/employees",params = {"gender"})
    public List<Employee> findEmployeeByGender(@RequestParam String gender){
        return  employeeService.getEmployeesByGender(gender);
    }

    @GetMapping(value = "/employees",params = {"page","pageSize"})
    public List<Employee> findEmployeeByPageAndPageSize(@RequestParam int page,@RequestParam int pageSize){
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
