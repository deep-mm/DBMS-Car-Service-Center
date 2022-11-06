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

import com.dbms.team15.models.RepairService;

@CrossOrigin(maxAge = 3600)
@RestController
public class RepairServiceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/repairService")
    public List<RepairService> getRepairServices(){
        String sql = "SELECT * FROM REPAIR_SERVICE";

        List<RepairService> repairServices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(RepairService.class)
        );

        repairServices.forEach(System.out::println);
        return repairServices;
    }

    @PostMapping("/api/repairService")
    public boolean addRepairService(@RequestBody RepairService repairService){
        String sql =
            "INSERT INTO REPAIR_SERVICE (ID, CATEGORY_ID) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                repairService.getID(),
                repairService.getCATEGORY_ID()
        );

        return true;
    }

    @DeleteMapping("/api/repairService/{category_id}/{id}")
    public boolean deleteRepairService(@PathVariable int id, @PathVariable int category_id){
        String sql = "DELETE FROM REPAIR_SERVICE WHERE ID = " + id + " AND CATEGORY_ID = " + category_id;

        jdbcTemplate.update(sql);

        return true;
    }
    
}
