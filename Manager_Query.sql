--Manager: :Add Employees
INSERT INTO EMPLOYEE (EMP_NAME, EMP_EMAIL, EMP_ADDRESS, EMP_CONTACT, EMP_ROLE, EMP_STARTDATE, EMP_COMPENSATION)VALUES(name, email_address, address, phone_number, role, start_date, compensation);

--Manager: Setup Operational Hours
--if yes:
INSERT INTO SERVICE_CENTER (WORKING_DAYS) VALUES ("Working on Saturday");

--else
INSERT INTO SERVICE_CENTER (WORKING_DAYS) VALUES ("Not working on Saturday");

--Manager: Setup Repair Service Prices
UPDATE SERVICES_PROVIDED_DETAILS
SET price = belt_replacement_price
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Belt Replacement');

UPDATE SERVICES_PROVIDED_DETAILS
SET price = engine_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Engine Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = catalytic_converter_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Catalytic Converter Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = muffler_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Muffler Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = power_lock_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Power Lock Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = axle_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Axle Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = transmission_flush_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Transmission Flush Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = tire_balancing_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Tire Balancing Repair');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = wheel_alignment_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Wheel Alignment');
UPDATE SERVICES_PROVIDED_DETAILS
SET price = compressor_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Compressor Repair');

--Manager: Setup Maintenance Service Prices

UPDATE MAINTENANCE_PRICES
SET price = schedule_a_price 
WHERE schedule_name= 'A';

UPDATE MAINTENANCE_PRICES
SET price = schedule_b_price 
WHERE schedule_name= 'B';

UPDATE MAINTENANCE_PRICES
SET price = schedule_c_price 
WHERE schedule_name= 'C';

--Manager: Add New Employees
INSERT INTO EMPLOYEE (EMP_NAME, EMP_EMAIL, EMP_ADDRESS, EMP_CONTACT, EMP_ROLE, EMP_STARTDATE, EMP_COMPENSATION)VALUES(name, email_address, address, phone_number, role, start_date, compensation);
