package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public Company getCompanyById(String companyName) {
        return companyRepository.getCompanyById(companyName);
    }

    @Override
    public List<Employee> getAllEmployeesByCompanyId(String companyId) {
        return companyRepository.getAllEmployees(companyId);
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.addCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.addCompany(company);
    }

    @Override
    public void deleteAllEmployees(String companyName) {
        companyRepository.deleteCompanyEmployee(companyName);
    }

    @Override
    public List<Company> getCompaniesByPageQuery(int page, int pageSize) {
        return companyRepository.getCompaniesByPageQuery(page,pageSize);
    }

}
