REM   Script: manan_autor
REM   queries

Create table CUSTOMER(c_id int NOT NULL, c_status int, c_name varchar(20), PRIMARY KEY (c_id)) 
Create table OWNS(c_id int NOT NULL, vin int NOT NULL, FOREIGN KEY (c_id) REFERENCES CUSTOMER(c_id), FOREIGN KEY (vin) REFERENCES VEHICLE(vin)) 
Create table ASSOCIATED_SERVICE_CENTER(c_id int NOT NULL, sc_id int NOT NULL, FOREIGN KEY (c_id) REFERENCES CUSTOMER(c_id), FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)) 
Create table SERVICE_EVENT(c_id int NOT NULL, sevent_id varchar NOT NULL, total_amount_paid int, amount_charged int, s_no int NOT NULL, mechanic_id int NOT NULL, FOREIGN KEY(s_no) REFERENCES SERVICES(s_no), FOREIGN KEY(c_id) REFERENCES CUSTOMER(c_id), FOREIGN KEY (mechanic_id) REFERENCES EMPLOYEE(emp_id));

