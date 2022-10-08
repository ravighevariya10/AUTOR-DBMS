CREATE TABLE SERVICE_CENTER(
    sc_id VARCHAR NOT NULL, 
    telephone_no INTEGER, 
    address VARCHAR(50), 
    working_days VARCHAR(20) CONSTRAINT working_days
    CHECK (working_days in('M-F','SAT')), 
    opening_time VARCHAR(20) CONSTRAINT opening_time
    CHECK (opening_time in('8:00 AM', '9:00 AM')),
    closing_time VARCHAR(20) CONSTRAINT closing_time
    CHECK (closing_time in('8:00 PM', '1:00 PM')),
    PRIMARY KEY(sc_id)
);
    
CREATE TABLE SCHAVE(
    price INTEGER, 
    duration VARCHAR(15),
    s_no INTEGER NOT NULL, 
    sc_id VARCHAR, 
    vin varchar(8) PRIMARY KEY,
    FOREIGN KEY(s_no) REFERENCES SERVICES(s_no),
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id),
    FOREIGN KEY(vin) REFERENCES VEHICLE(vin)
)

Create table OWNS(c_id int NOT NULL, vin int NOT NULL, FOREIGN KEY (vin) REFERENCES VEHICLE(vin)) 

Create table CUSTOMER_ASSOCIATED_SC(c_id int NOT NULL, c_status int, c_fame varchar(20), c_lame varchar(20), PRIMARY KEY(c_id, sc_id), sc_id int NOT NULL, FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)) 

Create table SERVICE_EVENT(c_id int NOT NULL, sevent_id varchar NOT NULL, total_amount_paid int, amount_charged int, s_no int NOT NULL, mechanic_id int NOT NULL, FOREIGN KEY(s_no) REFERENCES SERVICES(s_no), FOREIGN KEY(c_id) REFERENCES CUSTOMER(c_id), FOREIGN KEY (mechanic_id) REFERENCES EMPLOYEE(emp_id));
