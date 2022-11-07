package com.dbms.team15.controllers;

import com.dbms.team15.models.Employee;
import com.dbms.team15.models.MechanicSchedule;
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
public class EmployeeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/api/employee/{service_center_id}")
	public List<Employee> getEmployee(@PathVariable int service_center_id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE SERVICE_CENTER_ID = " + service_center_id;

		List<Employee> employees = jdbcTemplate.query(
				sql,
				BeanPropertyRowMapper.newInstance(Employee.class));

		employees.forEach(System.out::println);
		return employees;
	}

	@GetMapping("/api/employee/mechanic/{service_center_id}/{employee_id}")
	public List<MechanicSchedule> getMechanicSchedule(@PathVariable int service_center_id, @PathVariable int employee_id) {
		String sql = "SELECT S.SERVICE_NAME, C.MANUFACTURER, SE.VIN, SE.START_TIME, SE.END_TIME FROM SERVICE S, CAR C, SERVICE_EVENT SE, CUSTOMER_CAR CC WHERE SE.ID = S.ID AND SE.VIN = CC.VIN AND CC.CAR_ID = C.CAR_ID AND SE.MECHANIC_ID = " + employee_id + " AND SE.SERVICE_CENTER_ID = " + service_center_id;

		List<MechanicSchedule> schedules = jdbcTemplate.query(
				sql,
				BeanPropertyRowMapper.newInstance(MechanicSchedule.class));

		schedules.forEach(System.out::println);
		return schedules;
	}

	@GetMapping("/api/employee/mechanic/{service_center_id}")
	public List<MechanicSchedule> getMechanicsSchedules(@PathVariable int service_center_id) {
		String sql = "SELECT C.MANUFACTURER, SE.VIN, MIN(SE.START_TIME), MAX(SE.END_TIME), I.INVOICE_ID, SE.MECHANIC_ID FROM SERVICE S, CAR C, SERVICE_EVENT SE, CUSTOMER_CAR CC, INVOICE I WHERE SE.ID = S.ID AND SE.VIN = CC.VIN AND CC.CAR_ID = C.CAR_ID AND SE.INVOICE_ID = I.INVOICE_ID AND SE.SERVICE_CENTER_ID = " + service_center_id + " GROUP BY C.MANUFACTURER, SE.VIN, I.INVOICE_ID, SE.MECHANIC_ID";

		List<MechanicSchedule> schedules = jdbcTemplate.query(
				sql,
				BeanPropertyRowMapper.newInstance(MechanicSchedule.class));

		schedules.forEach(System.out::println);
		return schedules;
	}

	@PostMapping("/api/employee")
	public boolean addEmployee(@RequestBody Employee employee) {
		String sql = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, SERVICE_CENTER_ID, NAME, ADDRESS, START_DATE, ROLE, EMAIL, PHONE, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(
				sql,
				employee.getEMPLOYEE_ID(),
				employee.getSERVICE_CENTER_ID(),
				employee.getNAME(),
				employee.getADDRESS(),
				employee.getSTART_DATE(),
				employee.getROLE(),
				employee.getEMAIL(),
				employee.getPHONE(),
				employee.getUSERNAME(),
				employee.getPASSWORD());

		return true;
	}

	@GetMapping("/api/employee/{service_center_id}/{id}")
	public Employee getEmployeeByName(@PathVariable int service_center_id, @PathVariable int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = " + id + " AND SERVICE_CENTER_ID = "
				+ service_center_id;

		List<Employee> employees = jdbcTemplate.query(
				sql,
				BeanPropertyRowMapper.newInstance(Employee.class));

		return employees.get(0);
	}

	@GetMapping("/api/employee/manager/{username}")
	public Employee getEmployeeByUsername(@PathVariable String username) {
		String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = '" + username + "'";

		List<Employee> employees = jdbcTemplate.query(
				sql,
				BeanPropertyRowMapper.newInstance(Employee.class));

		return employees.get(0);
	}

	@PutMapping("/api/employee/{service_center_id}/{id}")
	public boolean updateEmployee(
			@PathVariable int id,
			@PathVariable int service_center_id,
			@RequestBody Employee employee) {
		String sql = "UPDATE EMPLOYEE SET NAME = ?, ADDRESS = ?, START_DATE = ?, ROLE = ?, EMAIL = ?, PHONE = ?, USERNAME = ?, PASSWORD = ? WHERE EMPLOYEE_ID = ? AND SERVICE_CENTER_ID = ?";

		jdbcTemplate.update(
				sql,
				employee.getNAME(),
				employee.getADDRESS(),
				employee.getSTART_DATE(),
				employee.getROLE(),
				employee.getEMAIL(),
				employee.getPHONE(),
				employee.getUSERNAME(),
				employee.getPASSWORD(),
				id,
				service_center_id);

		return true;
	}

	@DeleteMapping("/api/employee/{service_center_id}/{id}")
	public boolean deleteEmployee(@PathVariable int id, @PathVariable int service_center_id) {
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + id + " AND SERVICE_CENTER_ID = "
				+ service_center_id;
		jdbcTemplate.update(sql);
		return true;
	}
}
