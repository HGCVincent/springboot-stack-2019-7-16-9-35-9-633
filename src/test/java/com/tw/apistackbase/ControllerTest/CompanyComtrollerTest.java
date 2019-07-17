package com.tw.apistackbase.ControllerTest;


import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class CompanyComtrollerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    CompanyService companyService;

    @Test
    public void should_return_company_when_find_all_companies(){
//        Company company1 = new Company();
//        company1.setCompanyName("alibaba");
//
//        Company company2 = new Company();
//        company2.setCompanyName("tengxun");
//
//        List<Company> companies = new ArrayList<>();
//        companies.add(company1);
//        companies.add(company2)
//
//        when(employeeService.getAll()).thenReturn(employees);
//
//        ResultActions result = mvc.perform(get("/employees"));
//
//        result.andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(2)));
//
//        verify(employeeService).getAll();
    }
}
