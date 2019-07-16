package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {

    private final static Map<String, Company> companies = new HashMap<>();

    static{
        Employee employee = new Employee();
        employee.setName("alibaba1");
        employee.setAge(21);
        employee.setId(123);
        employee.setSalary(9000);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        companies.put("alibaba",createCompany("alibaba",employees));
    }

    private static Company createCompany(String name,List<Employee> employees) {
        Company company = new Company();
        company.setEmployees(employees);
        company.setCompanyName(name);
        company.setEmployeesNumber(company.getEmployees().size());
        return company;
    }

    public List<Company> getAll() {
        return companies.values().stream().collect(Collectors.toList());
    }

    public Company getCompanyById(String id) {
        return companies.get(id);
    }

    public List<Employee> getAllEmployees(String companyId) {
        return companies.get(companyId).getEmployees();
    }

    public void addCompany(Company company) {
        companies.put(company.getCompanyName(),company);
    }

    public void deleteCompanyEmployee(String companyName) {
        companies.get(companyName).getEmployees().clear();
    }
}
