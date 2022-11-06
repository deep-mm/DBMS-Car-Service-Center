package com.dbms.team15.controllers;

import com.dbms.team15.models.Customer;
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
public class CustomerController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/customer/{service_center_id}")
    public List<Customer> getCustomers(@PathVariable int service_center_id) {
        String sql = "SELECT * FROM CUSTOMER WHERE SERVICE_CENTER_ID = " + service_center_id;

        List<Customer> customers = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Customer.class));

        customers.forEach(System.out::println);
        return customers;
    }

    @GetMapping("/api/customer/unpaidInvoices/{service_center_id}")
    public List<Customer> getCustomersWithUnpaidInvoices(@PathVariable int service_center_id) {
        String sql = "SELECT UNIQUE C.* FROM CUSTOMER C, INVOICE I, SERVICE_EVENT SE, CUSTOMER_CAR CC WHERE I.invoice_id = SE.invoice_id AND SE.vin = CC.vin AND CC.customer_id = C.customer_id AND I.invoice_status = 0 AND CC.service_center_id = C.service_center_id AND C.service_center_id = " + service_center_id;

        List<Customer> customers = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Customer.class));

        customers.forEach(System.out::println);
        return customers;
    }

    @PostMapping("/api/customer")
    public boolean addCustomer(@RequestBody Customer customer) {
        String sql = "INSERT INTO CUSTOMER (CUSTOMER_ID, SERVICE_CENTER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, USERNAME, PASSWORD, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customer.getCUSTOMER_ID(),
                customer.getSERVICE_CENTER_ID(),
                customer.getFIRST_NAME(),
                customer.getLAST_NAME(),
                customer.getEMAIL(),
                customer.getADDRESS(),
                customer.getUSERNAME(),
                customer.getPASSWORD(),
                customer.getSTATUS());
        return true;
    }

    @GetMapping("/api/customer/{service_center_id}/{id}")
    public Customer getCustomer(@PathVariable int id, @PathVariable int service_center_id) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = " + id + " AND SERVICE_CENTER_ID = " + service_center_id;

        List<Customer> customers = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Customer.class));
        return customers.get(0);
    }

    @PutMapping("/api/customer/{service_center_id}/{id}")
    public boolean updateCustomer(@PathVariable int id, @PathVariable int service_center_id, @RequestBody Customer customer) {
        String sql = "UPDATE CUSTOMER SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, ADDRESS = ?, USERNAME = ?, PASSWORD = ?, STATUS = ? WHERE CUSTOMER_ID = ? AND SERVICE_CENTER_ID = ?";
        jdbcTemplate.update(
                sql,
                customer.getFIRST_NAME(),
                customer.getLAST_NAME(),
                customer.getEMAIL(),
                customer.getADDRESS(),
                customer.getUSERNAME(),
                customer.getPASSWORD(),
                customer.getSTATUS(),
                id,
                service_center_id);

        return true;
    }

    @DeleteMapping("/api/customer/{service_center_id}/{id}")
    public boolean deleteCustomer(@PathVariable int id, @PathVariable int service_center_id) {
        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = " + id + " AND SERVICE_CENTER_ID = " + service_center_id;
        jdbcTemplate.update(sql);
        return true;
    }

}
