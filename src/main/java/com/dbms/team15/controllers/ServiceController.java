package com.dbms.team15.controllers;

import com.dbms.team15.models.Service;
import java.util.List;

import com.dbms.team15.models.ServiceCenter;
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
public class ServiceController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/api/service")
  public List<Service> getService() {
    String sql = "SELECT * FROM SERVICE";

    List<Service> services = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(Service.class)
    );

    services.forEach(System.out::println);
    return services;
  }

  @PostMapping("/api/service")
  public boolean addService(@RequestBody Service service) {
    String sql =
      "INSERT INTO SERVICE (ID, SERVICE_NAME) VALUES (?, ?)";

    jdbcTemplate.update(
      sql,
      service.getID(),
      service.getSERVICE_NAME()
    );

    return true;
  }

  @GetMapping("/api/service/{id}")
  public Service getServiceByName(@PathVariable int id) {
    String sql = "SELECT * FROM SERVICE WHERE ID = " + id;

    List<Service> services = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(Service.class)
    );

    return services.get(0);
  }

  @PutMapping("/api/service/{id}")
  public boolean updateService(
    @PathVariable int id,
    @RequestBody Service service
  ) {
    String sql =
      "UPDATE SERVICE SET SERVICE_NAME = ? WHERE ID = ?";

    jdbcTemplate.update(
      sql,
      service.getSERVICE_NAME(),
      id
    );

    return true;
  }

  @DeleteMapping("/api/service/{id}")
  public boolean deleteService(@PathVariable int id) {
    String sql = "DELETE FROM SERVICE WHERE ID = " + id;

    jdbcTemplate.update(sql);

    return true;
  }
}
