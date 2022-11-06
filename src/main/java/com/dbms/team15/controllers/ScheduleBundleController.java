package com.dbms.team15.controllers;

import com.dbms.team15.models.Car;
import com.dbms.team15.models.ScheduleBundle;
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
public class ScheduleBundleController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/scheduleBundle")
    public List<ScheduleBundle> getScheduleBundles(){
        String sql = "SELECT * FROM SCHEDULE_BUNDLE";

        List<ScheduleBundle> scheduleBundles = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(ScheduleBundle.class)
        );

        scheduleBundles.forEach(System.out::println);
        return scheduleBundles;
    }

    @PostMapping("/api/scheduleBundle")
    public boolean addScheduleBundle(@RequestBody ScheduleBundle scheduleBundle){
        String sql =
            "INSERT INTO SCHEDULE_BUNDLE (SCHEDULE_BUNDLE_ID, NAME) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                scheduleBundle.getSCHEDULE_BUNDLE_ID(),
                scheduleBundle.getNAME()
        );

        return true;
    }

    @GetMapping("/api/scheduleBundle/{id}")
    public ScheduleBundle getScheduleBundleById(@PathVariable int id){
        String sql = "SELECT * FROM SCHEDULE_BUNDLE WHERE SCHEDULE_BUNDLE_ID = " + id;

        List<ScheduleBundle> scheduleBundles = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(ScheduleBundle.class)
        );
        return scheduleBundles.get(0);

    }

    @PutMapping("/api/scheduleBundle/{id}")
    public boolean updateScheduleBundle(@PathVariable int id, @RequestBody ScheduleBundle scheduleBundle){
        String sql = "UPDATE SCHEDULE_BUNDLE SET NAME = ? WHERE SCHEDULE_BUNDLE_ID = ?";

        jdbcTemplate.update(
                sql,
                scheduleBundle.getNAME(),
                id
        );

        return true;
    }

    @DeleteMapping("/api/scheduleBundle/{id}")
    public boolean deleteScheduleBundle(@PathVariable int id){
        String sql = "DELETE FROM SCHEDULE_BUNDLE WHERE SCHEDULE_BUNDLE_ID = " + id;

        jdbcTemplate.update(sql);

        return true;
    }

}
