package com.tw.apistackbase.ControllerTest;


import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import com.tw.apistackbase.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeServiceImpl employeeService;

    @Test
    public void should_find_employee_by_id() throws Exception {
        Employee employee = new Employee();
        employee.setName("xh");
        employee.setGender("male");
        employee.setSalary(8000);
        employee.setAge(22);
        employee.setId(1);

        when(employeeService.getEmployeeById(anyInt())).thenReturn(employee);

        ResultActions result = mvc.perform(get("/employee/{id}",employee.getId()));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("xh")))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.age",is(22)))
                .andExpect(jsonPath("$.gender",is("male")))
                .andExpect(jsonPath("$.salary",is(8000.0)));

    }
}
