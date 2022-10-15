package com.dbms.team15.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.team15.models.Coffee;
import com.dbms.team15.models.ServiceCenter;

@RestController
public class ServiceCenterController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/greeting")
	public List<Coffee> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		String sql = "SELECT * FROM COFFEES1";
         
        List<Coffee> coffees = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Coffee.class));
         
		coffees.forEach(System.out :: println);
		return coffees;
	}
}