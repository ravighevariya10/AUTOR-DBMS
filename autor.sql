CREATE TABLE SERVICE_CENTER(
    sc_id VARCHAR(20) NOT NULL, 
    telephone_no NUMBER, 
    address VARCHAR(50), 
    manager_id NUMBER(9) NOT NULL, 
    hourly_rate NUMBER,
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
    
CREATE TABLE VEHICLE (
  vin varchar(8) PRIMARY KEY,
  manufacturer varchar(10) NOT NULL,
  current_mileage INTEGER NOT NULL,
  year INTEGER NOT NULL
);

CREATE TABLE SERVICES_PROVIDED_DETAILS(
    price INTEGER, 
    duration VARCHAR(15),
    s_no INTEGER NOT NULL, 
    sc_id VARCHAR(20), 
    vin varchar(8),
    PRIMARY KEY(vin, s_no, sc_id),
    FOREIGN KEY(s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE,
    FOREIGN KEY(sc_id) REFERENCES SERVICE_CENTER(sc_id) ON DELETE CASCADE,
    FOREIGN KEY(vin) REFERENCES VEHICLE(vin) ON DELETE CASCADE
);


CREATE TABLE MAINTENANCE (
  schedule_name char,
  s_no INTEGER PRIMARY KEY,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

/*CREATE TABLE REPAIR (
 cat_name VARCHAR(20),
  s_no INTEGER PRIMARY KEY,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);*/

CREATE TABLE ENGINE_SERVICES (
  s_no INTEGER NOT NULL,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

CREATE TABLE EXHAUST_SERVICES (
  s_no INTEGER NOT NULL,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

CREATE TABLE ELECTRICAL_SERVICES (
  s_no INTEGER NOT NULL,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

CREATE TABLE TRANSMISSION_SERVICES (
  s_no INTEGER NOT NULL,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

CREATE TABLE TIRE_SERVICES (
  s_no INTEGER NOT NULL,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

CREATE TABLE H_AND_AC_SERVICES (
  s_no INTEGER NOT NULL,
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE
);

CREATE TABLE VM_SERVICED (
  datetime date NOT NULL,
  s_no INTEGER,
  vin varchar(20),
  PRIMARY KEY(vin,s_no),
  FOREIGN KEY (s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE,
  FOREIGN KEY (vin) REFERENCES VEHICLE(vin) ON DELETE CASCADE
);

CREATE TABLE EMPLOYEE(
    emp_id NUMBER(9) NOT NULL,
    sc_id VARCHAR(20) NOT NULL,
    emp_name VARCHAR(50) NOT NULL,
    emp_email VARCHAR(50),
    emp_Address VARCHAR(100),
    emp_contact VARCHAR(10),
    emp_role VARCHAR(6) CONSTRAINT role_type 
    CHECK (emp_role in('MANAGER','RECEPTIONIST','MECHANIC')),
    PRIMARY KEY(emp_id,sc_id),
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id) ON DELETE CASCADE
);


CREATE TABLE HOURLY_EMP(
    emp_id NUMBER(9) NOT NULL,
    sc_id  VARCHAR(20) NOT NULL,
    hourly_rate INTEGER NOT NULL,
    PRIMARY KEY (emp_id,sc_id),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id) ON DELETE CASCADE,
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id) ON DELETE CASCADE
)

CREATE TABLE CONTRACT_EMP(
    emp_id NUMBER(9),
    sc_id  VARCHAR(20) NOT NULL,
    annual_salary INTEGER NOT NULL,
    PRIMARY KEY (emp_id,sc_id),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id) ON DELETE CASCADE,
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id) ON DELETE CASCADE
)

Create table CUSTOMER(
    c_id int NOT NULL, 
    c_status int, 
    c_fname varchar(20), 
    c_lname varchar(20), 
    sc_id VARCHAR(20) NOT NULL, 
    PRIMARY KEY(c_id, sc_id), 
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id) ON DELETE CASCADE
);


Create table OWNS(
    sc_id VARCHAR(20), 
    c_id int NOT NULL, 
    vin VARCHAR(8) NOT NULL,
    PRIMARY KEY(sc_id, c_id, vin),
    FOREIGN KEY (vin) REFERENCES VEHICLE(vin) ON DELETE CASCADE, 
    FOREIGN KEY(c_id,sc_id) REFERENCES CUSTOMER(c_id,sc_id) ON DELETE CASCADE
 ); 

Create table SERVICEEVENT(
    sc_id VARCHAR(20), 
    c_id int NOT NULL, 
    sevent_id varchar(20) NOT NULL, 
    total_amount_paid int, 
    amount_charged int, 
    s_no int NOT NULL, 
    mechanic_id int NOT NULL, 
    PRIMARY KEY(c_id, sc_id, sevent_id, mechanic_id),
    FOREIGN KEY(c_id, sc_id) REFERENCES CUSTOMER(c_id, sc_id) ON DELETE CASCADE, 
    FOREIGN KEY(s_no) REFERENCES SERVICES(s_no) ON DELETE CASCADE, 
    FOREIGN KEY (mechanic_id) REFERENCES EMPLOYEE(emp_id) ON DELETE CASCADE
);

CREATE TABLE CUSTOMER_ADDED(
    c_id int, 
    sc_id VARCHAR(20), 
    emp_id Number(9), 
    PRIMARY KEY(c_id,sc_id,emp_id),
    FOREIGN KEY(c_id, sc_id) REFERENCES CUSTOMER(c_id, sc_id) ON DELETE CASCADE,
    FOREIGN KEY(emp_id) REFERENCES EMPLOYEE(emp_id) ON DELETE CASCADE
);

CREATE TABLE DONE_ON(
    sc_id VARCHAR(20),
    c_id int,
    vin VARCHAR(8),
    sevent_id VARCHAR(20),
    PRIMARY KEY(sc_id,c_id,vin,sevent_id),
    FOREIGN KEY(vin) REFERENCES VEHICLE(vin), 
    FOREIGN KEY(sevent_id, c_id, sc_id) REFERENCES SERVICEEVENT(sevent_id, c_id, sc_id)
);
