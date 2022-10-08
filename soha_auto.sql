CREATE TABLE Employee(
    emp_id NUMBER(9),
    sc_id VARCHAR2 NOT NULL,
    emp_name VARCHAR2(50) NOT NULL,
    emp_email VARCHAR2(50),
    emp_Address VARCHAR2(100),
    emp_contact CHAR(10),
    emp_role VARCHAR2(6) CONSTRAINT role_type 
    CHECK (emp_role in('MANAGER','RECEPTIONIST','MECHANIC')),
    PRIMARY KEY(emp_id),
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)
);


CREATE TABLE Hourly_Emp(
    emp_id NUMBER(9),
    sc_id VARCHAR NOT NULL,
    hourly_rate INTEGER NOT NULL,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id),
    FOREIGN KEY (sc_id) REFERENCES SERVICE_CENTER(sc_id)
)

CREATE TABLE Contract_Emp(
    emp_id NUMBER(9),
    annual_salary INTEGER NOT NULL,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
)



