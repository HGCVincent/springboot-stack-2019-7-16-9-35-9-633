package com.tw.apistackbase.service;


import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface CompanyService {

    public List<Company> getAll();

    public Company getCompanyById(String id);

    public List<Employee> getAllEmployeesByCompanyId(String CompanyId);

    public void addCompany(Company company);

    public void updateCompany(Company company);

    public void deleteAllEmployees(String companyName);

}
