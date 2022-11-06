package com.dbms.team15.controllers;

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
      BeanPropertyRowMapper.newInstance(ServiceEvent.class)
    );

    serviceEvents.forEach(System.out::println);
    return serviceEvents;
  }

  @PostMapping("/api/serviceEvent")
  public boolean addServiceEvent(@RequestBody ServiceEvent serviceEvent) {
    String sql =
      "INSERT INTO SERVICE_EVENT (SERVICE_ID, ID, MECHANIC_ID, SERVICE_CENTER_ID, VIN, INVOICE_ID, START_TIME, END_TIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    jdbcTemplate.update(
      sql,
      serviceEvent.getSERVICE_ID(),
      serviceEvent.getID(),
      serviceEvent.getMECHANIC_ID(),
      serviceEvent.getSERVICE_CENTER_ID(),
      serviceEvent.getVIN(),
      serviceEvent.getINVOICE_ID(),
      serviceEvent.getSTART_TIME(),
      serviceEvent.getEND_TIME()
    );

    return true;
  }

  @GetMapping("/api/serviceEvent/{id}/{service_id}/{service_center_id}")
  public ServiceEvent getServiceEventByName(@PathVariable int id, @PathVariable int service_id, @PathVariable int service_center_id) {
    String sql = "SELECT * FROM SERVICE_EVENT WHERE SERVICE_CENTER_ID = " + Service_center_id + " AND ID = " + id + " AND SERVICE_ID = " + service_id;

    List<ServiceEvent> serviceEvents = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceEvent.class)
    );

    return serviceEvents.get(0);
  }

  @PutMapping("/api/serviceEvent/{id}/{service_id}/{service_center_id}")
  public boolean updateServiceEvent(
    @PathVariable int id,
    @PathVariable int service_id, 
    @PathVariable int service_center_id,
    @RequestBody ServiceEvent serviceEvent
  ) {
    String sql =
      "UPDATE SERVICE_EVENT SET MECHANIC_ID, VIN, INVOICE_ID, START_TIME, END_TIME WHERE SERVICE_CENTER_ID = ? AND SERVICE_ID = ? AND ID = ?";

    jdbcTemplate.update(
      sql,
      serviceEvent.getMECHANIC_ID(),
      serviceEvent.getVIN(),
      serviceEvent.getINVOICE_ID(),
      serviceEvent.getSTART_TIME(),
      serviceEvent.getEND_TIME(),
      service_center_id,
      service_id,
      id
    );

    return true;
  }

  @DeleteMapping("/api/serviceEvent/{id}/{service_id}/{service_center_id}")
  public boolean deleteServiceEvent(@PathVariable int id, @PathVariable int service_id, @PathVariable int service_center_id) {
    String sql = "DELETE FROM SERVICE_EVENT WHERE SERVICE_CENTER_ID = " + service_center_id + " AND ID = " + id + " AND SERVICE_ID = " + service_id;

    jdbcTemplate.update(sql);

    return true;
  }
}
