package com.dbms.team15.controllers;

import com.dbms.team15.models.SalariedEmployee;
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

    @GetMapping("/api/salariedEmployee/{service_center_id}")
    public List<SalariedEmployee> getSalariedEmployees(@PathVariable int service_center_id){
        String sql = "SELECT * FROM SALARIED_EMPLOYEE WHERE SERVICE_CENTER_ID = " + service_center_id;

        List<SalariedEmployee> salariedEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SalariedEmployee.class)
        );

        salariedEmployees.forEach(System.out::println);
        return salariedEmployees;
    }

    @PostMapping("/api/salariedEmployee")
    public boolean addSalariedEmployee(@RequestBody SalariedEmployee salariedEmployee){
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

    @GetMapping("/api/salariedEmployee/{service_center_id}/{id}")
    public SalariedEmployee getSalariedEmployeeById(@PathVariable int id, @PathVariable int service_center_id){
        String sql = "SELECT * FROM SALARIED_EMPLOYEE WHERE EMPLOYEE_ID = " + id + " AND SERVICE_CENTER_ID = " + service_center_id;

        List<SalariedEmployee> salariedEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SalariedEmployee.class)
        );
        return salariedEmployees.get(0);

    }

    @PutMapping("/api/salariedEmployee/{service_center_id}/{id}")
    public boolean updateSalariedEmployee(@PathVariable int id, @PathVariable int service_center_id, @RequestBody SalariedEmployee salariedEmployee){
        String sql = "UPDATE SALARIED_EMPLOYEE SET SALARY = ? WHERE EMPLOYEE_ID = ? AND SERVICE_CENTER_ID = ?";

        jdbcTemplate.update(
                sql,
                salariedEmployee.getSALARY(),
                id,
                service_center_id
        );

        return true;
    }

    @DeleteMapping("/api/salariedEmployee/{service_center_id}/{id}")
    public boolean deleteSalariedEmployee(@PathVariable int id, @PathVariable int service_center_id){
        String sql = "DELETE FROM SALARIED_EMPLOYEE WHERE EMPLOYEE_ID = " + id + " AND SERVICE_CENTER_ID = " + service_center_id;

        jdbcTemplate.update(sql);

        return true;
    }

}
