package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CompanyController {

    @Resource
    CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> findAll(){
        return companyService.getAll();
    }

    @GetMapping("/companies/{companyName}")
    public Company findCompanyByName(@PathVariable String companyName){
        return companyService.getCompanyById(companyName);
    }

    @GetMapping("/companies/{companyName}/employees")
    public List<Employee> findEmployeesByCompanyId(@PathVariable String companyName){
        return companyService.getAllEmployeesByCompanyId(companyName);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @DeleteMapping("/companies/{companyName}")
    public void deleteCompanyEmployees(@PathVariable String companyName){
        companyService.deleteAllEmployees(companyName);
    }

    @GetMapping("/companies/{page}/{pageSize}")
    public List<Company> findCompanyByPageQuery(@PathVariable int page, @PathVariable int pageSize){
        return companyService.getCompaniesByPageQuery(page,pageSize);
    }
}
