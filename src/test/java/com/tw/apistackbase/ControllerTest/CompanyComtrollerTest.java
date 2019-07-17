package com.tw.apistackbase.ControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.controller.CompanyController;
import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompanyController.class)
public class CompanyComtrollerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    CompanyService companyService;

    @Test
    public void should_return_company_when_find_all_companies() throws Exception {
        Company company1 = new Company();
        company1.setCompanyName("alibaba");

        Company company2 = new Company();
        company2.setCompanyName("tengxun");

        List<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        when(companyService.getAll()).thenReturn(companies);

        ResultActions result = mvc.perform(get("/companies"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(2)));

        verify(companyService).getAll();
    }

    @Test
    public void should_find_company_by_name() throws Exception {
        Company company = new Company();
        company.setCompanyName("alibaba");

        when(companyService.getCompanyById(anyString())).thenReturn(company);

        ResultActions result = mvc.perform(get("/companies/{companyName}",company.getCompanyName()));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.companyName",is("alibaba")));

        verify(companyService).getCompanyById(company.getCompanyName());

    }



    @Test
    public void should_delete_employee() throws Exception {
        String companyName = "alibaba";

        doNothing().when(companyService).deleteAllEmployees(companyName);

        ResultActions result = mvc.perform(delete("/companies/{name}",companyName));

        result.andExpect(status().isOk());

        verify(companyService).deleteAllEmployees(companyName);
    }

    @Test
    public void should_add_company() throws Exception {
        Company company =new Company();
        company.setCompanyName("tengxun");

        doNothing().when(companyService).deleteAllEmployees(company.getCompanyName());

        ResultActions result = mvc.perform(delete("/companies/{name}",company.getCompanyName()));

        result.andExpect(status().isOk());

        verify(companyService).deleteAllEmployees(company.getCompanyName());
    }
}
