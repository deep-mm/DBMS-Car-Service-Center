package com.dbms.team15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class CreateTableController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/create/service_center")
  public boolean CreateServiceCenter() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SERVICE_CENTER ( ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("ADDRESS VARCHAR(250) NOT NULL, ")
    .append("TELEPHONE_NO VARCHAR(15) NOT NULL, ")
    .append("OPERATIONAL_STATUS INTEGER NOT NULL, ")
    .append("WEEKEND_WORKING INTEGER NOT NULL, ")
    .append("MIN_WAGE INTEGER NOT NULL, ")
    .append("MAX_WAGE INTEGER NOT NULL, ")
    .append("PRIMARY KEY (SERVICE_CENTER_ID), ")
    .append("CHECK (OPERATIONAL_STATUS IN (0, 1)), ")
    .append("CHECK (WEEKEND_WORKING IN (0, 1)) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/car")
  public boolean CreateCar() {
    String sql = new StringBuilder()
    .append("CREATE TABLE CAR ( ")
    .append("CAR_ID INTEGER, ")
    .append("MANUFACTURER VARCHAR(250) NOT NULL, ")
    .append("PRIMARY KEY (CAR_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/customer")
  public boolean CreateCustomer() {
    String sql = new StringBuilder()
    .append("CREATE TABLE CUSTOMER ( ")
    .append("CUSTOMER_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("FIRST_NAME VARCHAR(250) NOT NULL, ")
    .append("LAST_NAME VARCHAR(250) NOT NULL, ")
    .append("EMAIL VARCHAR(100) NOT NULL, ")
    .append("ADDRESS VARCHAR(250) NOT NULL, ")
    .append("USERNAME VARCHAR(50) NOT NULL, ")
    .append("PASSWORD VARCHAR(50) NOT NULL, ")
    .append("STATUS INTEGER NOT NULL, ")
    .append("PRIMARY KEY (CUSTOMER_ID, SERVICE_CENTER_ID), ")
    .append("CHECK (STATUS IN (0,1)), ")
    .append("FOREIGN KEY (SERVICE_CENTER_ID) REFERENCES SERVICE_CENTER(SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("CHECK (EMAIL LIKE '%@%.%') )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/employee")
  public boolean CreateEmployee() {
    String sql = new StringBuilder()
    .append("CREATE TABLE EMPLOYEE ( ")
    .append("EMPLOYEE_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("NAME VARCHAR(250) NOT NULL, ")
    .append("ADDRESS VARCHAR(250) NOT NULL, ")
    .append("START_DATE DATE NOT NULL, ")
    .append("ROLE INTEGER NOT NULL, ")
    .append("EMAIL VARCHAR(100) NOT NULL, ")
    .append("PHONE VARCHAR(14) NOT NULL, ")
    .append("USERNAME VARCHAR(50) NOT NULL, ")
    .append("PASSWORD VARCHAR(50) NOT NULL, ")
    .append("PRIMARY KEY (EMPLOYEE_ID, SERVICE_CENTER_ID), ")
    .append("CHECK (ROLE IN (1,2,3)), ")
    .append("FOREIGN KEY (SERVICE_CENTER_ID) REFERENCES SERVICE_CENTER(SERVICE_CENTER_ID)  ON DELETE CASCADE, ")
    .append("CHECK (EMAIL LIKE '%@%.%') )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/customer_car")
  public boolean CreateCustomerCar() {
    String sql = new StringBuilder()
    .append("CREATE TABLE CUSTOMER_CAR ( ")
    .append("VIN INTEGER, ")
    .append("MILEAGE REAL NOT NULL, ")
    .append("LAST_SCHEDULED_MAINTENANCE INTEGER NOT NULL, ")
    .append("CUSTOMER_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("CAR_ID INTEGER, ")
    .append("YEAR INTEGER NOT NULL, ")
    .append("CHECK (1900 <= YEAR AND YEAR <= 2022), ")
    .append("FOREIGN KEY (CUSTOMER_ID, SERVICE_CENTER_ID) REFERENCES CUSTOMER(CUSTOMER_ID, SERVICE_CENTER_ID)  ON DELETE CASCADE, ")
    .append("FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (VIN) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/salaried_employee")
  public boolean CreateSalariedEmployee() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SALARIED_EMPLOYEE ( ")
    .append("EMPLOYEE_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("SALARY REAL NOT NULL, ")
    .append("FOREIGN KEY (EMPLOYEE_ID, SERVICE_CENTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID, SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (EMPLOYEE_ID, SERVICE_CENTER_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/hourly_paid_employee")
  public boolean CreateHourlyPaidEmployee() {
    String sql = new StringBuilder()
    .append("CREATE TABLE HOURLY_PAID_EMPLOYEE ( ")
    .append("EMPLOYEE_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("HOURLY_RATE REAL NOT NULL, ")
    .append("FOREIGN KEY (EMPLOYEE_ID, SERVICE_CENTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID, SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (EMPLOYEE_ID, SERVICE_CENTER_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/leave")
  public boolean CreateLeave() {
    String sql = new StringBuilder()
    .append("CREATE TABLE LEAVE ( ")
    .append("LEAVE_ID INTEGER, ")
    .append("START_DATE DATE NOT NULL, ")
    .append("END_DATE DATE NOT NULL, ")
    .append("STATUS INTEGER NOT NULL, ")
    .append("EMPLOYEE_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("CHECK (STATUS IN (0,1,2)), ")
    .append("CHECK (START_DATE < END_DATE), ")
    .append("FOREIGN KEY (EMPLOYEE_ID, SERVICE_CENTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID, SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (LEAVE_ID, SERVICE_CENTER_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/schedule_bundle")
  public boolean CreateScheduleBundle() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SCHEDULE_BUNDLE ( ")
    .append("SCHEDULE_BUNDLE_ID INTEGER, ")
    .append("NAME VARCHAR(100) NOT NULL, ")
    .append("PRIMARY KEY (SCHEDULE_BUNDLE_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/service_category")
  public boolean CreateServiceCategory() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SERVICE_CATEGORY ( ")
    .append("CATEGORY_ID INTEGER, ")
    .append("CATEGORY_NAME VARCHAR(100) NOT NULL, ")
    .append("PRIMARY KEY (CATEGORY_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/service")
  public boolean CreateService() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SERVICE ( ")
    .append("ID INTEGER, ")
    .append("SERVICE_NAME VARCHAR(100) NOT NULL, ")
    .append("PRIMARY KEY (ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/services_car")
  public boolean CreateServicesCar() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SERVICES_CAR ( ")
    .append("ID INTEGER, ")
    .append("CAR_ID INTEGER, ")
    .append("TIME_ESTIMATED REAL NOT NULL, ")
    .append("FOREIGN KEY (ID) REFERENCES SERVICE(ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (ID, CAR_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/service_center_provides_service")
  public boolean CreateServiceCenterProvidesService() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SERVICE_CENTER_PROVIDES_SERVICE ( ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("ID INTEGER, ")
    .append("CAR_ID INTEGER, ")
    .append("PRICE REAL NOT NULL, ")
    .append("FOREIGN KEY (ID) REFERENCES SERVICE(ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (SERVICE_CENTER_ID) REFERENCES SERVICE_CENTER(SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (SERVICE_CENTER_ID, ID, CAR_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/repair_service")
  public boolean CreateRepairService() {
    String sql = new StringBuilder()
    .append("CREATE TABLE REPAIR_SERVICE ( ")
    .append("ID INTEGER, ")
    .append("CATEGORY_ID INTEGER, ")
    .append("FOREIGN KEY (ID) REFERENCES SERVICE(ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (CATEGORY_ID) REFERENCES SERVICE_CATEGORY(CATEGORY_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (ID, CATEGORY_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/maintenance_service")
  public boolean CreateMaintenanceService() {
    String sql = new StringBuilder()
    .append("CREATE TABLE MAINTENANCE_SERVICE ( ")
    .append("ID INTEGER, ")
    .append("SCHEDULE_BUNDLE_ID INTEGER, ")
    .append("FOREIGN KEY (ID) REFERENCES SERVICE(ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (SCHEDULE_BUNDLE_ID) REFERENCES SCHEDULE_BUNDLE(SCHEDULE_BUNDLE_ID) ON DELETE CASCADE, ")
    .append("PRIMARY KEY (ID, SCHEDULE_BUNDLE_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/invoice")
  public boolean CreateInvoice() {
    String sql = new StringBuilder()
    .append("CREATE TABLE INVOICE ( ")
    .append("INVOICE_ID INTEGER, ")
    .append("INVOICE_STATUS INTEGER NOT NULL, ")
    .append("TOTAL_COST REAL NOT NULL, ")
    .append("CHECK (INVOICE_STATUS IN (0,1)), ")
    .append("PRIMARY KEY (INVOICE_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/service_event")
  public boolean CreateServiceEvent() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SERVICE_EVENT ( ")
    .append("SERVICE_ID INTEGER, ")
    .append("ID INTEGER, ")
    .append("MECHANIC_ID INTEGER, ")
    .append("SERVICE_CENTER_ID INTEGER, ")
    .append("VIN INTEGER, ")
    .append("INVOICE_ID INTEGER, ")
    .append("START_TIME TIMESTAMP, ")
    .append("END_TIME TIMESTAMP, ")
    .append("FOREIGN KEY (ID) REFERENCES SERVICE(ID), ")
    .append("FOREIGN KEY (MECHANIC_ID, SERVICE_CENTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID, SERVICE_CENTER_ID), ")
    .append("FOREIGN KEY (VIN) REFERENCES CUSTOMER_CAR(VIN), ")
    .append("FOREIGN KEY (INVOICE_ID) REFERENCES INVOICE(INVOICE_ID), ")
    .append("PRIMARY KEY (SERVICE_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/swap_slot")
  public boolean CreateSwapSlot() {
    String sql = new StringBuilder()
    .append("CREATE TABLE SWAP_SLOT ( ")
    .append("REQUESTOR_EMPLOYEE_ID INTEGER, ")
    .append("REQUESTOR_SERVICE_CENTER_ID INTEGER, ")
    .append("REQUESTED_EMPLOYEE_ID INTEGER, ")
    .append("REQUESTED_SERVICE_CENTER_ID INTEGER, ")
    .append("INVOICE_GIVE INTEGER, ")
    .append("INVOICE_TAKE INTEGER, ")
    .append("STATUS INTEGER NOT NULL, ")
    .append("CHECK (STATUS IN (0,1,2)), ")
    .append("FOREIGN KEY (REQUESTOR_EMPLOYEE_ID, REQUESTOR_SERVICE_CENTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID, SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (REQUESTED_EMPLOYEE_ID, REQUESTED_SERVICE_CENTER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID, SERVICE_CENTER_ID) ON DELETE CASCADE, ")
    .append("FOREIGN KEY (INVOICE_GIVE) REFERENCES INVOICE(INVOICE_ID), ")
    .append("FOREIGN KEY (INVOICE_TAKE) REFERENCES INVOICE(INVOICE_ID), ")
    .append("PRIMARY KEY (REQUESTOR_EMPLOYEE_ID, REQUESTOR_SERVICE_CENTER_ID, REQUESTED_EMPLOYEE_ID, REQUESTED_SERVICE_CENTER_ID) )")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/trigger/check_customer_status")
  public boolean CreateTriggerCheckCustomerStatus() {
    String sql = new StringBuilder()
    .append("CREATE TRIGGER CHECK_CUSTOMER_STATUS ")
    .append("AFTER INSERT ON CUSTOMER_CAR ")
    .append("FOR EACH ROW ")
    .append("BEGIN ")
    .append("UPDATE CUSTOMER C ")
    .append("SET C.status = 1 ")
    .append("WHERE C.customer_id = :new.customer_id AND C.service_center_id = :new.service_center_id; ")
    .append("END; ")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

  @GetMapping("/create/trigger/check_customer_status_after_delete")
  public boolean CreateTriggerCheckCustomerStatusAfterDelete() {
    
    String sql = new StringBuilder()
    .append("CREATE TRIGGER CHECK_CUSTOMER_STATUS_AFTER_DELETE ")
    .append("AFTER DELETE ON CUSTOMER_CAR ")
    .append("FOR EACH ROW ")
    .append("DECLARE countCars INT; ")
    .append("BEGIN ")
    .append("SELECT Count(*) into countCars FROM CUSTOMER_CAR WHERE customer_id = :old.customer_id AND service_center_id = :old.service_center_id; ")
    .append("IF countCars = 0 THEN ")
    .append("UPDATE CUSTOMER C ")
    .append("SET C.status = 0 ")
    .append("WHERE C.customer_id = :old.customer_id AND C.service_center_id = :old.service_center_id; ")
    .append("END IF; ")
    .append("END; ")
    .toString();

    jdbcTemplate.execute(
      sql
    );

    return true;
  }

}
