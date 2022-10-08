REM   Script: manan_autor
REM   queries

Create table OWNS(c_id int NOT NULL, vin int NOT NULL, FOREIGN KEY (vin) REFERENCES VEHICLE(vin)) 
Create table CUSTOMER_ASSOCIATED_SC(c_id int NOT NULL, c_status int, c_fame varchar(20), c_lame varchar(20), PRIMARY KEY(c_id, sc_id), sc_id int NOT NULL, FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)) 
Create table SERVICE_EVENT(c_id int NOT NULL, sevent_id varchar NOT NULL, total_amount_paid int, amount_charged int, s_no int NOT NULL, mechanic_id int NOT NULL, FOREIGN KEY(s_no) REFERENCES SERVICES(s_no), FOREIGN KEY(c_id) REFERENCES CUSTOMER(c_id), FOREIGN KEY (mechanic_id) REFERENCES EMPLOYEE(emp_id));
