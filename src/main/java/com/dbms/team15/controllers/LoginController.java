package com.dbms.team15.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.team15.models.Customer;
import com.dbms.team15.models.Employee;
import com.dbms.team15.models.Login;

@CrossOrigin(maxAge = 3600)
@RestController
public class LoginController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @PostMapping("/api/login")
  public Login login(@RequestBody Login login) {
    if (checkAdmin(login.getUsername(), login.getPassword())) {
        login.setRole("Admin");
        return login;
    }

    String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = '" + login.getUsername() + "' AND PASSWORD = '" + login.getPassword() + "'";

    List<Employee> employees = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(Employee.class)
    );

    if (employees.size() > 0) {
        login.setRole("Employee_" + employees.get(0).getROLE());
        return login;
    }

    sql = "SELECT * FROM CUSTOMER WHERE USERNAME = '" + login.getUsername() + "' AND PASSWORD = '" + login.getPassword() + "'";

    List<Customer> customers = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(Customer.class)
    );

    if (customers.size() > 0) {
        login.setRole("Customer");
        return login;
    }

    login.setRole("Invalid");
    return login;
  }

  private boolean checkAdmin(String username, String password) {
    if (username.equals("admin") && password.equals("admin@123")) {
        return true;
    }

    return false;
  }
}
