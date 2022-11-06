INSERT INTO "SERVICE_CENTER" (
        SERVICE_CENTER_ID,
        ADDRESS,
        TELEPHONE_NO,
        OPERATIONAL_STATUS,
        WEEKEND_WORKING,
        MIN_WAGE,
        MAX_WAGE
    )
VALUES (
        '30001',
        '3921 Western Blvd, Raleigh, NC 27606',
        '3392601234',
        '0',
        '1',
        '30',
        '40'
    );
INSERT INTO "SERVICE_CENTER" (
        SERVICE_CENTER_ID,
        ADDRESS,
        TELEPHONE_NO,
        OPERATIONAL_STATUS,
        WEEKEND_WORKING,
        MIN_WAGE,
        MAX_WAGE
    )
VALUES (
        '30002',
        '4500 Preslyn Dr Suite 103, Raleigh, NC 27616',
        '8576890280',
        '0',
        '1',
        '25',
        '35'
    );
INSERT INTO "SERVICE_CENTER" (
        SERVICE_CENTER_ID,
        ADDRESS,
        TELEPHONE_NO,
        OPERATIONAL_STATUS,
        WEEKEND_WORKING,
        MIN_WAGE,
        MAX_WAGE
    )
VALUES (
        '30003',
        '9515 Chapel Hill Rd, Morrisville, NC 27560',
        '7798182200',
        '0',
        '0',
        '20',
        '25'
    );
INSERT INTO "CAR" (CAR_ID, MANUFACTURER)
VALUES ('1', 'Honda');
INSERT INTO "CAR" (CAR_ID, MANUFACTURER)
VALUES ('2', 'Nissan');
INSERT INTO "CAR" (CAR_ID, MANUFACTURER)
VALUES ('3', 'Toyota');
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10001',
        '30001',
        'Peter',
        'Parker',
        'peterparker@gmail.com',
        'Raleigh, 27606',
        'peter_parker',
        'parker',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10002',
        '30001',
        'Diana',
        'Prince',
        'dianaprince@gmail.com',
        'Raleigh, 27606',
        'diana_prince',
        'prince',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10053',
        '30002',
        'Billy',
        'Batson',
        'billbatson@gmail.com',
        'Raleigh, 27606',
        'billy_batson',
        'batson',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10010',
        '30002',
        'Bruce',
        'Wayne',
        'bruce_wayne@gmail.com',
        'Raleigh, 27606',
        'bruce_wayne',
        'wayne',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10001',
        '30002',
        'Steve',
        'Rogers',
        'steverogers@gmail.com',
        'Raleigh, 27606',
        'steve_rogers',
        'rogers',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10035',
        '30002',
        'Happy',
        'Hogan',
        'happyhogan@gmail.com',
        'Raleigh, 27606',
        'happy_hogan',
        'hogan',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10002',
        '30003',
        'Tony',
        'Stark',
        'tonystark@gmail.com',
        'Raleigh, 27606',
        'tony_stark',
        'stark',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10003',
        '30003',
        'Natasha',
        'Romanoff',
        'natasharomanoff@gmail.com',
        'Raleigh, 27606',
        'natasha_romanoff',
        'romanoff',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10011',
        '30003',
        'Harvey',
        'Bullock',
        'harveybullock@gmail.com',
        'Raleigh, 27606',
        'harvey_bullock',
        'bullock',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10062',
        '30003',
        'Sam',
        'Wilson',
        'samwilson@gmail.com',
        'Raleigh, 27606',
        'sam_wilson',
        'wilson',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10501',
        '30003',
        'Wanda',
        'Maximoff',
        'wandamaximoff@gmail.com',
        'Raleigh, 27606',
        'wanda_maximoff',
        'maximoff',
        '0'
    );
INSERT INTO "CUSTOMER" (
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        ADDRESS,
        USERNAME,
        PASSWORD,
        STATUS
    )
VALUES (
        '10010',
        '30003',
        'Virginia',
        'Potts',
        'virginiapotts@gmail.com',
        'Raleigh, 27606',
        'virginia_potts',
        'potts',
        '0'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123456789',
        '30001',
        'John Doe',
        '1378 University Woods, Raleigh, NC 27612',
        TO_DATE('2022-11-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '1',
        'jdoe@gmail.com',
        '8636368778',
        'john_doe',
        'doe'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '987654321',
        '30002',
        'Rachel Brooks',
        '2201 Gorman Parkwood, Raleigh, NC 27618',
        TO_DATE('2022-11-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '1',
        'rbrooks@ymail.com',
        '8972468552',
        'rachel_brooks',
        'brooks'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '987612345',
        '30003',
        'Caleb Smith',
        '1538 Red Bud Lane, Morrisville, NC 27560',
        TO_DATE('2022-11-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '1',
        'csmith@yahoo.com',
        '8547963210',
        'caleb_smith',
        'smith'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '30001',
        '30001',
        'Receptionist 1',
        'Raleigh, NC - 27606',
        TO_DATE('2022-11-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '2',
        'receptionist1@gmail.com',
        '9999999999',
        'receptionist_1',
        '1'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '30002',
        '30002',
        'Receptionist 2',
        'Raleigh, NC - 27606',
        TO_DATE('2022-11-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '2',
        'receptionist2@gmail.com',
        '9999999999',
        'receptionist_2',
        '2'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '30003',
        '30003',
        'Receptionist 3',
        'Raleigh, NC - 27606',
        TO_DATE('2022-11-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '2',
        'receptionist3@gmail.com',
        '9999999999',
        'receptionist_3',
        '3'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '132457689',
        '30001',
        'James Williams',
        '1400 Gorman St, Raleigh, NC 27606-2972 ',
        TO_DATE('2021-07-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'jwilliams@gmail.com',
        '4576312882',
        'james_williams',
        'williams'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '314275869',
        '30001',
        'David Johnson',
        '686 Stratford Court, Raleigh, NC 27606',
        TO_DATE('2021-08-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'djohnson@ymail.com',
        '9892321100',
        'david_johnson',
        'johnson'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '241368579',
        '30001',
        'Maria Garcia',
        '1521 Graduate Lane, Raleigh, NC 27606',
        TO_DATE('2021-08-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'mgarcia@yahoo.com',
        '4573459090',
        'maria_garcia',
        'garcia'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '423186759',
        '30002',
        'Ellie Clark',
        '3125 Avent Ferry Road, Raleigh, NC 27605',
        TO_DATE('2021-09-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'eclark@gmail.com',
        '9892180921',
        'ellie_clark',
        'clark'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123789456',
        '30002',
        'Robert Martinez',
        '1232 Tartan Circle, Raleigh, NC 27607',
        TO_DATE('2021-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'rmartinez@ymail.com',
        '7652304282',
        'robert_martinez',
        'martinez'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '789123456',
        '30002',
        'Charles Rodriguez',
        '218 Patton Lane, Raleigh, NC 27603',
        TO_DATE('2021-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'crodriguez@yahoo.com',
        '9092234281',
        'charles_rodriguez',
        'rodriguez'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '125689347',
        '30002',
        'Jose Hernandez',
        '4747 Dola Mine Road, Raleigh, NC 27609',
        TO_DATE('2021-10-17 18:53:56', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'jhernandez@gmail.com',
        '7653241714',
        'jose_hernandez',
        'hernandez'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '347812569',
        '30003',
        'Charlie Brown',
        '1 Rockford Mountain Lane, Morrisville, NC 27560',
        TO_DATE('2021-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'cbrown@ymail.com',
        '9091237568',
        'charlie_brown',
        'brown'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123456780',
        '30003',
        'Jeff Gibson',
        '900 Development Drive, Morrisville, NC 27560',
        TO_DATE('2021-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'jgibson@yahoo.com',
        '3390108899',
        'jeff_gibson',
        'gibson'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123456708',
        '30003',
        'Isabelle Wilder',
        '6601 Koppers Road, Morrisville, NC 27560',
        TO_DATE('2021-10-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'iwilder@gmail.com',
        '3394561231',
        'isabelle_wilder',
        'wilder'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123456078',
        '30003',
        'Peter Titus',
        '2860 Slater Road, Morrisville, NC 27560',
        TO_DATE('2021-10-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'ptitus@ymail.com',
        '3396723418',
        'peter_titus',
        'titus'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123450678',
        '30003',
        'Mark Mendez',
        '140 Southport Drive, Morrisville, NC 27560',
        TO_DATE('2021-10-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'mmendez@yahoo.com',
        '3395792080',
        'mark_mendez',
        'mendez'
    );
INSERT INTO "EMPLOYEE" (
        EMPLOYEE_ID,
        SERVICE_CENTER_ID,
        NAME,
        ADDRESS,
        START_DATE,
        ROLE,
        EMAIL,
        PHONE,
        USERNAME,
        PASSWORD
    )
VALUES (
        '123405678',
        '30003',
        'Lisa Alberti',
        '100 Valley Glen Drive, Morrisville, NC 27560',
        TO_DATE('2021-11-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        '3',
        'lalberti@yahoo.com',
        '3391126787',
        'lisa_alberti',
        'alberti'
    );
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES ('1', '53000', '2', '10001', '30001', '3', '2007')
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '2',
        '117000',
        '1',
        '10002',
        '30001',
        '1',
        '1999'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '3',
        '111000',
        '3',
        '10053',
        '30002',
        '2',
        '2015'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES ('4', '21000', '1', '10010', '30002', '3', '2020')
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '5',
        '195500',
        '3',
        '10001',
        '30002',
        '2',
        '2019'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES ('6', '67900', '2', '10035', '30002', '1', '2013')
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES ('7', '10000', '1', '10002', '30003', '1', '2000')
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '8',
        '195550',
        '2',
        '10003',
        '30003',
        '3',
        '2004'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '9',
        '123800',
        '3',
        '10011',
        '30003',
        '3',
        '2010'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '10',
        '51300',
        '1',
        '10062',
        '30003',
        '2',
        '2011'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '11',
        '39500',
        '2',
        '10501',
        '30003',
        '2',
        '2013'
    )
INSERT INTO "CUSTOMER_CAR" (
        VIN,
        MILEAGE,
        LAST_SCHEDULED_MAINTENANCE,
        CUSTOMER_ID,
        SERVICE_CENTER_ID,
        CAR_ID,
        YEAR
    )
VALUES (
        '12',
        '49900',
        '1',
        '10010',
        '30003',
        '1',
        '2021'
    )
INSERT INTO "SALARIED_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY)
VALUES ('123456789', '30001', '44')
INSERT INTO "SALARIED_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY)
VALUES ('987654321', '30002', '35')
INSERT INTO "SALARIED_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY)
VALUES ('987612345', '30003', '25')
INSERT INTO "SALARIED_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY)
VALUES ('30001', '30001', '10')
INSERT INTO "SALARIED_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY)
VALUES ('30002', '30002', '10')
INSERT INTO "SALARIED_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, SALARY)
VALUES ('30003', '30003', '10')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('132457689', '30001', '35')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('314275869', '30001', '35')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('241368579', '30001', '35')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('423186759', '30002', '25')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('123789456', '30002', '25')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('789123456', '30002', '25')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('125689347', '30002', '25')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('347812569', '30003', '22')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('123456780', '30003', '22')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('123456708', '30003', '22')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('123456078', '30003', '22')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('123450678', '30003', '22')
INSERT INTO "HOURLY_PAID_EMPLOYEE" (EMPLOYEE_ID, SERVICE_CENTER_ID, HOURLY_RATE)
VALUES ('123405678', '30003', '22')
INSERT INTO "SCHEDULE_BUNDLE" (SCHEDULE_BUNDLE_ID, NAME)
VALUES ('1', 'A')
INSERT INTO "SCHEDULE_BUNDLE" (SCHEDULE_BUNDLE_ID, NAME)
VALUES ('2', 'B')
INSERT INTO "SCHEDULE_BUNDLE" (SCHEDULE_BUNDLE_ID, NAME)
VALUES ('3', 'C')
INSERT INTO "SERVICE_CATEGORY" (CATEGORY_ID, CATEGORY_NAME)
VALUES ('1', 'Engine Services')
INSERT INTO "SERVICE_CATEGORY" (CATEGORY_ID, CATEGORY_NAME)
VALUES ('2', 'Exhaust Services')
INSERT INTO "SERVICE_CATEGORY" (CATEGORY_ID, CATEGORY_NAME)
VALUES ('3', 'Electrical Services')
INSERT INTO "SERVICE_CATEGORY" (CATEGORY_ID, CATEGORY_NAME)
VALUES ('4', 'Transmission Services')
INSERT INTO "SERVICE_CATEGORY" (CATEGORY_ID, CATEGORY_NAME)
VALUES ('5', 'Tire Services')
INSERT INTO "SERVICE_CATEGORY" (CATEGORY_ID, CATEGORY_NAME)
VALUES ('6', 'Heating and A/C Services')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('101', 'Belt Replacement')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('102', 'Engine Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('103', 'Exhaust Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('104', 'Muffler Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('105', 'Alternator Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('106', 'Power Lock Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('107', 'Axle Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('108', 'Brake Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('109', 'Tire Balancing')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('110', 'Wheel Alignment')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('111', 'Compressor Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('112', 'Evaporator Repair')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('113', 'Oil Changes')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('114', 'Filter Replacements')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('115', 'Check Engine Light Diagnostics')
INSERT INTO "SERVICE" (ID, SERVICE_NAME)
VALUES ('116', 'Suspension Repair')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('101', '1', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('101', '2', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('101', '3', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('102', '1', '5')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('102', '2', '5')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('102', '3', '5')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('103', '1', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('103', '2', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('103', '3', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('104', '1', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('104', '2', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('104', '3', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('105', '1', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('105', '2', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('105', '3', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('106', '1', '5')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('106', '2', '5')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('106', '3', '5')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('107', '1', '7')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('107', '2', '7')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('107', '3', '7')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('108', '1', '3')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('108', '2', '3')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('108', '3', '3')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('109', '1', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('109', '2', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('109', '3', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('110', '1', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('110', '2', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('110', '3', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('111', '1', '3')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('111', '2', '3')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('111', '3', '3')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('112', '1', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('112', '2', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('112', '3', '4')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('113', '1', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('113', '2', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('113', '3', '2')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('114', '1', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('114', '2', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('114', '3', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('115', '1', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('115', '2', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('115', '3', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('116', '1', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('116', '2', '1')
INSERT INTO "SERVICES_CAR" (ID, CAR_ID, TIME_ESTIMATED)
VALUES ('116', '3', '1')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('101', '1')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('102', '1')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('103', '2')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('104', '2')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('105', '3')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('106', '3')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('107', '4')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('108', '4')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('109', '5')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('110', '5')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('111', '6')
INSERT INTO "REPAIR_SERVICE" (ID, CATEGORY_ID)
VALUES ('112', '6')
INSERT INTO "MAINTENANCE_SERVICE" (ID, SCHEDULE_BUNDLE_ID)
VALUES ('113', '1')
INSERT INTO "MAINTENANCE_SERVICE" (ID, SCHEDULE_BUNDLE_ID)
VALUES ('114', '1')
INSERT INTO "MAINTENANCE_SERVICE" (ID, SCHEDULE_BUNDLE_ID)
VALUES ('115', '2')
INSERT INTO "MAINTENANCE_SERVICE" (ID, SCHEDULE_BUNDLE_ID)
VALUES ('116', '3')
INSERT INTO "MAINTENANCE_SERVICE" (ID, SCHEDULE_BUNDLE_ID)
VALUES ('108', '2')
INSERT INTO "MAINTENANCE_SERVICE" (ID, SCHEDULE_BUNDLE_ID)
VALUES ('112', '3')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('1', '0', '210')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('2', '0', '175')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('3', '1', '105')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('4', '1', '420')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('5', '1', '720')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('6', '1', '220')
INSERT INTO "DMMEHTA2"."INVOICE" (INVOICE_ID, INVOICE_STATUS, TOTAL_COST)
VALUES ('7', '1', '195')
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '1',
        '110',
        '123405678',
        '30003',
        '11',
        '1',
        TO_TIMESTAMP(
            '2022-11-08 08:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-08 09:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '2',
        '101',
        '123450678',
        '30003',
        '12',
        '2',
        TO_TIMESTAMP(
            '2022-11-08 08:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-08 09:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '3',
        '109',
        '123456780',
        '30003',
        '10',
        '3',
        TO_TIMESTAMP(
            '2022-11-07 08:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-07 09:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '4',
        '105',
        '423186759',
        '30002',
        '6',
        '4',
        TO_TIMESTAMP(
            '2022-11-17 09:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-17 16:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '5',
        '111',
        '125689347',
        '30002',
        '3',
        '5',
        TO_TIMESTAMP(
            '2022-11-14 10:00:00.522978000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-14 14:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '6',
        '113',
        '789123456',
        '30002',
        '4',
        '6',
        TO_TIMESTAMP(
            '2022-11-18 09:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-18 11:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '7',
        '114',
        '789123456',
        '30002',
        '4',
        '6',
        TO_TIMESTAMP(
            '2022-11-18 11:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-18 12:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '8',
        '108',
        '789123456',
        '30002',
        '4',
        '6',
        TO_TIMESTAMP(
            '2022-11-18 13:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-18 16:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '9',
        '115',
        '789123456',
        '30002',
        '4',
        '6',
        TO_TIMESTAMP(
            '2022-11-18 16:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-18 17:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '10',
        '113',
        '125689347',
        '30002',
        '5',
        '7',
        TO_TIMESTAMP(
            '2022-11-25 13:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-25 15:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )
INSERT INTO "DMMEHTA2"."SERVICE_EVENT" (
        SERVICE_ID,
        ID,
        MECHANIC_ID,
        SERVICE_CENTER_ID,
        VIN,
        INVOICE_ID,
        START_TIME,
        END_TIME
    )
VALUES (
        '11',
        '114',
        '125689347',
        '30002',
        '5',
        '7',
        TO_TIMESTAMP(
            '2022-11-25 15:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        ),
        TO_TIMESTAMP(
            '2022-11-25 16:00:00.000000000',
            'YYYY-MM-DD HH24:MI:SS.FF'
        )
    )