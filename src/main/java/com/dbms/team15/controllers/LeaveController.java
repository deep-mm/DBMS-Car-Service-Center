package com.dbms.team15.controllers;

import com.dbms.team15.models.Leave;
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
public class LeaveController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/leave")
    public List<Leave> getLeave(){
        String sql = "SELECT * FROM LEAVE";

        List<Leave> leaves = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Leave.class)
        );

        leaves.forEach(System.out::println);
        return leaves;
    }

    @PostMapping("/api/leave")
    public boolean addLeave(@RequestBody Leave leave){
        String sql = "INSERT INTO LEAVE (LEAVE_ID, START_DATE, END_DATE, STATUS, EMPLOYEE_ID, SERVICE_CENTER_ID) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                leave.getLEAVE_ID(),
                leave.getSTART_DATE(),
                leave.getEND_DATE(),
                leave.getSTATUS(),
                leave.getEMPLOYEE_ID(),
                leave.getSERVICE_CENTER_ID()
        );

        return true;
    }

    @GetMapping("/api/leave/{leave_id}")
    public Leave getLeaveByName(@PathVariable int leave_id){
        String sql = "SELECT * FROM LEAVE WHERE LEAVE_ID = " + leave_id;

        List<Leave> leaves = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Leave.class)
        );

        return leaves.get(0);
    }

    @PutMapping("/api/leave/{leave_id}")
    public boolean updateLeave(
            @PathVariable int leave_id,
            @RequestBody Leave leave
    ){
        String sql =
                "UPDATE LEAVE SET START_DATE = ?, END_DATE = ?, STATUS = ?, EMPLOYEE_ID = ?, SERVICE_CENTER_ID = ? WHERE LEAVE_ID = ?";
        jdbcTemplate.update(
                sql,
                leave.getSTART_DATE(),
                leave.getEND_DATE(),
                leave.getSTATUS(),
                leave.getEMPLOYEE_ID(),
                leave.getSERVICE_CENTER_ID(),
                leave_id
        );

        return true;
    }

    @DeleteMapping("/api/leave/{leave_id}")
    public boolean deleteLeave(@PathVariable int leave_id){
        String sql = "DELETE FROM LEAVE WHERE LEAVE_ID = "  + leave_id;

        jdbcTemplate.update(sql);

        return true;
    }

}
