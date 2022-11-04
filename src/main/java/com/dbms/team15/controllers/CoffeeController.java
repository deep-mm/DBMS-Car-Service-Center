package com.dbms.team15.controllers;

import com.dbms.team15.models.Coffee;
import com.dbms.team15.models.ServiceCenter;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class CoffeeController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/greeting")
  public List<Coffee> greeting(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    String sql = "SELECT * FROM COFFEES1";

    List<Coffee> coffees = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(Coffee.class)
    );

    coffees.forEach(System.out::println);
    return coffees;
  }

  @PostMapping("/greeting")
  public boolean addGreeting(@RequestBody Coffee Coffee) {
    String sql =
      "INSERT INTO COFFEES1 (cof_NAME, sup_ID, price, sales, total) VALUES (?, ?, ?, ?, ?)";

    jdbcTemplate.update(
      sql,
      Coffee.getCOF_NAME(),
      Coffee.getSUP_ID(),
      Coffee.getPRICE(),
      Coffee.getSALES(),
      Coffee.getTOTAL()
    );

    return true;
  }

  @GetMapping("/greeting/{name}")
  public Coffee getCoffeeByName(@PathVariable String name) {
    String sql = "SELECT * FROM COFFEES1 WHERE cof_NAME = " + "'" + name + "'";

    List<Coffee> coffees = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(Coffee.class)
    );

    return coffees.get(0);
  }
  
  @PutMapping("/greeting")
  public boolean updateGreeting(@RequestBody Coffee Coffee) {
    String sql =
      "UPDATE COFFEES1 set sup_ID = ?, price = ?, sales = ?, total = ? WHERE cof_NAME = ?";

    jdbcTemplate.update(
      sql,
      Coffee.getSUP_ID(),
      Coffee.getPRICE(),
      Coffee.getSALES(),
      Coffee.getTOTAL(),
      Coffee.getCOF_NAME()
    );

    return true;
  }
  
  @DeleteMapping("/greeting/{name}")
  public boolean deleteGreeting(@PathVariable String name) {
    String sql =
      "DELETE FROM COFFEES1 WHERE cof_NAME = ?";

    jdbcTemplate.update(
      sql,
      name
    );

    return true;
  }
}
