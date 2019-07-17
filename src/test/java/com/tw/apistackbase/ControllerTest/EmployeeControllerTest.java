package com.tw.apistackbase.ControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import com.tw.apistackbase.service.EmployeeService;
import com.tw.apistackbase.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeServiceImpl employeeService;

    @Test
    public void should_find_employees() throws Exception {
        Employee employee1 = new Employee();
        employee1.setName("xh");
        employee1.setGender("male");
        employee1.setSalary(8000);
        employee1.setAge(22);
        employee1.setId(1);

        Employee employee2 = new Employee();
        employee2.setName("xm");
        employee2.setGender("male");
        employee2.setSalary(8000);
        employee2.setAge(22);
        employee2.setId(2);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        when(employeeService.getAll()).thenReturn(employees);

        ResultActions result = mvc.perform(get("/employees"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(2)));

        verify(employeeService).getAll();

    }

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

        verify(employeeService).getEmployeeById(employee.getId());

    }

    @Test
    public void should_find_employee_by_gender() throws Exception {
        Employee employee = new Employee();
        employee.setName("alibaba1");
        employee.setGender("female");
        employee.setSalary(8000);
        employee.setAge(21);
        employee.setId(3);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        when(employeeService.getEmployeesByGender(anyString())).thenReturn(employees);

        ResultActions result = mvc.perform(get("/employees?gender={gender}",employee.getGender()));

        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].name",is("alibaba1")))
                .andExpect(jsonPath("$[0].id",is(3)))
                .andExpect(jsonPath("$[0].age",is(21)))
                .andExpect(jsonPath("$[0].gender",is("female")))
                .andExpect(jsonPath("$[0].salary",is(8000.0)));

        verify(employeeService).getEmployeesByGender(employee.getGender());
    }

    @Test
    public void should_find_employee_by_page_query() throws Exception {
        Employee employee = new Employee();
        employee.setName("alibaba1");
        employee.setGender("female");
        employee.setSalary(8000);
        employee.setAge(21);
        employee.setId(3);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        when(employeeService.getEmployeesByPageQuery(anyInt(),anyInt())).thenReturn(employees);

        ResultActions result = mvc.perform(get("/employees?page=1&pageSize=1"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].id",is(3)));
    }

    @Test
    public void should_add_employee() throws Exception {

        ResultActions result = mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"alibaba1\",\n" +
                "    \"age\": 21,\n" +
                "    \"gender\": \"female\",\n" +
                "    \"salary\": 8000\n" +
                "}"));

        result.andExpect(status().isOk());
    }

    @Test
    public void should_update_employee() throws Exception {
        Employee employee = new Employee();

        doNothing().when(employeeService).updateEmployee(employee);

        ResultActions result = mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(employee)));

        result.andExpect(status().isOk());

//        verify(employeeService).updateEmployee(employee);
    }

    @Test
    public void should_delete_employee() throws Exception {
        int employeeId = 1;

        doNothing().when(employeeService).deleteEmployee(employeeId);

        ResultActions result = mvc.perform(delete("/employees/{id}",employeeId));

        result.andExpect(status().isOk());

        verify(employeeService).deleteEmployee(employeeId);
    }



}
