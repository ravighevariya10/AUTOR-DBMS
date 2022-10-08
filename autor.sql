CREATE TABLE SERVICE_CENTER(
    sc_id VARCHAR(20) NOT NULL, 
    telephone_no NUMBER, 
    address VARCHAR(50), 
    working_days VARCHAR(20) CONSTRAINT working_days
    CHECK (working_days in('M-F','SAT')), 
    opening_time VARCHAR(20) CONSTRAINT opening_time
    CHECK (opening_time in('8:00 AM', '9:00 AM')),
    closing_time VARCHAR(20) CONSTRAINT closing_time
    CHECK (closing_time in('8:00 PM', '1:00 PM')),
    PRIMARY KEY(sc_id)
);

CREATE TABLE SERVICES(
  s_no INTEGER,
  s_name varchar(20) NOT NULL,
  PRIMARY KEY(s_no)
);
    
CREATE TABLE SCHAVE(
    price INTEGER, 
    duration VARCHAR(15),
    s_no INTEGER NOT NULL, 
    sc_id VARCHAR(20), 
    vin varchar(8) PRIMARY KEY,
    FOREIGN KEY(s_no) REFERENCES SERVICES(s_no),
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id),
    FOREIGN KEY(vin) REFERENCES VEHICLE(vin)
);

CREATE TABLE VEHICLE (
  vin varchar(8) PRIMARY KEY,
  manufacturer varchar(10) NOT NULL,
  current_mileage INTEGER NOT NULL,
  year INTEGER NOT NULL
);

CREATE TABLE MAINTENANCE (
  schedule_name char,
  s_no INTEGER PRIMARY KEY,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no)
);

CREATE TABLE REPAIR (
  cat_name VARCHAR(20),
  s_no INTEGER PRIMARY KEY,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no)
);

CREATE TABLE VM_SERVICED (
  datetime date NOT NULL,
  s_no INTEGER,
  vin varchar(20),
  PRIMARY KEY(vin,s_no),
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no),
  FOREIGN KEY (vin) REFERENCES VEHICLE(vin)
);

CREATE TABLE EMPLOYEE(
    emp_id NUMBER(9),
    sc_id VARCHAR(20) NOT NULL,
    emp_name VARCHAR(50) NOT NULL,
    emp_email VARCHAR(50),
    emp_Address VARCHAR(100),
    emp_contact CHAR(10),
    emp_role VARCHAR(6) CONSTRAINT role_type 
    CHECK (emp_role in('MANAGER','RECEPTIONIST','MECHANIC')),
    PRIMARY KEY(emp_id),
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)
);


CREATE TABLE HOURLY_EMP(
    emp_id NUMBER(9),
    sc_id VARCHAR(20) NOT NULL,
    hourly_rate INTEGER NOT NULL,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id),
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)
)

CREATE TABLE CONTRACT_EMP(
    emp_id NUMBER(9),
    annual_salary INTEGER NOT NULL,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id)
)

Create table CUSTOMER_ASSOCIATED_SC(
    c_id int NOT NULL, 
    c_status int, 
    c_fame varchar(20), 
    c_lame varchar(20), 
    sc_id VARCHAR(20) NOT NULL, 
    PRIMARY KEY(c_id), 
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)
);


Create table OWNS(
    sc_id VARCHAR(20), 
    c_id int NOT NULL, 
    vin VARCHAR(8) NOT NULL, 
    FOREIGN KEY (vin) REFERENCES VEHICLE(vin), 
    FOREIGN KEY(c_id) REFERENCES CUSTOMER_ASSOCIATED_SC(c_id), 
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id)
); 

Create table SE_REQUESTED(
    sc_id VARCHAR(20), 
    c_id int NOT NULL, 
    sevent_id varchar(20) NOT NULL PRIMARY KEY, 
    total_amount_paid int, 
    amount_charged int, 
    s_no int NOT NULL, 
    mechanic_id int NOT NULL, 
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id), 
    FOREIGN KEY(s_no) REFERENCES SERVICES(s_no), 
    FOREIGN KEY(c_id) REFERENCES CUSTOMER_ASSOCIATED_SC(c_id), 
    FOREIGN KEY (mechanic_id) REFERENCES EMPLOYEE(emp_id)
);

CREATE TABLE CUSTOMER_ADDED(
    c_id int, 
    sc_id VARCHAR(20), 
    emp_id Number(9), 
    FOREIGN KEY(c_id) REFERENCES CUSTOMER_ASSOCIATED_SC(c_id),
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id),
    FOREIGN KEY(emp_id) REFERENCES EMPLOYEE(emp_id)
);

CREATE TABLE DONE_ON(
    sc_id VARCHAR(20),
    c_id int,
    vin VARCHAR(8),
    sevent_id VARCHAR(20),
    FOREIGN KEY(c_id) REFERENCES CUSTOMER_ASSOCIATED_SC(c_id),
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id),
    FOREIGN KEY(vin) REFERENCES VEHICLE(vin), 
    FOREIGN KEY(sevent_id) REFERENCES SE_REQUESTED(sevent_id)
);
