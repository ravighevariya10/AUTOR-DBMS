INSERT INTO SERVICE_CENTER(sc_id, address, phone_number, open_on_saturday, min_wage, max_wage, hourly_rate) VALUES('30001','3921 Western Blvd, Raleigh, NC 27606', 3392601234, 'Y', 30, 40, '35');
INSERT INTO SERVICE_CENTER(sc_id, address, phone_number, open_on_saturday, min_wage, max_wage, hourly_rate) VALUES('30002','4500 Preslyn Dr Suite 103, Raleigh, NC 27616', 8576890280, 'Y', 25, 35, '25');
INSERT INTO SERVICE_CENTER(sc_id, address, phone_number, open_on_saturday, min_wage, max_wage, hourly_rate) VALUES('30003','9515 Chapel Hill Rd, Morrisville, NC 27560', 7798182200, 'N', 20, 25, '22');

INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (132457689, '30001', 'James Williams', 'jwilliams@gmail.com', '1400 Gorman St, Raleigh, NC 27606-2972', '4576312882', 'MECHANIC', TO_DATE('7/2/2021', 'MM/DD/YYYY'), 35);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (314275869, '30001', 'David Johnson', 'djohnson@ymail.com', '686 Stratford Court, Raleigh, NC 27606', '9892321100', 'MECHANIC', TO_DATE ('8/25/2021', 'MM/DD/YYYY'), 35);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (241368579, '30001', 'Maria Garcia', 'mgarcia@yahoo.com', '1521 Graduate Lane, Raleigh, NC 27606', '4573459090', 'MECHANIC', TO_DATE ('8/26/2021', 'MM/DD/YYYY'), 35);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (423186759, '30002', 'Ellie Clark', 'eclark@gmail.com', '3125 Avent Ferry Road, Raleigh, NC 27605', '9892180921', 'MECHANIC', TO_DATE ('9/1/2021', 'MM/DD/YYYY'), 25);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (123789456, '30002', 'Robert Martinez', 'rmartinez@ymail.com', '1232 Tartan Circle, Raleigh, NC 27607', '7652304282', 'MECHANIC', TO_DATE ('10/11/2021', 'MM/DD/YYYY'), 25);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (789123456, '30002', 'Charles Rodriguez', 'crodriguez@yahoo.com', '218 Patton Lane, Raleigh, NC 27603', '9092234281', 'MECHANIC', TO_DATE('10/11/2021', 'MM/DD/YYYY'), 25);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (125689347, '30002', 'Jose Hernandez', 'jhernandez@gmail.com', '4747 Dola Mine Road, Raleigh, NC 27609', '7653241714', 'MECHANIC', TO_DATE ('10/17/2021', 'MM/DD/YYYY'), 25);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (347812569, '30003', 'Charlie Brown', 'cbrown@ymail.com', '1 Rockford Mountain Lane, Morrisville, NC 27560', '9091237568', 'MECHANIC', TO_DATE ('10/18/2021', 'MM/DD/YYYY'), 22);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (123456780, '30003', 'Jeff Gibson', 'jgibson@yahoo.com', '900 Development Drive, Morrisville, NC 27560', '3390108899', 'MECHANIC', TO_DATE ('10/20/2021', 'MM/DD/YYYY'), 22);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (123456708, '30003', 'Isabelle Wilder', 'iwilder@gmail.com', '6601 Koppers Road, Morrisville, NC 27560', '3394561231', 'MECHANIC', TO_DATE ('10/22/2021', 'MM/DD/YYYY'), 22);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (123456078, '30003', 'Peter Titus', 'ptitus@ymail.com', '2860 Slater Road, Morrisville, NC 27560', '3396723418', 'MECHANIC', TO_DATE ('10/28/2021', 'MM/DD/YYYY'), 22);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (123450678, '30003', 'Mark Mendez', 'mmendez@yahoo.com', '140 Southport Drive, Morrisville, NC 27560', '3395792080', 'MECHANIC', TO_DATE ('10/31/2021', 'MM/DD/YYYY'), 22);
INSERT INTO EMPLOYEE (emp_id, sc_id, emp_name, emp_email, emp_address, emp_contact, emp_role, emp_startdate, emp_compensation) VALUES (123405678, '30003', 'Lisa Alberti', 'lalberti@yahoo.com', '100 Valley Glen Drive, Morrisville, NC 27560', '3391126787', 'MECHANIC', TO_DATE ('11/01/2021', 'MM/DD/YYYY'), 22);

INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10001, '30001', 'Peter Parker');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10002, '30001', 'Diana Prince');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10053, '30002', 'Billy Batson');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10010, '30002', 'Bruce Wayne');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10001, '30002', 'Steve Rogers');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10035, '30002', 'Happy Hogan');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10002, '30003', 'Tony Stark');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10003, '30003', 'Natasha Romanoff');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10011, '30003', 'Harvey Bullock');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10062, '30003', 'Sam Wilson');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10501, '30003', 'Wanda Maximoff');
INSERT INTO CUSTOMER(c_id, sc_id, c_name) VALUES(10010, '30003', 'Virginia Potts');


INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10501', 'Wanda Maximoff', '30003', 'P39VN198', 'Nissan', '39500', 'Wheel Alignment', '1', '2', '1', '2', '123405678', 'Unpaid');
INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10010', 'Virginia Potts', '30003', '39YVS415', 'Honda', '49900', 'Belt Replacement', '1', '2', '1', '2', '123450678', 'Unpaid');
INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10062', 'Sam Wilson', '30003', '29T56WC3', 'Nissan', '51300', 'Tire Balancing', '1', '1', '1', '2', '123456780', 'Paid');
INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10035', 'Happy Hogan', '30002', '9R2UHP54', 'Honda', '67900', 'Alternator Repair', '2', '4', '2', '6', '423186759', 'Paid');
INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10053', 'Billy Batson', '30002', '5TR3K914', 'Nissan', '111000', 'Compressor Repair', '2', '1', '3', '6', '125689347', 'Paid');
INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10010', 'Bruce Wayne', '30002', '15DC9A87', 'Toyota', '21000', 'B', '2', '6', '2', '8', '789123456', 'Paid');
INSERT INTO scheduled_services (C_ID, FULL_NAME, SC_ID, VIN, MANUFACTURER, MILEAGE, SCHEDULE_SERVICE, WEEK, DAY, START_TIME_SLOT, END_TIME_SLOT, MECHANIC_ID, INVOICE_STATUS) VALUES ('10001', 'Steve Rogers', '30002', '18S5R2D8', 'Nissan', '195500', 'A', '3', '5', '5', '8', '125689347', 'Paid');


INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('132457689','30001','MECHANIC','abcd1','abcd1')
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('314275869','30001','MECHANIC','abcd2','abcd2')
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('241368579','30001','MECHANIC','abcd3','abcd3')

INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('423186759','30002','MECHANIC','abcd4','abcd4');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('123789456','30002','MECHANIC','abcd5','abcd5');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('789123456','30002','MECHANIC','abcd6','abcd6');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('125689347','30002','MECHANIC','abcd7','abcd7');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('347812569','30003','MECHANIC','abcd8','abcd8');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('123456780','30003','MECHANIC','abcd9','abcd9');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('123456708','30003','MECHANIC','abcd10','abcd10');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('123456078','30003','MECHANIC','abcd11','abcd11');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('123450678','30003','MECHANIC','abcd12','abcd12');
INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('123405678','30003','MECHANIC','abcd13','abcd13');
