package com.dbms.team15.controllers;

import com.dbms.team15.models.Employee;
import com.dbms.team15.models.ServiceCenter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/employee")
    public List<Employee> getEmployee(){
        String sql = "SELECT * FROM EMPLOYEE";

        List<Employee> employees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Employee.class)
        );

        employees.forEach(System.out::println);
        return employees;
    }

    @PostMapping("/api/employee")
    public boolean addEmployee(@RequestBody Employee employee){
        String sql =
                "INSERT INTO EMPLOYEE (EMPLOYEE_ID, SERVICE_CENTER_ID, NAME, ADDRESS, START_DATE, ROLE, EMAIL, PHONE, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                employee.getEMPLOYEE_ID(),
                employee.getSERVICE_CENTER_ID(),
                employee.getNAME(),
                employee.getADDRESS(),
                employee.getSTART_DATE(),
                employee.getROLE(),
                employee.getEMAIL(),
                employee.getPHONE(),
                employee.getUSERNAME(),
                employee.getPASSWORD()
        );

        return true;
    }

    @GetMapping("/api/employee/{id}")
    public Employee getEmployeeByName(@PathVariable int id){
        String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = " + id;

        List<Employee> employees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Employee.class)
        );

        return employees.get(0);
    }

    @PutMapping("/api/employee/{id}")
    public boolean updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee
    ){
        String sql =
                "UPDATE EMPLOYEE SET SERVICE_CENTER_ID = ?, NAME = ?, ADDRESS = ?, START_DATE = ?, ROLE = ?, EMAIL = ?, PHONE = ?, USERNAME = ?, PASSWORD = ? WHERE EMPLOYEE_ID = " + id;

        jdbcTemplate.update(
                sql,
                employee.getSERVICE_CENTER_ID(),
                employee.getNAME(),
                employee.getADDRESS(),
                employee.getSTART_DATE(),
                employee.getROLE(),
                employee.getEMAIL(),
                employee.getPHONE(),
                employee.getUSERNAME(),
                employee.getPASSWORD(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/employee/{id}")
    public boolean deleteEmployee(@PathVariable int id){
        String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + id;
        jdbcTemplate.update(sql);
        return true;
    }
}
