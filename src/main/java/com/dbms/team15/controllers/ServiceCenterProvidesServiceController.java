package com.dbms.team15.controllers;

import com.dbms.team15.models.ServiceCenterProvidesService;
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
public class ServiceCenterProvidesServiceController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/api/serviceCenterProvidesService")
  public List<ServiceCenterProvidesService> getServiceCenterProvidesService() {
    String sql = "SELECT * FROM SERVICE_CENTER_PROVIDES_SERVICE";

    List<ServiceCenter> serviceCenters = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCenter.class)
    );

    serviceCenters.forEach(System.out::println);
    return serviceCenters;
  }

  @PostMapping("/api/serviceCenter")
  public boolean addServiceCenter(@RequestBody ServiceCenter serviceCenter) {
    String sql =
      "INSERT INTO SERVICE_CENTER (SERVICE_CENTER_ID, ADDRESS, TELEPHONE_NO, OPERATIONAL_STATUS, WEEKEND_WORKING) VALUES (?, ?, ?, ?, ?)";

    jdbcTemplate.update(
      sql,
      serviceCenter.getSERVICE_CENTER_ID(),
      serviceCenter.getADDRESS(),
      serviceCenter.getTELEPHONE_NO(),
      serviceCenter.getOPERATIONAL_STATUS(),
      serviceCenter.getWEEKEND_WORKING()
    );

    return true;
  }

  @GetMapping("/api/serviceCenter/{id}")
  public ServiceCenter getServiceCenterByName(@PathVariable int id) {
    String sql = "SELECT * FROM SERVICE_CENTER WHERE SERVICE_CENTER_ID = " + id;

    List<ServiceCenter> serviceCenters = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCenter.class)
    );

    return serviceCenters.get(0);
  }

  @PutMapping("/api/serviceCenter/{id}")
  public boolean updateServiceCenter(
    @PathVariable int id,
    @RequestBody ServiceCenter serviceCenter
  ) {
    String sql =
      "UPDATE SERVICE_CENTER SET ADDRESS = ?, TELEPHONE_NO = ?, OPERATIONAL_STATUS = ?, WEEKEND_WORKING = ? WHERE SERVICE_CENTER_ID = ?";

    jdbcTemplate.update(
      sql,
      serviceCenter.getADDRESS(),
      serviceCenter.getTELEPHONE_NO(),
      serviceCenter.getOPERATIONAL_STATUS(),
      serviceCenter.getWEEKEND_WORKING(),
      id
    );

    return true;
  }

  @DeleteMapping("/api/serviceCenter/{id}")
  public boolean deleteServiceCenter(@PathVariable int id) {
    String sql = "DELETE FROM SERVICE_CENTER WHERE SERVICE_CENTER_ID = " + id;

    jdbcTemplate.update(sql);

    return true;
  }
}