package com.dbms.team15.controllers;

import com.dbms.team15.models.ServicesCar;
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
public class ServicesCarController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/servicesCar/{car_id}")
    public List<ServicesCar> getServicesCar(@PathVariable int car_id) {
        String sql = "SELECT * FROM SERVICES_CAR WHERE CAR_ID = " + car_id;

        List<ServicesCar> servicesCar = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(ServicesCar.class)
        );

        servicesCar.forEach(System.out::println);
        return servicesCar;
    }

    @PostMapping("/api/servicesCar")
    public boolean addServicesCar(@RequestBody ServicesCar servicesCar){
        String sql =
            "INSERT INTO SERVICES_CAR (ID, CAR_ID, TIME_ESTIMATED) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                servicesCar.getID(),
                servicesCar.getCAR_ID(),
                servicesCar.getTIME_ESTIMATED()
        );

        return true;
    }

    @GetMapping("/api/servicesCar/{car_id}/{id}")
    public ServicesCar getServicesCarByName(@PathVariable int id, @PathVariable int car_id){
        String sql = "SELECT * FROM SERVICES_CAR WHERE ID = " + id + " AND CAR_ID = " + car_id;

        List<ServicesCar> servicesCars = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(ServicesCar.class)
        );
        return servicesCars.get(0);

    }

    @PutMapping("/api/servicesCar/{car_id}/{id}")
    public boolean updateServicesCar(@PathVariable int id, @PathVariable int car_id, @RequestBody ServicesCar servicesCar){
        String sql = "UPDATE SERVICES_CAR SET TIME_ESTIMATED = ? WHERE ID = ? AND CAR_ID = ?";

        jdbcTemplate.update(
                sql,
                servicesCar.getTIME_ESTIMATED(),
                id,
                car_id
        );

        return true;
    }

    @DeleteMapping("/api/servicesCar/{car_id}/{id}")
    public boolean deleteCar(@PathVariable int id, @PathVariable int car_id){
        String sql = "DELETE FROM SERVICES_CAR WHERE ID = " + id + " AND CAR_ID = " + car_id;

        jdbcTemplate.update(sql);

        return true;
    }

}
