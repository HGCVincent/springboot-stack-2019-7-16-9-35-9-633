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
        companies.put("alibaba",createCompany("alibaba"));
        companies.put("tengxun",createCompany("tengxun"));
    }

    private static Company createCompany(String name) {
        Company company = new Company();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i<10; i++){
            Employee employee = new Employee();
            employee.setId(i);
            employee.setName(name + i);
            employee.setSalary(9000);
            employees.add(employee);
        }
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

    public List<Company> getCompaniesByPageQuery(int page, int pageSize) {
        List<Company> companyList = companies.values().stream().collect(Collectors.toList());
        return companyList.subList((page - 1) * pageSize, page * pageSize);
    }
}
