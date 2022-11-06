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

import com.dbms.team15.models.Car;
import com.dbms.team15.models.MaintenanceService;

@CrossOrigin(maxAge = 3600)
@RestController
public class MaintenanceServiceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/maintenanceService/{schedule_bundle_id}")
    public List<MaintenanceService> getMaintenanceServices(@PathVariable int schedule_bundle_id){
        String sql = "SELECT * FROM MAINTENANCE_SERVICE WHERE SCHEDULE_BUNDLE_ID <= " + schedule_bundle_id;

        List<MaintenanceService> maintenanceServices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(MaintenanceService.class)
        );

        maintenanceServices.forEach(System.out::println);
        return maintenanceServices;
    }

    @PostMapping("/api/maintenanceService")
    public boolean addMaintenanceService(@RequestBody MaintenanceService maintenanceService){
        String sql =
            "INSERT INTO MAINTENANCE_SERVICE (ID, SCHEDULE_BUNDLE_ID) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                maintenanceService.getID(),
                maintenanceService.getSCHEDULE_BUNDLE_ID()
        );

        return true;
    }

    @DeleteMapping("/api/maintenanceService/{schedule_bundle_id}/{id}")
    public boolean deleteMaintenanceService(@PathVariable int id, @PathVariable int schedule_bundle_id){
        String sql = "DELETE FROM MAINTENANCE_SERVICE WHERE ID = " + id + " AND SCHEDULE_BUNDLE_ID = " + schedule_bundle_id;

        jdbcTemplate.update(sql);

        return true;
    }
    
}
