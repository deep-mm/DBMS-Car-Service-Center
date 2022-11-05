# AUTOR - Auto Repair and Service Management System

CSC540 Fall 2022 - DBMS [Team 15]
Team:
1. Deep Mehta - dmmehta2, 
2. Rohan Shiveshwarkar - rsshives
3. Yash Sonar - ysonar
4. Kunal Patil - kpatil5

This is a Java 11 Spring Boot API and Angular 14 APP Project

To cofigure this in local, ensure you have JDK 11 installed on your machine. Then update the following values in application.properties (src > main > resources) file:

1. spring.datasource.username={NCSU Unity ID}
2. spring.datasource.password={NCSU Oracle DB Password}
3. ssh.password={NCSU Unity ID Password}

Run the spring boot application and you will be able to see all the APIs listed in the form of Swagger UI. This utilizes JDBC to run SQL queries and retrive results. This is connected with NCSU Oracle DB.

These APIs are then consumed by the Angular App which is present in the folder: `service-center-app`, which can be run by ng serve. Update the api url in environment.ts and environment.prod.ts file.
