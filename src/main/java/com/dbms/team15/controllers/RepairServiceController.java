package com.dbms.team15.controllers;

import com.dbms.team15.models.RepairService;
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
public class RepairServiceController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/repairService")
    public List<RepairService> getRepairService() {
        String sql = "SELECT * FROM REPAIR_SERVICE";

        List<RepairService> repairServices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(RepairService.class)
        );

        repairServices.forEach(System.out::println);
        return repairServices;
    }

    @PostMapping("/api/repairService")
    public boolean addRepairService(@RequestBody RepairService repairService) {
        String sql =
                "INSERT INTO REPAIR_SERVICE (ID, CATEGORY_ID) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                repairService.getID(),
                repairService.getCATEGORY_ID()
        );

        return true;
    }

    @GetMapping("/api/repairService/{id}")
    public RepairService getRepairServiceByName(@PathVariable int id) {
        String sql = "SELECT * FROM REPAIR_SERVICE WHERE ID = " + id;

        List<RepairService> repairServices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(RepairService.class)
        );

        return repairServices.get(0);
    }

    @PutMapping("/api/repairService/{id}")
    public boolean updateRepairService(
            @PathVariable int id,
            @RequestBody RepairService repairService
    ) {
        String sql =
                "UPDATE REPAIR_SERVICE SET CATEGORY_ID = ? WHERE ID = ?";

        jdbcTemplate.update(
                sql,
                repairService.getCATEGORY_ID(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/repairService/{id}")
    public boolean deleteRepairService(@PathVariable int id) {
        String sql = "DELETE FROM REPAIR_SERVICE WHERE ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }


}
