package com.dbms.team15.controllers;

import com.dbms.team15.models.HourlyPaidEmployee;
import com.dbms.team15.models.SalariedEmployee;
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
public class SalariedEmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/salariedEmployee")
    public List<SalariedEmployee> getSalariedEmployee() {
        String sql = "SELECT * FROM SALARIED_EMPLOYEE";

        List<SalariedEmployee> salariedEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SalariedEmployee.class)
        );

        salariedEmployees.forEach(System.out::println);
        return salariedEmployees;
    }

    @PostMapping("/api/salariedEmployee")
    public boolean addsalariedEmployee(@RequestBody SalariedEmployee salariedEmployee) {
        String sql =
                "INSERT INTO SALARIED_EMPLOYEE (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                salariedEmployee.getEMPLOYEE_ID(),
                salariedEmployee.getSERVICE_CENTER_ID(),
                salariedEmployee.getSALARY()
        );

        return true;
    }

    @GetMapping("/api/salariedEmployee/{id}")
    public SalariedEmployee getsalariedEmployeeByName(@PathVariable int id) {
        String sql = "SELECT * FROM SALARIED_EMPLOYEE WHERE EMPLOYEE_ID = " + id;

        List<SalariedEmployee> salariedEmployee = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SalariedEmployee.class)
        );

        return salariedEmployee.get(0);
    }

    @PutMapping("/api/salariedEmployee/{id}")
    public boolean updatesalariedEmployee(
            @PathVariable int id,
            @RequestBody SalariedEmployee salariedEmployee
    ) {
        String sql =
                "UPDATE SALARIED_EMPLOYEE SET SERVICE_CENTER_ID = ?, SALARY = ? WHERE EMPLOYEE_ID = ?";

        jdbcTemplate.update(
                sql,
                salariedEmployee.getSERVICE_CENTER_ID(),
                salariedEmployee.getSALARY(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/salariedEmployee/{id}")
    public boolean deletesalariedEmployee(@PathVariable int id) {
        String sql = "DELETE FROM SALARIED_EMPLOYEE WHERE EMPLOYEE_ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }


}
