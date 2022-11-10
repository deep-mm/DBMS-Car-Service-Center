package com.dbms.team15.controllers;

import com.dbms.team15.models.CustomerScheduledService;
import com.dbms.team15.models.ServiceEvent;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class ServiceEventController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/api/serviceEvent")
  public List<ServiceEvent> getServiceEvent() {
    String sql = "SELECT * FROM SERVICE_EVENT";

    List<ServiceEvent> serviceEvents = jdbcTemplate.query(
        sql,
        BeanPropertyRowMapper.newInstance(ServiceEvent.class));

    serviceEvents.forEach(System.out::println);
    return serviceEvents;
  }

  @GetMapping("/api/scheduledServices/{service_center_id}/{customer_id}")
  public List<CustomerScheduledService> getScheduledServices(@PathVariable("customer_id") int customer_id,
      @PathVariable("service_center_id") int service_center_id) {
    String sql = "SELECT UNIQUE S.SERVICE_NAME, CC.VIN, SE.start_time, SE.end_time FROM CUSTOMER C, SERVICE_EVENT SE, CUSTOMER_CAR CC, SERVICE S WHERE SE.vin = CC.vin AND SE.ID = S.ID AND CC.customer_id = C.customer_id AND CC.service_center_id = C.service_center_id AND C.customer_id = "
        + customer_id + " AND C.service_center_id = " + service_center_id + " ORDER BY START_TIME";

    List<CustomerScheduledService> scheduledServices = jdbcTemplate.query(
        sql,
        BeanPropertyRowMapper.newInstance(CustomerScheduledService.class));

    scheduledServices.forEach(System.out::println);
    return scheduledServices;
  }

  @PostMapping("/api/serviceEvent")
  public boolean addServiceEvent(@RequestBody ServiceEvent serviceEvent) {
    String sql = "INSERT INTO SERVICE_EVENT (SERVICE_ID, ID, MECHANIC_ID, SERVICE_CENTER_ID, VIN, INVOICE_ID, START_TIME, END_TIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    jdbcTemplate.update(
        sql,
        serviceEvent.getSERVICE_ID(),
        serviceEvent.getID(),
        serviceEvent.getMECHANIC_ID(),
        serviceEvent.getSERVICE_CENTER_ID(),
        serviceEvent.getVIN(),
        serviceEvent.getINVOICE_ID(),
        serviceEvent.getSTART_TIME(),
        serviceEvent.getEND_TIME());

    return true;
  }

  @PostMapping("/api/serviceEvent/all")
  public boolean addServiceEvents(@RequestBody List<ServiceEvent> serviceEvents) {
    String sql = "INSERT INTO SERVICE_EVENT (SERVICE_ID, ID, MECHANIC_ID, SERVICE_CENTER_ID, VIN, INVOICE_ID, START_TIME, END_TIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    for (ServiceEvent serviceEvent : serviceEvents) {
      jdbcTemplate.update(
          sql,
          serviceEvent.getSERVICE_ID(),
          serviceEvent.getID(),
          serviceEvent.getMECHANIC_ID(),
          serviceEvent.getSERVICE_CENTER_ID(),
          serviceEvent.getVIN(),
          serviceEvent.getINVOICE_ID(),
          serviceEvent.getSTART_TIME(),
          serviceEvent.getEND_TIME());
    }

    return true;
  }

  @GetMapping("/api/serviceEvent/{service_id}")
  public ServiceEvent getServiceEventByName(@PathVariable int service_id) {
    String sql = "SELECT * FROM SERVICE_EVENT WHERE SERVICE_ID = " + service_id;

    List<ServiceEvent> serviceEvents = jdbcTemplate.query(
        sql,
        BeanPropertyRowMapper.newInstance(ServiceEvent.class));

    return serviceEvents.get(0);
  }

  @GetMapping("/api/serviceEvent/getMechanic/{service_center_id}")
  public Integer getAvailableMechanic(@PathVariable int service_center_id,
      @RequestParam(value = "date", defaultValue = "") String date) {

    String sql = "SELECT UNIQUE E.EMPLOYEE_ID FROM EMPLOYEE E WHERE E.service_center_id = "
        + service_center_id
        + " AND E.role = 3 AND NOT EXISTS (SELECT * FROM SERVICE_EVENT SE1 WHERE SE1.mechanic_id = E.EMPLOYEE_ID AND SE1.service_center_id = E.service_center_id AND trunc(SE1.START_TIME) = TO_DATE('"
        + date + "', 'YYYY-MM-DD')) AND NOT EXISTS (SELECT * FROM LEAVE L WHERE TO_DATE('"
        + date
        + "', 'YYYY-MM-DD') BETWEEN trunc(L.START_DATE) AND trunc(L.END_DATE) AND L.employee_id = E.employee_id AND L.service_center_id = E.service_center_id AND L.status = 1)";

    List<Integer> mechanics = jdbcTemplate.queryForList(
        sql,
        Integer.class);

    return mechanics.get(0);
  }

  @PutMapping("/api/serviceEvent/{service_id}")
  public boolean updateServiceEvent(
      @PathVariable int service_id,
      @RequestBody ServiceEvent serviceEvent) {
    String sql = "UPDATE SERVICE_EVENT SET MECHANIC_ID = ?, VIN = ?, INVOICE_ID = ?, START_TIME = ?, END_TIME = ?, SERVICE_CENTER_ID = ?, ID = ? WHERE SERVICE_ID = ?";

    jdbcTemplate.update(
        sql,
        serviceEvent.getMECHANIC_ID(),
        serviceEvent.getVIN(),
        serviceEvent.getINVOICE_ID(),
        serviceEvent.getSTART_TIME(),
        serviceEvent.getEND_TIME(),
        serviceEvent.getSERVICE_CENTER_ID(),
        serviceEvent.getID(),
        service_id);

    return true;
  }

  @DeleteMapping("/api/serviceEvent/{service_id}")
  public boolean deleteServiceEvent(@PathVariable int service_id) {
    String sql = "DELETE FROM SERVICE_EVENT WHERE SERVICE_ID = " + service_id;

    jdbcTemplate.update(sql);

    return true;
  }
}
