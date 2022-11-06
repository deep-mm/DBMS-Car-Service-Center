package com.dbms.team15.controllers;

import com.dbms.team15.models.ServiceCategory;
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
public class ServiceCategoryController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/api/serviceCategory")
  public List<ServiceCategory> getServiceCategory() {
    String sql = "SELECT * FROM SERVICE_CATEGORY";

    List<ServiceCategory> serviceCategories = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCategory.class)
    );

    serviceCategories.forEach(System.out::println);
    return serviceCategories;
  }

  @PostMapping("/api/serviceCategory")
  public boolean addServiceCategory(@RequestBody ServiceCategory serviceCategory) {
    String sql =
      "INSERT INTO SERVICE_CATEGORY (CATEGORY_ID, CATEGORY_NAME) VALUES (?, ?)";

    jdbcTemplate.update(
      sql,
      serviceCategory.getCATEGORY_ID(),
      serviceCategory.getCATEGORY_NAME()
    );

    return true;
  }

  @GetMapping("/api/serviceCategory/{id}")
  public ServiceCategory getServiceCategoryByName(@PathVariable int id) {
    String sql = "SELECT * FROM SERVICE_CATEGORY WHERE CATEGORY_ID = " + id;

    List<ServiceCategory> serviceCategories = jdbcTemplate.query(
      sql,
      BeanPropertyRowMapper.newInstance(ServiceCategory.class)
    );

    return serviceCategories.get(0);
  }

  @PutMapping("/api/serviceCategory/{id}")
  public boolean updateServiceCategory(
    @PathVariable int id,
    @RequestBody ServiceCategory serviceCategory
  ) {
    String sql =
      "UPDATE SERVICE_CATEGORY SET CATEGORY_NAME = ? WHERE CATEGORY_ID = ?";

    jdbcTemplate.update(
      sql,
      serviceCategory.getCATEGORY_NAME(),
      id
    );

    return true;
  }

  @DeleteMapping("/api/serviceCategory/{id}")
  public boolean deleteServiceCategory(@PathVariable int id) {
    String sql = "DELETE FROM SERVICE_CATEGORY WHERE CATEGORY_ID = " + id;

    jdbcTemplate.update(sql);

    return true;
  }
}
