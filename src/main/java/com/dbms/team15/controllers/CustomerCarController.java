package com.dbms.team15.controllers;

import com.dbms.team15.models.CustomerCar;
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
public class CustomerCarController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/customerCar")
    public List<CustomerCar> getCustomerCar() {
        String sql = "SELECT * FROM CUSTOMER_CAR";

        List<CustomerCar> customerCars = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(CustomerCar.class)
        );

        customerCars.forEach(System.out::println);
        return customerCars;
    }

    @PostMapping("/api/customerCar")
    public boolean addCustomerCar(@RequestBody CustomerCar customerCar){
        String sql =
                "INSERT INTO CUSTOMER_CAR (CAR_ID, VIN, MILEAGE, LAST_SCHEDULED_MAINTENANCE, CUSTOMER_ID, SERVICE_CENTER_ID) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                customerCar.getCAR_ID(),
                customerCar.getVIN(),
                customerCar.getMILEAGE(),
                customerCar.getLAST_SCHEDULED_MAINTENANCE(),
                customerCar.getCUSTOMER_ID(),
                customerCar.getSERVICE_CENTER_ID()
        );
        return true;
    }

    @GetMapping("/api/customerCar/{customer_id}/{car_id}")
    public CustomerCar getCustomerCar(@PathVariable int customer_id, @PathVariable int car_id){
        String sql = "SELECT * FROM CUSTOMER_CAR WHERE CUSTOMER_ID = " + customer_id + " AND CAR_ID = " + car_id;

        List<CustomerCar> customerCars = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(CustomerCar.class)
        );

        return customerCars.get(0);
    }

    @PutMapping("/api/customerCar/{customer_id}/{car_id}")
    public boolean updateCustomerCar(
            @PathVariable int customer_id,
            @PathVariable int car_id,
            @RequestBody CustomerCar customerCar
    ){
        String sql =
                "UPDATE CUSTOMER_CAR SET VIN = ?, MILEAGE = ?, LAST_SCHEDULED_MAINTENANCE = ?, SERVICE_CENTER_ID = ? WHERE CAR_ID = ?, CUSTOMER_ID = ?";

        jdbcTemplate.update(
                sql,
                customerCar.getVIN(),
                customerCar.getMILEAGE(),
                customerCar.getLAST_SCHEDULED_MAINTENANCE(),
                customerCar.getSERVICE_CENTER_ID(),
                car_id,
                customer_id

        );

        return true;

    }

    @DeleteMapping("/api/customerCar/{customer_id}/{car_id}")
    public boolean deleteCustomerCar(@PathVariable int customer_id,
                                     @PathVariable int car_id){
        String sql = "DELETE FROM CUSTOMER_CAR WHERE CUSTOMER_ID = " + customer_id + " AND CAR_ID = " + car_id;

        jdbcTemplate.update(sql);

        return true;
    }

}
