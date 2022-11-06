package com.dbms.team15.controllers;

import com.dbms.team15.models.Car;
import com.dbms.team15.models.Customer;
import com.dbms.team15.models.ScheduleBundle;
import com.dbms.team15.models.Service;
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
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/query/1")
    public ServiceCenter getQuery1() {

        String sql = "SELECT SC.service_center_id\n"
                + "FROM SERVICE_CENTER SC, CUSTOMER C\n"
                + "WHERE SC.service_center_id = C.service_center_id\n"
                + "GROUP BY SC.service_center_id\n"
                + "HAVING Count(*) >= ALL (SELECT Count(*)\n"
                + "FROM SERVICE_CENTER SC, CUSTOMER C\n"
                + "WHERE SC.service_center_id = C.service_center_id\n"
                + "GROUP BY SC.service_center_id)";

        List<ServiceCenter> serviceCenters = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(ServiceCenter.class));

        return serviceCenters.get(0);
    }

    @GetMapping("/api/query/2")
    public double getQuery2() {
        String sql = new StringBuilder()
                .append("SELECT AVG(SCPS.PRICE) ")
                .append("FROM SERVICE_CENTER_PROVIDES_SERVICE SCPS, SERVICE S, CAR C ")
                .append("WHERE SCPS.ID = S.ID AND S.SERVICE_NAME = 'Evaporator Repair' AND SCPS.CAR_ID = C.CAR_ID AND C.manufacturer = 'Honda' ")
                .toString();

        double avg = jdbcTemplate.queryForObject(
                sql, Double.class);

        return avg;
    }

    @GetMapping("/api/query/3")
    public List<Customer> getQuery3() {

        String sql = new StringBuilder()
                .append("SELECT UNIQUE C.customer_id, C.first_name ")
                .append("FROM Customer C, Invoice I, Customer_Car CC, Service_Event SE ")
                .append("WHERE CC.customer_id = C.customer_id AND CC.VIN = SE.VIN AND SE.invoice_id = I.invoice_id AND I.invoice_status = 0 AND CC.service_center_id = C.service_center_id ")
                .toString();

        List<Customer> customers = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Customer.class));

        return customers;
    }

    @GetMapping("/api/query/4")
    public List<Service> getQuery4() {

        String sql = new StringBuilder()
                .append("SELECT * ")
                .append("FROM Service S ")
                .append("WHERE S.ID IN ( ")
                .append("SELECT MS.ID FROM maintenance_service MS) ")
                .append("AND S.ID IN ( ")
                .append("SELECT RS.ID FROM repair_service RS) ")
                .toString();

        List<Service> services = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Service.class));

        return services;
    }

    @GetMapping("/api/query/5")
    public double getQuery5() {

        String sql = new StringBuilder()
                .append("SELECT TEMP1.total - TEMP2.total AS Difference ")
                .append("FROM (Select SUM(SCPS.price) AS total FROM SERVICE_CENTER_PROVIDES_SERVICE SCPS WHERE SCPS.service_center_id = 30001 AND SCPS.CAR_ID = 3 AND (SCPS.ID = 101 OR SCPS.ID = 113 OR SCPS.ID = 114)) TEMP1, ")
                .append("(Select SUM(SCPS.price) AS total FROM SERVICE_CENTER_PROVIDES_SERVICE SCPS WHERE SCPS.service_center_id = 30002 AND SCPS.CAR_ID = 3 AND (SCPS.ID = 101 OR SCPS.ID = 113 OR SCPS.ID = 114)) TEMP2 ")
                .toString();

        double diff = jdbcTemplate.queryForObject(
                sql, Double.class);

        return diff;
    }

    @GetMapping("/api/query/6")
    public ScheduleBundle getQuery6() {

        String sql = new StringBuilder()
                .append("SELECT SB.* ")
                .append("FROM schedule_bundle SB, customer_car CC ")
                .append("WHERE CC.VIN = 9 AND SB.schedule_bundle_id = ")
                .append("CASE ")
                .append("WHEN cc.last_scheduled_maintenance = 3 THEN 1 ")
                .append("ELSE cc.last_scheduled_maintenance + 1 ")
                .append("END ")
                .toString();

        List<ScheduleBundle> scheduleBundles = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(ScheduleBundle.class));

        return scheduleBundles.get(0);
    }

}
