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

  @GetMapping("/api/serviceCenterProvidesService/{service_center_id}/{car_id}")
  public List<ServiceCenterProvidesService> getServiceCenterProvidesService(@PathVariable int service_center_id, @PathVariable int car_id) {
    String sql = "SELECT * FROM SERVICE_CENTER_PROVIDES_SERVICE WHERE SERVICE_CENTER_ID = " + service_center_id + " AND CAR_ID = " + car_id;

    List<ServiceCenterProvidesService> serviceCenterProvidesServices = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCenterProvidesService.class)
    );

    serviceCenterProvidesServices.forEach(System.out::println);
    return serviceCenterProvidesServices;
  }

  @GetMapping("/api/serviceCenterProvidesService/{service_center_id}")
  public List<ServiceCenterProvidesService> getServiceCenterProvidesServiceByServiceCenterId(@PathVariable int service_center_id) {
    String sql = "SELECT * FROM SERVICE_CENTER_PROVIDES_SERVICE WHERE SERVICE_CENTER_ID = " + service_center_id;

    List<ServiceCenterProvidesService> serviceCenterProvidesServices = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCenterProvidesService.class)
    );

    serviceCenterProvidesServices.forEach(System.out::println);
    return serviceCenterProvidesServices;
  }

  @PostMapping("/api/serviceCenterProvidesService")
  public boolean addServiceCenterProvidesService(@RequestBody ServiceCenterProvidesService serviceCenterProvidesService) {
    String sql =
      "INSERT INTO SERVICE_CENTER_PROVIDES_SERVICE (SERVICE_CENTER_ID, ID, CAR_ID, PRICE) VALUES (?, ?, ?, ?)";

    jdbcTemplate.update(
      sql,
      serviceCenterProvidesService.getSERVICE_CENTER_ID(),
      serviceCenterProvidesService.getID(),
      serviceCenterProvidesService.getCAR_ID(),
      serviceCenterProvidesService.getPRICE()
    );

    return true;
  }

  @GetMapping("/api/serviceCenterProvidesService/{service_center_id}/{car_id}/{id}")
  public ServiceCenterProvidesService getServiceCenterProvidesServiceByName(@PathVariable int id, @PathVariable int service_center_id, @PathVariable int car_id) {
    String sql = "SELECT * FROM SERVICE_CENTER_PROVIDES_SERVICE WHERE SERVICE_CENTER_ID = " + service_center_id + " AND ID = " + id + " AND CAR_ID = " + car_id;

    List<ServiceCenterProvidesService> serviceCenterProvidesServices = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCenterProvidesService.class)
    );

    return serviceCenterProvidesServices.get(0);
  }

  @PutMapping("/api/serviceCenterProvidesService/{service_center_id}/{car_id}/{id}")
  public boolean updateServiceCenterProvidesService(
    @PathVariable int id,
    @PathVariable int service_center_id, 
    @PathVariable int car_id,
    @RequestBody ServiceCenterProvidesService serviceCenterProvidesService
  ) {
    String sql =
      "UPDATE SERVICE_CENTER_PROVIDES_SERVICE SET PRICE = ? WHERE ID = ? AND SERVICE_CENTER_ID = ? AND CAR_ID = ?";

    jdbcTemplate.update(
      sql,
      serviceCenterProvidesService.getPRICE(),
      id,
      service_center_id,
      car_id
    );

    return true;
  }

  @DeleteMapping("/api/serviceCenterProvidesService/{service_center_id}/{car_id}/{id}")
  public boolean deleteServiceCenterProvidesService(@PathVariable int id, @PathVariable int service_center_id, @PathVariable int car_id) {
    String sql = "DELETE FROM SERVICE_CENTER_PROVIDES_SERVICE WHERE SERVICE_CENTER_ID = " + service_center_id + " AND ID = " + id + " AND CAR_ID = " + car_id;

    jdbcTemplate.update(sql);

    return true;
  }
}
