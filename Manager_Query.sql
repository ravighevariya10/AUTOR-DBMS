--Manager: :Add Employees
stmt.execute("INSERT INTO EMPLOYEE (EMP_ID,SC_ID,EMP_NAME, EMP_EMAIL, EMP_ADDRESS, EMP_CONTACT, EMP_ROLE, EMP_STARTDATE, EMP_COMPENSATION)VALUES('"+ emp_id + "','"+ name + "','"+ sc_id +"''"+ email_address +"','"+ address +"','"+ phone_number +"','"+ role +"', '"+ start_date +"','"+ compensation +"')");

--Manager: Setup Operational Hours
--if yes:
stmt.execute("UPDATE SERVICE_CENTER SET OPENING_TIME = '"+ "9:00am" + "', CLOSING_TIME = '"+ "1:00pm" + "', OPEN_ON_SATURDAY = '"+ "Y" + "' WHERE sc_id = '"+ sc_id + "' ");

--else
stmt.execute("UPDATE SERVICE_CENTER SET OPENING_TIME = '"+ "8:00am" + "', CLOSING_TIME = '"+ "8:00pm" + "', OPEN_ON_SATURDAY = '"+ "N" + "' WHERE sc_id = '"+ sc_id + "' ");

--Manager: Setup Repair Service Prices
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = belt_replacement_price
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = '"+ 'Belt Replacement' +"')");

stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = engine_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name ='"+ 'Engine Repair' +"')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = catalytic_converter_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Catalytic Converter Repair')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = muffler_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Muffler Repair')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = power_lock_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Power Lock Repair')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = axle_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Axle Repair')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = transmission_flush_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Transmission Flush Repair')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = tire_balancing_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Tire Balancing Repair')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = wheel_alignment_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Wheel Alignment')");
stmt.execute("UPDATE SERVICES_PROVIDED_DETAILS
SET price = compressor_repair_price 
WHERE s_no = (SELECT DISTINCT s_no
		FROM SERVICES
		WHERE s_name = 'Compressor Repair')");

--Manager: Setup Maintenance Service Prices

stmt.execute("UPDATE MAINTENANCE_PRICES
SET price = schedule_a_price 
WHERE schedule_name= 'A'");

stmt.execute("UPDATE MAINTENANCE_PRICES
SET price = schedule_b_price 
WHERE schedule_name= 'B'");

stmt.execute("UPDATE MAINTENANCE_PRICES
SET price = schedule_c_price 
WHERE schedule_name= 'C'");


