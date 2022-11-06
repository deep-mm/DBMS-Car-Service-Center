package com.dbms.team15.controllers;
import com.dbms.team15.models.HourlyPaidEmployee;
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

public class HourlyPaidEmployeeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/hourlyPaidEmployee")
    public List<HourlyPaidEmployee> getHourlyPaidEmployee() {
        String sql = "SELECT * FROM HOURLY_PAID_EMPLOYEE";

        List<HourlyPaidEmployee> hourlyPaidEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(HourlyPaidEmployee.class)
        );

        hourlyPaidEmployees.forEach(System.out::println);
        return hourlyPaidEmployees;
    }

    @PostMapping("/api/hourlyPaidEmployee")
    public boolean addHourlyPaidEmployee(@RequestBody HourlyPaidEmployee hourlyPaidEmployee) {
        String sql =
                "INSERT INTO HOURLY_PAID_EMPLOYEE (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                hourlyPaidEmployee.getEMPLOYEE_ID(),
                hourlyPaidEmployee.getSERVICE_CENTER_ID(),
                hourlyPaidEmployee.getHOURLY_RATE()
        );

        return true;
    }

    @GetMapping("/api/hourlyPaidEmployee/{id}")
    public HourlyPaidEmployee getHourlyPaidEmployeeByName(@PathVariable int id) {
        String sql = "SELECT * FROM HOURLY_PAID_EMPLOYEE WHERE EMPLOYEE_ID = " + id;

        List<HourlyPaidEmployee> hourlyPaidEmployees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(HourlyPaidEmployee.class)
        );

        return hourlyPaidEmployees.get(0);
    }

    @PutMapping("/api/hourlyPaidEmployee/{id}")
    public boolean updateHourlyPaidEmployee(
            @PathVariable int id,
            @RequestBody HourlyPaidEmployee hourlyPaidEmployee
    ) {
        String sql =
                "UPDATE HOURLY_PAID_EMPLOYEE SET SERVICE_CENTER_ID = ?, HOURLY_RATE = ? WHERE EMPLOYEE_ID = ?";

        jdbcTemplate.update(
                sql,
                hourlyPaidEmployee.getSERVICE_CENTER_ID(),
                hourlyPaidEmployee.getHOURLY_RATE(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/hourlyPaidEmployee/{id}")
    public boolean deleteHourlyPaidEmployee(@PathVariable int id) {
        String sql = "DELETE FROM HOURLY_PAID_EMPLOYEE WHERE EMPLOYEE_ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }


}
