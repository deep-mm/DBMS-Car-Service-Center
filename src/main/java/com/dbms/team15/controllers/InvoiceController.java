package com.dbms.team15.controllers;

import com.dbms.team15.models.Invoice;
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
public class InvoiceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/invoice")
    public List<Invoice> getInvoice(){
        String sql = "SELECT * FROM INVOICE";

        List<Invoice> invoices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Invoice.class)
        );
        invoices.forEach(System.out::println);
        return invoices;
    }

    @PostMapping("/api/invoice")
    public boolean addInvoice(@RequestBody Invoice invoice){
        String sql =
                "INSERT INTO INVOICE (INVOICE_ID, INVOICE_STATUS, TOTAL_COST) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                invoice.getINVOICE_ID(),
                invoice.getINVOICE_STATUS(),
                invoice.getTOTAL_COST()
        );

        return true;
    }

    @GetMapping("/api/invoice/{id}")
    public Invoice getInvoice(@PathVariable int id){
        String sql = "SELECT * FROM INVOICE WHERE INVOICE_ID = " + id;

        List<Invoice> invoices = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Invoice.class)
        );

        return invoices.get(0);
    }

    @PutMapping("/api/invoice/{id}")
    public boolean updateInvoice(
            @PathVariable int id,
            @RequestBody Invoice invoice
    ){
        String sql =
                "UPDATE INVOICE SET INVOICE_STATUS = ?, TOTAL_COST = ? WHERE INVOICE_ID = ?";

        jdbcTemplate.update(
                sql,
                invoice.getINVOICE_STATUS(),
                invoice.getTOTAL_COST(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/invoice/{id}")
    public boolean deleteInvoice(@PathVariable int id){
        String sql = "DELETE FROM INVOICE WHERE INVOICE_ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }
}
