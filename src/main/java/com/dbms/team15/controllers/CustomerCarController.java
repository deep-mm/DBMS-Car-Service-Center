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

    @GetMapping("/api/customerCar/{service_center_id}/{customer_id}")
    public List<CustomerCar> getCustomerCars(@PathVariable("service_center_id") String service_center_id, @PathVariable("customer_id") String customer_id) {
        String sql = "SELECT * FROM CUSTOMER_CAR WHERE CUSTOMER_ID = " + customer_id + " AND SERVICE_CENTER_ID = " + service_center_id;

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
                "INSERT INTO CUSTOMER_CAR (CAR_ID, VIN, MILEAGE, LAST_SCHEDULED_MAINTENANCE, CUSTOMER_ID, SERVICE_CENTER_ID, YEAR) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                customerCar.getCAR_ID(),
                customerCar.getVIN(),
                customerCar.getMILEAGE(),
                customerCar.getLAST_SCHEDULED_MAINTENANCE(),
                customerCar.getCUSTOMER_ID(),
                customerCar.getSERVICE_CENTER_ID(),
                customerCar.getYEAR()
        );
        return true;
    }

    @GetMapping("/api/customerCar/{vin}")
    public CustomerCar getCustomerCar(@PathVariable int vin){
        String sql = "SELECT * FROM CUSTOMER_CAR WHERE VIN = " + vin;

        List<CustomerCar> customerCars = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(CustomerCar.class)
        );

        return customerCars.get(0);
    }

    @PutMapping("/api/customerCar/{vin}")
    public boolean updateCustomerCar(
            @PathVariable int vin,
            @RequestBody CustomerCar customerCar
    ){
        String sql =
                "UPDATE CUSTOMER_CAR SET MILEAGE = ?, LAST_SCHEDULED_MAINTENANCE = ?, SERVICE_CENTER_ID = ?, CAR_ID = ?, CUSTOMER_ID = ?, YEAR = ? WHERE VIN = ?";

        jdbcTemplate.update(
                sql,
                customerCar.getMILEAGE(),
                customerCar.getLAST_SCHEDULED_MAINTENANCE(),
                customerCar.getSERVICE_CENTER_ID(),
                customerCar.getCAR_ID(),
                customerCar.getCUSTOMER_ID(),
                customerCar.getYEAR(),
                vin
        );

        return true;

    }

    @DeleteMapping("/api/customerCar/{vin}")
    public boolean deleteCustomerCar(@PathVariable int vin){
        String sql = "DELETE FROM CUSTOMER_CAR WHERE VIN = " + vin;

        jdbcTemplate.update(sql);

        return true;
    }

}
