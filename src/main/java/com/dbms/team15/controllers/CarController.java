package com.dbms.team15.controllers;

import com.dbms.team15.models.Car;
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
public class CarController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/car")
    public List<Car> getCar(){
        String sql = "SELECT * FROM CAR";

        List<Car> cars = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Car.class)
        );

        cars.forEach(System.out::println);
        return cars;
    }

    @PostMapping("/api/car")
    public boolean addCar(@RequestBody Car car){
        String sql =
            "INSERT INTO CAR (CAR_ID, MANUFACTURER, YEAR) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                car.getCAR_ID(),
                car.getMANUFACTURER(),
                car.getYEAR()
        );

        return true;
    }

    @GetMapping("/api/car/{id}")
    public Car getCarByName(@PathVariable int id){
        String sql = "SELECT * FROM CAR WHERE CAR_ID = " + id;

        List<Car> cars = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Car.class)
        );
        return cars.get(0);

    }

    @PutMapping("/api/car/{id}")
    public boolean updateCar(@PathVariable int id, @RequestBody Car car){
        String sql = "UPDATE CAR SET MANUFACTURER = ?, YEAR = ? WHERE CAR_ID = ?";

        jdbcTemplate.update(
                sql,
                car.getMANUFACTURER(),
                car.getYEAR(),
                car.getCAR_ID()
        );

        return true;
    }

    @DeleteMapping("/api/car/{id}")
    public boolean deleteCar(@PathVariable int id){
        String sql = "DELETE FROM CAR WHERE CAR_ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }

}
