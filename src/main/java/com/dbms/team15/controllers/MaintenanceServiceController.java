package com.dbms.team15.controllers;

import java.util.List;

import com.dbms.team15.models.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class MaintenanceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/maintenanceService")
    public List<MaintenanceService> getMaintenanceService() {
        String sql = "SELECT * FROM MAINTENANCE_SERVICE";

        List<MaintenanceService> maintenanceServices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(MaintenanceService.class)
        );

        maintenanceServices.forEach(System.out::println);
        return maintenanceServices;
    }

    @PostMapping("/api/maintenanceService")
    public boolean addMaintenanceService(@RequestBody MaintenanceService maintenanceService) {
        String sql =
                "INSERT INTO MAINTENANCE_SERVICE (ID, SCHEDULE_BUNDLE_ID) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                maintenanceService.getID(),
                maintenanceService.getSCHEDULE_BUNDLE_ID(),
        );

        return true;
    }

    @GetMapping("/api/maintenanceService/{id}")
    public MaintenanceService getMaintenanceServiceByName(@PathVariable int id) {
        String sql = "SELECT * FROM MAINTENANCE_SERVICE WHERE ID = " + id;

        List<MaintenanceService> maintenanceServices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(MaintenanceService.class)
        );

        return maintenanceServices.get(0);
    }

    @PutMapping("/api/maintenanceService/{id}")
    public boolean updateMaintenanceService(
            @PathVariable int id,
            @RequestBody MaintenanceService maintenanceService
    ) {
        String sql =
                "UPDATE MAINTENANCE_SERVICE SET ID = ? WHERE ID = ?";

        jdbcTemplate.update(
                sql,
                maintenanceService.getID(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/maintenanceService/{id}")
    public boolean deleteMaintenanceService(@PathVariable int id) {
        String sql = "DELETE FROM MAINTENANCE_SERVICE WHERE ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }

}
