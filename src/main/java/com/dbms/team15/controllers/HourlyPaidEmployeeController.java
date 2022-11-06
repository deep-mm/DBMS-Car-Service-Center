package com.dbms.team15.controllers;

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

import com.dbms.team15.models.HourlyPaidEmployee;

@CrossOrigin(maxAge = 3600)
@RestController
public class HourlyPaidEmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/hourlyPaidEmployee/{service_center_id}")
    public List<HourlyPaidEmployee> getHourlyPaidEmployee(@PathVariable int service_center_id) {
        String sql = "SELECT * FROM HOURLY_PAID_EMPLOYEE WHERE SERVICE_CENTER_ID = " + service_center_id;

        List<HourlyPaidEmployee> hourlyPaidEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(HourlyPaidEmployee.class));

        hourlyPaidEmployees.forEach(System.out::println);
        return hourlyPaidEmployees;
    }

    @PostMapping("/api/hourlyPaidEmployee")
    public boolean addEmployee(@RequestBody HourlyPaidEmployee hourlyPaidEmployee) {
        String sql = "INSERT INTO HOURLY_PAID_EMPLOYEE (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                hourlyPaidEmployee.getEMPLOYEE_ID(),
                hourlyPaidEmployee.getSERVICE_CENTER_ID(),
                hourlyPaidEmployee.getHOURLY_RATE());

        return true;
    }

    @GetMapping("/api/hourlyPaidEmployee/{service_center_id}/{employeeId}")
    public HourlyPaidEmployee getHourlyPaidEmployee(@PathVariable int employeeId, @PathVariable int service_center_id) {
        String sql = "SELECT * FROM HOURLY_PAID_EMPLOYEE WHERE EMPLOYEE_ID = " + employeeId
                + " AND SERVICE_CENTER_ID = " + service_center_id;

        List<HourlyPaidEmployee> hourlyPaidEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(HourlyPaidEmployee.class));

        hourlyPaidEmployees.forEach(System.out::println);
        return hourlyPaidEmployees.get(0);
    }

    @PutMapping("/api/hourlyPaidEmployee/{service_center_id}/{employeeId}")
    public boolean updateHourlyPaidEmployee(
            @PathVariable int employeeId, @PathVariable int service_center_id,
            @RequestBody HourlyPaidEmployee hourlyPaidEmployee) {
        String sql = "UPDATE HOURLY_PAID_EMPLOYEE SET HOURLY_RATE = ? WHERE EMPLOYEE_ID = ? AND SERVICE_CENTER_ID = ?";

        jdbcTemplate.update(
                sql,
                hourlyPaidEmployee.getHOURLY_RATE(),
                employeeId,
                service_center_id);

        return true;

    }

    @DeleteMapping("/api/hourlyPaidEmployee/{service_center_id}/{employeeId}")
    public boolean deleteHourlyPaidEmployee(@PathVariable int employeeId, @PathVariable int service_center_id) {
        String sql = "DELETE FROM HOURLY_PAID_EMPLOYEE WHERE EMPLOYEE_ID = " + employeeId + " AND SERVICE_CENTER_ID = " + service_center_id;

        jdbcTemplate.update(sql);

        return true;
    }

}
