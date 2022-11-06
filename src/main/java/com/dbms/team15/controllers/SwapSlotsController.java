package com.dbms.team15.controllers;

import com.dbms.team15.models.Car;
import com.dbms.team15.models.ServiceCenter;
import com.dbms.team15.models.SwapSlot;

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
public class SwapSlotsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/swapSlots/{service_center_id}")
    public List<SwapSlot> getSwapSlots(@PathVariable int service_center_id) {
        String sql = "SELECT * FROM SWAP_SLOT WHERE REQUESTOR_SERVICE_CENTER_ID = " + service_center_id;

        List<SwapSlot> swapSlots = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SwapSlot.class));

        swapSlots.forEach(System.out::println);
        return swapSlots;
    }

    @PostMapping("/api/swapSlots")
    public boolean addSwapSlot(@RequestBody SwapSlot swapSlot) {
        String sql = "INSERT INTO SWAP_SLOT (REQUESTOR_EMPLOYEE_ID, REQUESTOR_SERVICE_CENTER_ID, REQUESTED_EMPLOYEE_ID, REQUESTED_SERVICE_CENTER_ID, INVOICE_GIVE, INVOICE_TAKE, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                swapSlot.getRequestor_employee_id(), swapSlot.getRequestor_service_center_id(),
                swapSlot.getRequested_employee_id(), swapSlot.getRequested_service_center_id(),
                swapSlot.getInvoice_give(), swapSlot.getInvoice_take(), swapSlot.getStatus());

        return true;
    }

    @GetMapping("/api/swapSlots/{service_center_id}/{requestor_employee_id}/{requested_employee_id}")
    public SwapSlot getSwapSlotById(@PathVariable int service_center_id, @PathVariable int requestor_employee_id,
            @PathVariable int requested_employee_id) {
        String sql = "SELECT * FROM SWAP_SLOT WHERE REQUESTOR_SERVICE_CENTER_ID = " + service_center_id
                + " AND REQUESTOR_EMPLOYEE_ID = " + requestor_employee_id + " AND REQUESTED_EMPLOYEE_ID = "
                + requested_employee_id;

        List<SwapSlot> swapSlots = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(SwapSlot.class));
        return swapSlots.get(0);

    }

    @PutMapping("/api/swapSlots/{service_center_id}/{requestor_employee_id}/{requested_employee_id}")
    public boolean updateSwapSlot(@PathVariable int service_center_id, @RequestBody SwapSlot swapSlot,
            @PathVariable int requestor_employee_id, @PathVariable int requested_employee_id) {
        String sql = "UPDATE SWAP_SLOT SET INVOICE_GIVE = ?, INVOICE_TAKE = ?, STATUS = ? WHERE REQUESTOR_SERVICE_CENTER_ID = ? AND REQUESTOR_EMPLOYEE_ID = ? AND REQUESTED_EMPLOYEE_ID = ?";

        jdbcTemplate.update(
                sql,
                swapSlot.getInvoice_give(), swapSlot.getInvoice_take(), swapSlot.getStatus(), service_center_id,
                requestor_employee_id, requested_employee_id);

        return true;
    }

    @DeleteMapping("/api/swapSlots/{service_center_id}/{requestor_employee_id}/{requested_employee_id}")
    public boolean deleteSwapSlot(@PathVariable int service_center_id, @PathVariable int requestor_employee_id,
            @PathVariable int requested_employee_id) {
        String sql = "DELETE FROM SWAP_SLOT WHERE REQUESTOR_SERVICE_CENTER_ID = " + service_center_id
                + " AND REQUESTOR_EMPLOYEE_ID = " + requestor_employee_id + " AND REQUESTED_EMPLOYEE_ID = "
                + requested_employee_id;

        jdbcTemplate.update(sql);

        return true;
    }

}
