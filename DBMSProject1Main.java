import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import javax.swing.SortingFocusTraversalPolicy;

import java.sql.*;



class JDBC_Helper 
{

    private static Connection connection;
   static final String jdbcURL 
	= "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl01";


   static
   {
      try
      {
        
         Class.forName("oracle.jdbc.OracleDriver");
      }
      catch ( ClassNotFoundException e )
      {
         System.out.println( "Driver class not found" );
      }
   }

   public static Connection getConnection() throws SQLException 

   {
        String user = "sbhatia6";	
        String passwd = "200473741";
        connection = DriverManager.getConnection( jdbcURL, user, passwd );
        return connection;
    }
}

class Admin
{

    int service_counter = 200;

    public void adminOptions() throws SQLException
    {
        Home home = new Home();
       

        System.out.println("\n1.  System Set up");
        System.out.println("2.  Add New Store");
        System.out.println("3.  Add New Service");
        System.out.println("4.  Logout");

        System.out.print("\nEnter your choice here: ");

        Scanner admin_input = new Scanner(System.in);
        String admin_input_value = admin_input.nextLine();
        switch(admin_input_value)
        {
            case "1":
                adminSystemSetUpOptions();
                break;
            case "2":
                adminAddNewStore();
                break;
            case "3":
                adminAddNewService();
                break;
            case "4":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                adminOptions();
                break;
        }
    }

    public void adminSystemSetUpOptions() throws SQLException
    {
        Scanner admin_system_setup_input = new Scanner(System.in);

        System.out.println("\n1.  Upload service general information");
        System.out.println("2.  Upload store general information");
        System.out.println("3.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String admin_system_setup_input_value = admin_system_setup_input.nextLine();
        switch(admin_system_setup_input_value)
        {
            case "1":
                break;
            case "2":
                break;
            case "3":
                adminOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                adminSystemSetUpOptions();
                break;
        }
    }

    public void adminAddNewStore() throws SQLException
    {
        Scanner admin_add_new_store_input = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = null;
        System.out.print("\nStore ID: ");
        String store_id = admin_add_new_store_input.nextLine();
        System.out.print("Address: ");
        String address = admin_add_new_store_input.nextLine();
        System.out.print("Full Name: ");
        String name = admin_add_new_store_input.nextLine();
        System.out.print("Last Name: ");
        String last_name = admin_add_new_store_input.nextLine();
        System.out.print("Username: ");
        String username = admin_add_new_store_input.nextLine();
        System.out.print("Password: ");
        String password = admin_add_new_store_input.nextLine();
        System.out.print("Salary: ");
        String salary = admin_add_new_store_input.nextLine();
        System.out.print("Employee ID: ");
        String employee_id = admin_add_new_store_input.nextLine();
        System.out.print("Min Wage: ");
        String min_wage_mechanic = admin_add_new_store_input.nextLine();
        System.out.print("Max Wage: ");
        String max_wage_mechanic = admin_add_new_store_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add Store");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String admin_add_new_store_input_value = admin_add_new_store_input.nextLine();
        switch(admin_add_new_store_input_value)
        {
            case "1":
            try
            {
                String sql1= "insert into SERVICE_CENTER(sc_id,address,min_wage,max_wage)values('"+ store_id + "','" + address + "','" + min_wage_mechanic + "','" + max_wage_mechanic + "')";
                stmt.executeQuery(sql1);

                String sql3= "insert into employee(emp_id,sc_id,emp_name,emp_address,emp_role)values('"+ employee_id + "','" + store_id + "','" + name + "','" + address + " ','" + "MANAGER" + "')";
                stmt.executeQuery(sql3);

                String sql2= "insert into manager(manager_id,sc_id,m_name,salary,username,password)values('"+ employee_id + "','" + store_id + "','" + name + "','" + salary + "','" + username + " ','" + password + "')";
                stmt.executeQuery(sql2);
                
                String sql4 = "insert into employee_auth(emp_id, sc_id, emp_role, username, password) values('"+ employee_id +"','" + store_id + "', '"+ "MANAGER" +"', '"+ username +"', '"+ password +"')";
                stmt.executeQuery(sql4);

                System.out.println("\n---Store Added---");
                adminOptions();
            }
            catch(SQLException e)
            {
                System.out.println("--->FAILED: " + e);
            }
            
            //System.out.println(rs);
                break;
            case "2":
                adminOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                adminAddNewStore();
                break;
        }
    }

    public void adminAddNewService() throws SQLException
    {
        Scanner admin_add_new_service_input = new Scanner(System.in);

        

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = null;

        System.out.println("\n1.  Engine Services");
        System.out.println("2.  Exhaust Services");
        System.out.println("3.  Electrical Services");
        System.out.println("4.  Transmission Services");
        System.out.println("5.  Tire Services");
        System.out.println("6.  Heating and Air Conditioner Services");
        System.out.print("\nEnter existing service category: ");
        String service_category = admin_add_new_service_input.nextLine();
        //System.out.print("Service ID: ");
        //String service_id = admin_add_new_service_input.nextLine();
        System.out.print("Service Name: ");
        String service_name = admin_add_new_service_input.nextLine();
        System.out.print("Duration: ");
        String duration = admin_add_new_service_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add Service");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String admin_add_new_service_input_value = admin_add_new_service_input.nextLine();
        switch(admin_add_new_service_input_value)
        {
            case "1":
            try
            {
            //rs = stmt.executeQuery("SELECT s_no from SERVICES");
            
            //System.out.println(rs.getInt("s_no"));
            int s_no = service_counter + 1;
            service_counter++;

            stmt.execute("insert into SERVICES(s_no,s_name)values('"+ s_no + "','" + service_name + "')");
            stmt.execute("insert into REPAIR(service_name,s_no,duration)values('"+ service_name + "','" + s_no + "','" + duration + "')");
            switch (service_category) {
                case "1": 
                stmt.execute("insert into ENGINE_SERVICES(s_no)values('"+ s_no + "')");  ;
                  break;
                case "2": 
                stmt.execute("insert into EXHAUST_SERVICES(s_no)values('"+ s_no + "')");  ;
                break;
                case "3": 
                stmt.execute("insert into ELECTRICAL_SERVICES(s_no)values('"+ s_no + "')");  ;
                break;
                case "4": 
                stmt.execute("insert into TRANSMISSION_SERVICES(s_no)values('"+ s_no + "')");  ;
                break;
                case "5": 
                stmt.execute("insert into TIRE_SERVICES(s_no)values('"+ s_no + "')");  ;
                break;
                case "6": 
                stmt.execute("insert into H_AND_AC_SERVICES(s_no)values('"+ s_no + "')");  ;
                break;
              }
              System.out.println("---Service Added---");
              adminOptions();
            }
            catch(SQLException e)
            {
                System.out.println("--->FAILED: " + e);
            }
                break;
            case "2":
                adminOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                adminAddNewService();
                break;
        }
    }
}

class Customer
{
    public void customerOptions(int c_id, String sc_id) throws SQLException
    {
        Home home = new Home();
        Scanner customer_input = new Scanner(System.in);
        //System.out.println("Customer ID: " + c_id + "\nStore ID: " + sc_id);

        System.out.println("\n1.  View and Update Profile");
        System.out.println("2.  View and Schedule Service");
        System.out.println("3.  Invoices");
        System.out.println("4.  Logout");

        System.out.print("\nEnter your choice here: ");

        String customer_input_value = customer_input.nextLine();
        switch(customer_input_value)
        {
            case "1":
                customerProfile(c_id, sc_id);
                break;
            case "2":
                viewScheduleService(c_id, sc_id);
                break;
            case "3":
                break;
            case "4":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerOptions(c_id, sc_id);
                break;
        }
    }

    public void customerProfile(int c_id, String sc_id) throws SQLException
    {
        Scanner customer_profile_input = new Scanner(System.in);

        System.out.println("\n1.  View Profile");
        System.out.println("2.  Add Car");
        System.out.println("3.  Delete Car");
        System.out.println("4.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String customer_profile_input_value = customer_profile_input.nextLine();
        switch(customer_profile_input_value)
        {
            case "1":
                customerViewProfile(c_id, sc_id);
                break;
            case "2":
                customerAddNewCar(c_id, sc_id);
                break;
            case "3":
                customerDeleteCar(c_id, sc_id);
                break;
            case "4":
                customerOptions(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerProfile(c_id, sc_id);
                break;
        }
    }

    public void customerViewProfile(int c_id, String sc_id) throws SQLException
    {       

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT DISTINCT C.c_name, C.address, C.email_address, C.phone_number, V.year, V.vin, V.manufacturer, V.current_mileage FROM CUSTOMER C, VEHICLE_OWNED VO, VEHICLE V WHERE '"+ c_id +"'= C.c_id AND '"+ sc_id +"' = C.sc_id AND C.c_id = VO.c_id AND V.vin = VO.vin");
        rs.next();
        System.out.println("\n-----Your Profile Details-----"); 
        System.out.println("\nID: " + c_id);       
        System.out.println("Name: " + rs.getString("c_name"));        
        System.out.println("Address: "+ rs.getString("address"));     
        System.out.println("Email Address: "+ rs.getString("email_address"));     
        System.out.println("Phone Number: "+ rs.getInt("phone_number"));
        //rs.close();
        System.out.println("\n-----Your Cars-----");
        int i = 1;
        while(rs.next())
        {   
            System.out.println("Car " + i + ": ");
            System.out.println("Vehicle ID: " + rs.getString("vin"));  
            System.out.println("Manufacturer: " + rs.getString("manufacturer"));  
            System.out.println("Mileage: " + rs.getString("current_mileage"));
            System.out.println("Year: " + rs.getString("year"));  
            i++;
        }

        System.out.println("\n1.  Go Back");
        Scanner customer_view_profile_input = new Scanner(System.in);

        String customer_view_profile_input_value = customer_view_profile_input.nextLine();
        switch(customer_view_profile_input_value)
        {
            case "1":
                customerProfile(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerViewProfile(c_id, sc_id);
                break;
        }
    }

    public void customerAddNewCar(int c_id, String sc_id) throws SQLException
    {
        Scanner customer_add_car_input = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        System.out.print("\nVIN number: ");
        String vin_number = customer_add_car_input.nextLine();
        System.out.print("Car Manufacturer Name: ");
        String manufacturer_name = customer_add_car_input.nextLine();
        System.out.print("Current Mileage: ");
        int mileage = Integer.parseInt(customer_add_car_input.nextLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(customer_add_car_input.nextLine());
        System.out.println();

        System.out.println("1.  Save Information");
        System.out.println("2.  Cancel");

        System.out.print("\nEnter your choice here: ");

        String customer_add_car_input_value = customer_add_car_input.nextLine();
        switch(customer_add_car_input_value)
        {
            case "1":

                try{

                    String sql1= "INSERT INTO VEHICLE VALUES ('"+vin_number+"', '"+manufacturer_name+"', '"+mileage+"', '"+year+"')";
                    stmt.executeQuery(sql1);

                    String sql2= "INSERT INTO VEHICLE_OWNED(vin, sc_id, c_id) VALUES ('"+vin_number+"', '"+sc_id+"', '"+c_id+"')";
                    stmt.executeQuery(sql2);

                    ResultSet rs =  stmt.executeQuery("SELECT COUNT(*) FROM MODEL WHERE model_name = '"+ manufacturer_name +"'");

                    rs.next();
                    if(rs.getInt("COUNT(*)") == 0)
                    {
                        String sql3= "INSERT INTO MODEL(model_name) VALUES ('"+manufacturer_name+"')";
                        stmt.executeQuery(sql3);
                    }

                    System.out.println("---Vehicle Added---");
                    customerProfile(c_id, sc_id);

                }
                catch(SQLException e)
                {
                    System.out.println("--->FAILED: " + e);
                }

                break;
            case "2":
                customerProfile(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerAddNewCar(c_id, sc_id);
                break;
        }
    }

    public void customerDeleteCar(int c_id, String sc_id) throws SQLException
    {

        Scanner customer_delete_car_input = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM CUSTOMER C, VEHICLE_OWNED VO, VEHICLE V WHERE '"+ c_id +"'= C.c_id AND '"+ sc_id +"' = C.sc_id AND C.c_id = VO.c_id AND V.vin = VO.vin");
        rs2.next();
        String[] vin_array = new String[rs2.getInt("COUNT(*)")];
        String[] model_array = new String[rs2.getInt("COUNT(*)")];
        rs2.close();

        ResultSet rs = stmt.executeQuery("SELECT DISTINCT V.vin, V.manufacturer, V.current_mileage, V.year FROM CUSTOMER C, VEHICLE_OWNED VO, VEHICLE V WHERE '"+ c_id +"'= C.c_id AND '"+ sc_id +"' = C.sc_id AND C.c_id = VO.c_id AND V.vin = VO.vin");
        System.out.println("\n-----Your Cars-----");
        
        int i = 1;
        
        while(rs.next())
        {   
            System.out.println("Car " + i + ": ");
            vin_array[i-1] = rs.getString("vin");
            System.out.println("Vehicle ID: " + rs.getString("vin"));  
            System.out.println("Manufacturer: " + rs.getString("manufacturer")); 
            model_array[i-1] = rs.getString("manufacturer");
            System.out.println("Mileage: " + rs.getString("current_mileage"));
            System.out.println("Year: " + rs.getInt("year")); 
            System.out.println("\n"); 
            i++;
        }
        rs.close();

        System.out.print("\nEnter your choice to delete vehicle: ");
        String delete_value = customer_delete_car_input.nextLine();

        System.out.println("\n1.  Select the car to delete");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");
        String admin_add_delete_car_input_value = customer_delete_car_input.nextLine();
        String delete_vin = vin_array[Integer.parseInt(delete_value)-1];
        String model_name = model_array[Integer.parseInt(delete_value)-1];

        switch(admin_add_delete_car_input_value)
        {
            case "1":

                try{
                    String sql1= "DELETE FROM VEHICLE V WHERE V.vin = '"+ delete_vin +"'";
                    //(SELECT V2.vin FROM VEHICLE V2, CUSTOMER C, VEHICLE_OWNED VO WHERE  '"+ c_id +"'= C.c_id AND '"+ sc_id +"' = C.sc_id AND C.c_id = VO.c_id AND C.sc_id = VO.sc_id AND VO.vin = V.vin AND '"+ delete_vin +"'=V.vin)";
                    stmt.executeQuery(sql1);
    
                    String sql2= "DELETE FROM VEHICLE_OWNED VO WHERE VO.vin = '"+ delete_vin +"'";
                    //(SELECT V2.vin FROM VEHICLE V2, CUSTOMER C, VEHICLE_OWNED VO WHERE '"+ c_id +"'= C.c_id AND '"+ sc_id +"' = C.sc_id AND C.c_id = VO.c_id AND C.sc_id = VO.sc_id AND VO.vin = V.vin AND '"+ delete_vin +"'=V.vin)";
                    stmt.executeQuery(sql2);
    
                    ResultSet rs3 =  stmt.executeQuery("SELECT COUNT(*) FROM VEHICLE WHERE manufacturer = '"+ model_name +"' ");
                    rs3.next();
                    if(rs3.getInt("COUNT(*)") == 0)
                    {
                        String sql3= "DELETE FROM MODEL WHERE model_name = '"+ model_name+"'";
                        stmt.executeQuery(sql3);
                    }
                    System.out.println("---Car deleted sucessfully---");
                }
                catch(SQLException e)
                {
                    System.out.println("---> FAILED: " + e);
                }
                

                break;
            case "2":
                customerProfile(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerDeleteCar(c_id, sc_id);
                break;
        }
    }

    public void viewScheduleService(int c_id, String sc_id) throws SQLException
    {
        Scanner customer_view_schedule_service_input = new Scanner(System.in);

        System.out.println("\n1.  View Service History");
        System.out.println("2.  Schedule Service");
        System.out.println("3.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String customer_view_schedule_service_input_value = customer_view_schedule_service_input.nextLine();
        switch(customer_view_schedule_service_input_value)
        {
            case "1":
                viewServiceHistory(c_id, sc_id);
                break;
            case "2":
                customerScheduleService(c_id, sc_id);
                break;
            case "3":
                customerOptions(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewScheduleService(c_id, sc_id);
                break;
        }
    }

    public void viewServiceHistory(int c_id, String sc_id) throws SQLException
    {
        Scanner customer_view_service_input = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        

        System.out.print("\n1.  Enter VIN Number of Car");
        String vin = customer_view_service_input.nextLine();
//------------------SHOW HISTORY---------------------
        System.out.println("1.  Show History");
        System.out.println("2.  Go Back");
        System.out.print("\nEnter your choice here: ");
       
        String customer_view_service_input_value = customer_view_service_input.nextLine();

        switch(customer_view_service_input_value)
        {
            case "1":
                break;
            case "2":
                viewScheduleService(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewServiceHistory(c_id, sc_id);
                break;
        }
    }

    public void customerScheduleService(int c_id, String sc_id) throws SQLException
    {
        Scanner customer_schedule_service_input = new Scanner(System.in);

        System.out.print("\n1.  Enter VIN Number of Car");
        String vin = customer_schedule_service_input.nextLine();
        System.out.print("\n1.  Enter Current Mileage of Car");
        String mileage = customer_schedule_service_input.nextLine();
        System.out.println();
        System.out.println("\n1.  Add Schedule Maintenance");
        System.out.println("2.  Add Schedule Repair");
        System.out.println("3.  View Cart and select Schedule Time");
        System.out.println("4.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_schedule_service_input_value = customer_schedule_service_input.nextLine();

        switch(customer_schedule_service_input_value)
        {
            case "1":
                customerScheduleMaintenance(c_id, sc_id,vin);
                break;
            case "2":
                customerScheduleRepair(c_id, sc_id,vin);
                break;
            case "3":
                customerViewCart(c_id, sc_id,vin);
                break;   
            case "4":
                viewScheduleService(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleService(c_id, sc_id);
                break;
        }
    }

    public void customerScheduleMaintenance(int c_id, String sc_id,String vin) throws SQLException
    {
        System.out.println("\n1.  These are the list of services you are eligible for:");
        //--Display a message with the service schedule the customer is eligible for (A, B, or C) and the cost.

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        

        ResultSet rs = stmt.executeQuery("select LAST_SCHEDULED_MAINTENANCE_NAME from VEHICLE_LAST_SERVICED WHERE vin='" + vin + "'");
        rs.next();
        String last_schedule = rs.getString("LAST_SCHEDULED_MAINTENANCE_NAME");
        rs.close();
        String nextSchedule = "";

        if(last_schedule.equals("A")){
            nextSchedule = "B";
            System.out.println("\n You are eligible for SCHEDULE B");
        }else if(last_schedule.equals("B")){
            nextSchedule = "C";
            System.out.println("\n You are eligible for SCHEDULE C");
        }else{
            nextSchedule = "A";
            System.out.println("\n You are eligible for SCHEDULE A");
        } 



        Scanner customer_schedule_maintenance_input = new Scanner(System.in);

        System.out.println("\n1. Accept");
        System.out.println("2.  Decline and go back");
        System.out.print("\nEnter your choice here: ");

        String customer_schedule_maintenance_input_value = customer_schedule_maintenance_input.nextLine();

        switch(customer_schedule_maintenance_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+nextSchedule+"','"+"MAINTENANCE"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                }
                break;
            case "2":
            customerScheduleService(c_id, sc_id);
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleMaintenance(c_id, sc_id,vin);
                break;
        }
    }

    public void customerScheduleRepair(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
        //System.out.println("Customer ID: " + c_id + "\nStore ID: " + sc_id);

        System.out.println("\n1.  Engine Services");
        System.out.println("2.  Exhaust Services");
        System.out.println("3.  Electrical Services");
        System.out.println("4.  Transmission Services");
        System.out.println("5.  Tire Services");
        System.out.println("6.  Heating and AC Services");
        System.out.println("7.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();

        switch(customer_schedule_repair_input_value)
        {
            case "1":
                engineServices(c_id, sc_id, vin);
                break;
            case "2":
               exhaustServices(c_id, sc_id, vin);
                break;
            case "3":
                electricalServices(c_id, sc_id, vin);
                break;
            case "4":
                transmissionServices(c_id, sc_id, vin);
                break;
            case "5":
                tireServices(c_id, sc_id, vin);
                break;
            case "6":
                heatingServices(c_id, sc_id, vin);
                break;
            case "7":
                customerScheduleService(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id,vin);
                break;
        }
    }

    public void engineServices(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
       
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        HashMap<String, String> services = new HashMap<String, String>();
        ResultSet rs = stmt.executeQuery("SELECT R.SERVICE_NAME FROM REPAIR R,ENGINE_SERVICES E WHERE R.S_NO=E.S_NO");
        int i = 1;
        while(rs.next()){
            services.put(String.valueOf(i),rs.getString("SERVICE_NAME"));
            System.out.println("\n '"+i+"'.  '"+rs.getString("SERVICE_NAME")+"'\n");
            i++;
        }
        
        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();

        System.out.println(customer_schedule_repair_input_value);

        String service_name = services.get(customer_schedule_repair_input_value);
        System.out.println("\n You sure you want to add '"+service_name+"'");
        Scanner customer_repair_input = new Scanner(System.in);
        System.out.println("\n1.Yes");
        System.out.println("2.  No");
        String customer_repair_input_value = customer_repair_input.nextLine();

        
        

        switch(customer_repair_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+service_name+"','"+"REPAIR"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                } 
                break;
            case "2":
               customerScheduleRepair(c_id, sc_id, vin);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                //customerScheduleRepair(c_id, sc_id);
                break;
        }
    }

    public void exhaustServices(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
       
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        HashMap<String, String> services = new HashMap<String, String>();
        ResultSet rs = stmt.executeQuery("SELECT R.SERVICE_NAME FROM REPAIR R,EXHAUST_SERVICES E WHERE R.S_NO=E.S_NO");
        int i = 1;
        while(rs.next()){
            services.put("'"+i+"'",rs.getString("SERVICE_NAME"));
            System.out.println("\n '"+i+"'.  '"+rs.getString("SERVICE_NAME")+"'");
        }
        
        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();



        String service_name = services.get(customer_schedule_repair_input_value);
        System.out.println("\n You sure you want to add '"+service_name+"'");
        Scanner customer_repair_input = new Scanner(System.in);
        System.out.println("\n1.Yes");
        System.out.println("2.  No");
        String customer_repair_input_value = customer_repair_input.nextLine();

        
        

        switch(customer_repair_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+service_name+"','"+"REPAIR"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                } 
                break;
            case "2":
                customerScheduleRepair(c_id, sc_id, vin);
               // home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                //customerScheduleRepair(c_id, sc_id);
                break;
        }
    }
    
    public void electricalServices(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
       
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        HashMap<String, String> services = new HashMap<String, String>();
        ResultSet rs = stmt.executeQuery("SELECT R.SERVICE_NAME FROM REPAIR R,ELECTRICAL_SERVICES E WHERE R.S_NO=E.S_NO");
        int i = 1;
        while(rs.next()){
            services.put("'"+i+"'",rs.getString("SERVICE_NAME"));
            System.out.println("\n '"+i+"'.  '"+rs.getString("SERVICE_NAME")+"'");
        }
        
        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();



        String service_name = services.get(customer_schedule_repair_input_value);
        System.out.println("\n You sure you want to add '"+service_name+"'");
        Scanner customer_repair_input = new Scanner(System.in);
        System.out.println("\n1.Yes");
        System.out.println("2.  No");
        String customer_repair_input_value = customer_repair_input.nextLine();

        
        

        switch(customer_repair_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+service_name+"','"+"REPAIR"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                } 
                break;
            case "2":
               // home.customerOptions();
                customerScheduleRepair(c_id, sc_id, vin);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                //customerScheduleRepair(c_id, sc_id);
                break;
        }
    }
    
    public void transmissionServices(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
       
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        HashMap<String, String> services = new HashMap<String, String>();
        ResultSet rs = stmt.executeQuery("SELECT R.SERVICE_NAME FROM REPAIR R,TRANSMISSION_SERVICES E WHERE R.S_NO=E.S_NO");
        int i = 1;
        while(rs.next()){
            services.put("'"+i+"'",rs.getString("SERVICE_NAME"));
            System.out.println("\n '"+i+"'.  '"+rs.getString("SERVICE_NAME")+"'");
        }
        
        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();



        String service_name = services.get(customer_schedule_repair_input_value);
        System.out.println("\n You sure you want to add '"+service_name+"'");
        Scanner customer_repair_input = new Scanner(System.in);
        System.out.println("\n1.Yes");
        System.out.println("2.  No");
        String customer_repair_input_value = customer_repair_input.nextLine();

        
        

        switch(customer_repair_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+service_name+"','"+"REPAIR"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                } 
                break;
            case "2":
               // home.customerOptions();
                customerScheduleRepair(c_id, sc_id, vin);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                //customerScheduleRepair(c_id, sc_id);
                break;
        }
    }
    
    public void tireServices(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
       
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        HashMap<String, String> services = new HashMap<String, String>();
        ResultSet rs = stmt.executeQuery("SELECT R.SERVICE_NAME FROM REPAIR R,TIRE_SERVICES E WHERE R.S_NO=E.S_NO");
        int i = 1;
        while(rs.next()){
            services.put("'"+i+"'",rs.getString("SERVICE_NAME"));
            System.out.println("\n '"+i+"'.  '"+rs.getString("SERVICE_NAME")+"'");
        }
        
        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();



        String service_name = services.get(customer_schedule_repair_input_value);
        System.out.println("\n You sure you want to add '"+service_name+"'");
        Scanner customer_repair_input = new Scanner(System.in);
        System.out.println("\n1.Yes");
        System.out.println("2.  No");
        String customer_repair_input_value = customer_repair_input.nextLine();

        
        

        switch(customer_repair_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+service_name+"','"+"REPAIR"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                } 
                break;
            case "2":
               // home.customerOptions();
                customerScheduleRepair(c_id, sc_id, vin);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                //customerScheduleRepair(c_id, sc_id);
                break;
        }
    }
    
    public void heatingServices(int c_id, String sc_id, String vin) throws SQLException
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);
       
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        HashMap<String, String> services = new HashMap<String, String>();
        ResultSet rs = stmt.executeQuery("SELECT R.SERVICE_NAME FROM REPAIR R,H_AND_AC_SERVICES E WHERE R.S_NO=E.S_NO");
        int i = 1;
        while(rs.next()){
            services.put("'"+i+"'",rs.getString("SERVICE_NAME"));
            System.out.println("\n '"+i+"'.  '"+rs.getString("SERVICE_NAME")+"'");
        }
        
        String customer_schedule_repair_input_value = customer_schedule_repair_input.nextLine();



        String service_name = services.get(customer_schedule_repair_input_value);
        System.out.println("\n You sure you want to add '"+service_name+"'");
        Scanner customer_repair_input = new Scanner(System.in);
        System.out.println("\n1.Yes");
        System.out.println("2.  No");
        String customer_repair_input_value = customer_repair_input.nextLine();

        
        

        switch(customer_repair_input_value)
        {
            case "1":
                // add to cart
                try{
                    stmt.execute("INSERT INTO CART(SERVICE_NAME,SERVICE_TYPE,C_ID,SC_ID,VIN) VALUES('"+service_name+"','"+"REPAIR"+"','"+c_id+"','"+sc_id+"','"+vin+"')");
                    System.out.println("---->ADDED TO CART<----");
                    customerScheduleService(c_id, sc_id);
                }catch(SQLException e){
                    System.out.print(e);
                } 
                break;
            case "2":
                customerScheduleRepair(c_id, sc_id, vin);
               // home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                //customerScheduleRepair(c_id, sc_id);
                break;
        }
    }
    
    public void customerViewCart(int c_id, String sc_id,String vin) throws SQLException
    { 
        System.out.println("\n1.  These are the list of services in your cart. Do you wish to proceed to checkout?");
        //--list of services in cart
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT SERVICE_NAME FROM CART WHERE vin='"+vin+"' AND c_id='"+c_id+"' AND sc_id='"+sc_id+"'");
        while(rs.next()){
            System.out.println(rs.getString("SERVICE_NAME"));
        }

        Scanner customer_view_cart_input = new Scanner(System.in);

        System.out.println("\n1.  Proceed with Scheduling");
        System.out.println("2.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_view_cart_input_value = customer_view_cart_input.nextLine();

        switch(customer_view_cart_input_value)
        {
            case "1":
                // home.customerOptions();
                break;
            case "2":
                customerScheduleService(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerViewCart(c_id, sc_id,vin);
                break;
        }
    }

    public void customerScheduleServicesCart(int c_id, String sc_id)
    {
      //Display possible service times that accommodate all services in the cart within 30 days.

    }

    public void customerInvoices(int c_id, String sc_id) throws SQLException
    {
        //Display the list of customer’s invoices
        Scanner customer_invoice_input = new Scanner(System.in);

        System.out.println("\n1.  View Invoice Details");
        System.out.println("2.  Pay Invoice");
        System.out.println("3.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_invoice_input_value = customer_invoice_input.nextLine();

        switch(customer_invoice_input_value)
        {
            case "1":
                 customerViewInvoice(c_id, sc_id);
                break;
            case "2":
                //home.customerScheduleRepair();
                break;
            case "3":
                //home.customerViewCart();
                break;   
            default:
                System.out.println("\n\nInvalid Input");
                customerOptions(c_id, sc_id);
                break;
        }
    }

    public void customerViewInvoice(int c_id, String sc_id) throws SQLException
    {
        System.out.println("Enter invoice id: ");
        Scanner customer_invoice_id_input = new Scanner(System.in);
        String invoice_id = customer_invoice_id_input.nextLine();

        System.out.println("\n1.  View Invoice ");
        System.out.println("2.  Go Back ");
        System.out.print("\nEnter your choice here: ");

        Scanner customer_invoice_id_input2 = new Scanner(System.in);
        String customer_invoice_input_value2 = customer_invoice_id_input2.nextLine();

        switch(customer_invoice_input_value2)
        {
            case "1":
                // A. Invoice ID
                // B. Customer ID
                // C. VIN
                // D. Service Date
                // E. Service(s) IDs
                // F. Service(s)
                // Type(s)
                // G. Invoice Status
                // (paid/unpaid)
                // H. Mechanic’s
                // name
                // I. Cost for each
                // service
                // J. Total Cost
                break;
            case "2":
                customerInvoices(c_id, sc_id);
                break; 
            default:
                System.out.println("\n\nInvalid Input");
                customerInvoices(c_id, sc_id);
                break;
        }
    }
    
    public void customerPayInvoice(int c_id, String sc_id) throws SQLException
    {
        System.out.println("Enter invoice id: ");
        Scanner customer_invoice_id_input_3 = new Scanner(System.in);
        String invoice_id_value = customer_invoice_id_input_3.nextLine();

        System.out.println("\n1.  Pay Invoice ");
        System.out.println("2.  Go Back ");
        System.out.print("\nEnter your choice here: ");

        Scanner customer_invoice_id_input4 = new Scanner(System.in);
        String customer_invoice_input_value4 = customer_invoice_id_input4.nextLine();

        switch(customer_invoice_input_value4)
        {
            case "1":
                //pay
                break;
            case "2":
                customerInvoices(c_id, sc_id);
                break; 
            default:
                System.out.println("\n\nInvalid Input");
                customerInvoices(c_id, sc_id);
                break;
        }
    }

}

class Receptionist
{
    public void receptionistOptions(int receptionist_id, String sc_id) throws SQLException
    {
        Home home = new Home();
        Scanner receptionist_input = new Scanner(System.in);

        System.out.println("\n1.  Add New Customer Profile");
        System.out.println("2.  Find Customers with Pending Invoices");
        System.out.println("3.  Logout");

        System.out.print("\nEnter your choice here: ");

        String receptionist_input_value = receptionist_input.nextLine();
        switch(receptionist_input_value)
        {
            case "1":
                addNewCustomerProfile(receptionist_id, sc_id);
                break;
            case "2":
                findCustomerWithPendingInvoice(receptionist_id, sc_id);
                break;
            case "3":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                receptionistOptions(receptionist_id, sc_id);
                break;
        }
    }

    public void addNewCustomerProfile(int receptionist_id, String sc_id) throws SQLException
    {
        Scanner add_new_customer_profile = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(c_id) FROM CUSTOMER");
        rs.next();
        int cid_counter = rs.getInt("MAX(c_id)") + 1;
        rs.close();

        System.out.print("\nName: ");
        String c_name = add_new_customer_profile.nextLine();
        System.out.print("Last Name: ");
        String c_lname = add_new_customer_profile.nextLine();
        System.out.print("Address: ");
        String address = add_new_customer_profile.nextLine();
        System.out.print("Email Address: ");
        String email_address = add_new_customer_profile.nextLine();
        System.out.print("Phone Number: ");
        String phone_number = add_new_customer_profile.nextLine();
        System.out.print("Username: ");
        String username = add_new_customer_profile.nextLine();
        System.out.print("VIN Number: ");
        String vin_number = add_new_customer_profile.nextLine();
        System.out.print("Car Manufacturer: ");
        String car_manufacturer = add_new_customer_profile.nextLine();
        System.out.print("Car Mileage: ");
        String car_mileage = add_new_customer_profile.nextLine();
        System.out.println();

        try
        {
            stmt.execute("insert into CUSTOMER(c_id, c_name, address, email_address, phone_number, username, password, sc_id) values('"+ cid_counter +"', '"+ c_name + "','" + address + "','" + email_address + "','" + phone_number + "','" + username + "','" + c_lname + "', '"+ sc_id +"')");
            stmt.execute("insert into VEHICLE(vin, manufacturer, current_mileage) values('"+ vin_number + "','" + car_manufacturer + "', '"+ car_mileage +"')");    
            stmt.execute("insert into VEHICLE_OWNED(vin, sc_id, c_id) values('"+ vin_number + "','" + sc_id + "','" + cid_counter + "')");
            
            ResultSet rs1 =  stmt.executeQuery("SELECT COUNT(*) FROM MODEL WHERE model_name = '"+ car_manufacturer +"'");

            rs1.next();
            if(rs1.getInt("COUNT(*)") == 0)
            {
                String sql= "INSERT INTO MODEL(model_name) VALUES ('"+car_manufacturer+"')";
                stmt.executeQuery(sql);
            }

            
            System.out.println("---Customer Added---");
            receptionistOptions(receptionist_id, sc_id);
        }
        catch(SQLException e)
        {
            System.out.println("---> FAILED: " + e);
        }

        System.out.println("1.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String add_new_customer_profile_value = add_new_customer_profile.nextLine();
        switch(add_new_customer_profile_value)
        {
            case "1":
                receptionistOptions(receptionist_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                addNewCustomerProfile(receptionist_id, sc_id);
                break;
        }
    }

    public void findCustomerWithPendingInvoice(int receptionist_id, String sc_id) throws SQLException
    {
        Scanner find_customer_with_pending_invoice = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        System.out.print("\nCustomer ID: ");
        String customer_id = find_customer_with_pending_invoice.nextLine();
        System.out.print("Customer Name: ");
        String customer_name = find_customer_with_pending_invoice.nextLine();
        System.out.print("Invoice ID: ");
        String invoice_id = find_customer_with_pending_invoice.nextLine();
        System.out.print("Invoice Date: ");
        String invoice_date = find_customer_with_pending_invoice.nextLine();
        System.out.print("Amount: ");
        String amount = find_customer_with_pending_invoice.nextLine();
        System.out.println();

        try
        {
            ResultSet rs = stmt.executeQuery("SELECT C.c_id, C.c_name, SE.invoice_id, SE.invoice_date, SE.amount_charged, SE.total_amount_paid, SE.sc_id FROM CUSTOMER C, SERVICE_EVENT SE WHERE C.c_id = SE.c_id AND C.sc_id = SE.sc_id;");
            System.out.println("---Invoice Details---");
            receptionistOptions(receptionist_id, sc_id);
        }
        catch(SQLException e)
        {
            System.out.println("---> FAILED: " + e);
        }

        System.out.println("1.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String find_customer_with_pending_invoice_value = find_customer_with_pending_invoice.nextLine();
        switch(find_customer_with_pending_invoice_value)
        {
            case "1":
                receptionistOptions(receptionist_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                findCustomerWithPendingInvoice(receptionist_id, sc_id);
                break;
        }
    }
}

class Manager
{ 
    public void managerOptions(int manager_id, String sc_id) throws SQLException
    {
        Home home = new Home();
       
        Scanner manager_input = new Scanner(System.in);

        System.out.println("\n1.  Setup Store");
        System.out.println("2.  Add New Employee");
        System.out.println("3.  Logout");

        System.out.print("\nEnter your choice here: ");


        //stmt.executeQuery("SELECT M.manger_id,M.sc_id WHERE from MANAGER where username = '"+  + "'")

        String manager_input_value = manager_input.nextLine();
        switch(manager_input_value)
        {
            case "1":
                managerSetUpStore(manager_id, sc_id);
                break;
            case "2":
                managerAddNewEmployees(manager_id, sc_id);
                break;
            case "3":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerOptions(manager_id, sc_id);
                break;
        }
    }

    public void managerSetUpStore(int manager_id, String sc_id) throws SQLException
    {
        Scanner manager_setup_store_input = new Scanner(System.in);

        System.out.println("\n1.  Add employees");
        System.out.println("2.  Setup operational hours");
        System.out.println("3.  Setup service prices");
        System.out.println("4.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_store_input_value = manager_setup_store_input.nextLine();
        switch(manager_setup_store_input_value)
        {
            case "1":
                managerAddEmployees(manager_id, sc_id);
                break;
            case "2":
                managerSetupOperationalHours(manager_id, sc_id);
                break;
            case "3":
                managerSetupServicePrices(manager_id, sc_id);
                break;
            case "4":
                managerOptions(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetUpStore(manager_id, sc_id);
                break;
        }
    }
    
    public void managerAddEmployees(int manager_id, String sc_id) throws SQLException
    {
        
        Scanner manager_add_employees_input = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(EMP_ID) FROM EMPLOYEE");
        int emp_counter = 0;
        rs.next();
        emp_counter = rs.getInt("MAX(EMP_ID)");
        rs.close();

        System.out.print("\nName: ");
        String name = manager_add_employees_input.nextLine();
        System.out.print("\nLast Name: ");
        String lastName = manager_add_employees_input.nextLine();
        System.out.print("Address: ");
        String address = manager_add_employees_input.nextLine();
        System.out.print("Email Address: ");
        String email_address = manager_add_employees_input.nextLine();
        System.out.print("Phone Number: ");
        String phone_number = manager_add_employees_input.nextLine();
        System.out.print("Role:(MECHANIC,RECEPTIONIST) ");
        String role = manager_add_employees_input.nextLine();
        System.out.print("Start Date(YYYY/MM/DD): ");
        String start_date = manager_add_employees_input.nextLine();
        System.out.print("Compensation: ");
        String compensation = manager_add_employees_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_add_employees_input_value = manager_add_employees_input.nextLine();
       
        switch(manager_add_employees_input_value)
        {
            case "1":
                int emp_id = emp_counter + 1;
                try{
                    String sql1 = "INSERT INTO EMPLOYEE (EMP_ID,EMP_NAME,SC_ID, EMP_EMAIL, EMP_ADDRESS, EMP_CONTACT, EMP_ROLE, EMP_STARTDATE, EMP_COMPENSATION)VALUES('"+ emp_id + "','"+ name + "','"+ sc_id +"','"+ email_address +"','"+ address +"','"+ phone_number +"','"+ role +"', TO_DATE('"+start_date+"', 'YYYY/MM/DD'),'"+ compensation +"')";
                    stmt.executeQuery(sql1);
                    String username = sc_id+emp_id;
                    String password = lastName;
                    String sql5 = "INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('"+ emp_id + "','"+ sc_id + "', '"+ role + "','"+ username + "','"+ password + "')";
                    stmt.executeQuery(sql5);
                    System.out.println("-----"+ role +" added-----");
                    managerOptions(manager_id, sc_id);
                 }
                catch(SQLException e)
                {
                    System.out.println("---> FAILED: " + e);
                }
                break;
            case "2":
                managerSetUpStore(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerAddEmployees(manager_id, sc_id);
                break;
        }
    }

    public void managerSetupOperationalHours(int manager_id, String sc_id) throws SQLException
    {
        Scanner manager_setup_operational_hours_input = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        System.out.print("\nOperational on Saturdays?:(YES/NO) ");
        String operational_days = manager_setup_operational_hours_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_operational_hours_input_value = manager_setup_operational_hours_input.nextLine();
        switch(manager_setup_operational_hours_input_value)
        {
            case "1":
            if(operational_days.equals("YES")) stmt.execute("UPDATE SERVICE_CENTER SET OPENING_TIME = '"+ "9:00 AM" + "', CLOSING_TIME = '"+ "1:00 PM" + "', OPEN_ON_SATURDAY = '"+ "Y" + "' WHERE sc_id = '"+ sc_id + "' ");
            if(operational_days.equals("NO")) stmt.execute("UPDATE SERVICE_CENTER SET OPENING_TIME = '"+ "8:00 AM" + "', CLOSING_TIME = '"+ "8:00 PM" + "', OPEN_ON_SATURDAY = '"+ "N" + "' WHERE sc_id = '"+ sc_id + "' ");
            else {
                System.out.println("Invalid input");
            }
                break;
            case "2":
                managerSetUpStore(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupOperationalHours(manager_id, sc_id);
                break;
        }
    }

    public void managerSetupServicePrices(int manager_id, String sc_id) throws SQLException
    {
        Scanner manager_setup_service_prices_input = new Scanner(System.in);

        System.out.println("\n1.  Setup maintenance service prices");
        System.out.println("2.  Setup repair service prices");
        System.out.println("3.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_service_prices_input_value = manager_setup_service_prices_input.nextLine();
        switch(manager_setup_service_prices_input_value)
        {
            case "1":
                managerSetupMaintenanceServicePrices(manager_id, sc_id);
                break;
            case "2":
                managerSetupRepairServicePrices(manager_id, sc_id);
                break;
            case "3":
                managerSetUpStore(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupServicePrices(manager_id, sc_id);
                break;
        }
    }

    public void managerSetupMaintenanceServicePrices(int manager_id, String sc_id) throws SQLException
    {
        Scanner manager_setup_maintenance_service_prices_input = new Scanner(System.in);
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        int i = 0;

        ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM MODEL");

        rs2.next();
        String schedule_a_price[] = new String[rs2.getInt("COUNT(*)")];
        String schedule_b_price[] = new String[rs2.getInt("COUNT(*)")];
        String schedule_c_price[] = new String[rs2.getInt("COUNT(*)")];
        String model[] = new String[rs2.getInt("COUNT(*)")];
        rs2.close();

        ResultSet rs1 = stmt.executeQuery("SELECT MODEL_NAME FROM MODEL");

        while(rs1.next()){
            System.out.print("\nSchedule A price for " + rs1.getString("model_name") +  ": ");
            schedule_a_price[i] = manager_setup_maintenance_service_prices_input.nextLine();
            System.out.print("\nSchedule B price for " + rs1.getString("model_name") +  ": ");
            schedule_b_price[i] = manager_setup_maintenance_service_prices_input.nextLine();
            System.out.print("\nSchedule C price for " + rs1.getString("model_name") +  ": ");
            schedule_c_price[i] = manager_setup_maintenance_service_prices_input.nextLine();
            System.out.print("\n");
            model[i] = rs1.getString("model_name");
            i++;
        }

        System.out.println("\n1.  Setup Prices");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_maintenance_service_prices_input_value = manager_setup_maintenance_service_prices_input.nextLine();
        switch(manager_setup_maintenance_service_prices_input_value)
        {
            case "1":
            try{
                for(int m=0; m<schedule_a_price.length; m++){

                    ResultSet rs = stmt.executeQuery("SELECT S_NO FROM MAINTENANCE_DURATION WHERE SCHEDULE_NAME = '"+ "A" + "'");
                    rs.next();
                    int s_no = rs.getInt("s_no");
                    rs.close();
                    stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ model[m] + "', '"+ schedule_a_price[m] + "','"+ s_no + "')");
                }
                for(int j=0; j<schedule_b_price.length; j++){
                    ResultSet rs = stmt.executeQuery("SELECT S_NO FROM MAINTENANCE_DURATION WHERE SCHEDULE_NAME = '"+ "B" + "'");
                    rs.next();
                    int s_no = rs.getInt("s_no");
                    rs.close();
                    stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ model[j] + "', '"+ schedule_b_price[j] + "','"+ s_no + "')");
                }
                for(int k=0; k<schedule_c_price.length; k++){
                    ResultSet rs = stmt.executeQuery("SELECT S_NO FROM MAINTENANCE_DURATION WHERE SCHEDULE_NAME = '"+ "C" + "'");
                    rs.next();
                    int s_no = rs.getInt("s_no");
                    rs.close();
                    stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ model[k] + "', '"+ schedule_c_price[k] + "','"+ s_no + "')");
                }

                System.out.println("---Prices Set Successfully---");

            }catch(SQLException e)
            {
                System.out.println("--->FAILED" + e);
            }
                
                break;
            case "2":
                managerSetupServicePrices(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupMaintenanceServicePrices(manager_id, sc_id);
                break;
        }
    }

    public void managerSetupRepairServicePrices(int manager_id, String sc_id) throws SQLException
    {
        Scanner manager_setup_repair_service_prices_input = new Scanner(System.in);
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM MODEL");
        rs2.next();
        int count = rs2.getInt("COUNT(*)");
        rs2.close();

        ResultSet rs1 = stmt.executeQuery("SELECT MODEL_NAME FROM MODEL");
        String models[] = new String[count];
        int i =0;
        while(rs1.next()){
            models[i] = rs1.getString("MODEL_NAME");
            i++;
        }
        
        ResultSet rs = stmt.executeQuery("SELECT SERVICE_NAME FROM REPAIR");
        
    
        Map<Integer, List<String>> repairServices = new HashMap<>();    
         int l=0;
         while(rs.next()){
            for(int k=0; k<models.length; k++){
                System.out.print("\'"+ rs.getString("service_name")+"'Price for'"+models[k]+"': ");
                List<String> model_price = new ArrayList<>();
                model_price.add(rs.getString("service_name"));
                model_price.add(models[k]);
                model_price.add(manager_setup_repair_service_prices_input.nextLine());
                repairServices.put(l,model_price);
                l++;
            }
            
        }
        
        
        System.out.println();
        
        System.out.println("\n1.  Setup Prices");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_repair_service_prices_input_value = manager_setup_repair_service_prices_input.nextLine();
        switch(manager_setup_repair_service_prices_input_value)
        {
            
            case "1":
            try{
            for (Map.Entry<Integer, List<String>> entry : repairServices.entrySet()) {
                List<String> ls = entry.getValue();
                ResultSet rs3 = stmt.executeQuery("SELECT S_NO FROM REPAIR WHERE SERVICE_NAME='"+ls.get(0)+"'");
                rs3.next();
                int s_no = rs3.getInt("s_no");
                System.out.println(sc_id.toString() + ls.get(1) +  s_no + ls.get(2));
                rs3.close();
                stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ ls.get(1) + "', '"+ Integer.parseInt(ls.get(2)) + "','"+ s_no + "')");
                
            }
            System.out.println("---Prices Set Successfully---");

            }catch(SQLException e)
            {
                System.out.println("--->FAILED" + e);
            }


                break;
            case "2":
                managerSetupServicePrices(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupRepairServicePrices(manager_id, sc_id);
                break;
        }
    }

    public void managerAddNewEmployees(int manager_id, String sc_id) throws SQLException
    {
        Scanner manager_add_new_employees_input = new Scanner(System.in);

        
        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(EMP_ID) FROM EMPLOYEE");
        int emp_counter = 0;
        rs.next();
        emp_counter = rs.getInt("MAX(EMP_ID)");
        rs.close();
        System.out.print("\nName: ");
        String name = manager_add_new_employees_input.nextLine();
        System.out.print("\nLast Name: ");
        String lastName = manager_add_new_employees_input.nextLine();
        System.out.print("Address: ");
        String address = manager_add_new_employees_input.nextLine();
        System.out.print("Email Address: ");
        String email_address = manager_add_new_employees_input.nextLine();
        System.out.print("Phone Number: ");
        String phone_number = manager_add_new_employees_input.nextLine();
        System.out.print("Role(MECHANIC/RECEPTIONIST): ");
        String role = manager_add_new_employees_input.nextLine();
        System.out.print("Start Date(YYYY/MM/DD): ");
        String start_date = manager_add_new_employees_input.nextLine();
        System.out.print("Compensation: ");
        String compensation = manager_add_new_employees_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_add_new_employees_input_value = manager_add_new_employees_input.nextLine();
        switch(manager_add_new_employees_input_value)
        {
            case "1":
            int emp_id = emp_counter + 1;
            try{
                String sql1 = "INSERT INTO EMPLOYEE (EMP_ID,EMP_NAME,SC_ID, EMP_EMAIL, EMP_ADDRESS, EMP_CONTACT, EMP_ROLE, EMP_STARTDATE, EMP_COMPENSATION)VALUES('"+ emp_id + "','"+ name + "','"+ sc_id +"','"+ email_address +"','"+ address +"','"+ phone_number +"','"+ role +"', TO_DATE('"+start_date+"', 'YYYY/MM/DD'),'"+ compensation +"')";
                stmt.executeQuery(sql1);
                String username = sc_id+emp_id;
                String password = lastName;
                String sql5 = "INSERT INTO EMPLOYEE_AUTH(EMP_ID,SC_ID,EMP_ROLE,USERNAME,PASSWORD) VALUES('"+ emp_id + "','"+ sc_id + "', '"+ role + "','"+ username + "','"+ password + "')";
                stmt.executeQuery(sql5);
                System.out.println("-----"+ role +" added-----");
                managerOptions(manager_id, sc_id);
            }
            catch(SQLException e)
            {
                System.out.println("---> FAILED: " + e);
            }
            
                break;
            case "2":
                managerOptions(manager_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerAddNewEmployees(manager_id, sc_id);
                break;
        }
    }

}

class Mechanic
{
    public void mechanicOptions(int mechanic_id, String sc_id) throws SQLException
    {
        Home home = new Home();
        Scanner mechanic_input = new Scanner(System.in);

        System.out.println("\n1.  View Schedule");
        System.out.println("2.  Request TimeOff");
        System.out.println("3.  Request Swap");
        System.out.println("4.  Accept/Reject Swap");
        System.out.println("5.  Logout");

        System.out.print("\nEnter your choice here: ");

        String mechanic_input_value = mechanic_input.nextLine();
        switch(mechanic_input_value)
        {
            case "1":
                viewScedule(mechanic_id,sc_id);
                break;
            case "2":
                requestTimeOff(mechanic_id,sc_id);
                break;
            case "3":
                requestSwap(mechanic_id,sc_id);
                break;
            case "4":
                AcceptRejectSwap(mechanic_id,sc_id);
                break;
            case "5":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                mechanicOptions(mechanic_id,sc_id);
                break;
        }
    }

    public void viewScedule(int mechanic_id, String sc_id) throws SQLException
    {
        Scanner view_schedule = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        int  i = 1;

       // String[] array = {"","",};
        HashMap<String, String[]> hashmap = new HashMap<>();
        hashmap.put("1", new String[] {"8:00", "9:00"});
        hashmap.put("2", new String[] {"9:00", "10:00"});
        hashmap.put("3", new String[] {"10:00", "11:00"});
        hashmap.put("4", new String[] {"11:00", "12:00"});
        hashmap.put("5", new String[] {"13:00", "14:00"});
        hashmap.put("6", new String[] {"14:00", "15:00"});
        hashmap.put("7", new String[] {"15:00", "16:00"});
        hashmap.put("8", new String[] {"16:00", "17:00"});
        hashmap.put("9", new String[] {"17:00", "18:00"});
        hashmap.put("10", new String[] {"18:00", "19:00"});
        hashmap.put("11", new String[] {"19:00", "20:00"});
        

        ResultSet rs = stmt.executeQuery("SELECT SS.START_TIME_SLOT, SS.END_TIME_SLOT FROM SCHEDULED_SERVICES SS WHERE '"+ mechanic_id +"' = SS.MECHANIC_ID");

        if(!rs.next())
            System.out.println("\n----> Currently, no any schedule assigned to you.");
        else
        {
            System.out.println("\n----- List of your time slots -----");
            do{

                System.out.println("\nSchedule " + i + ": ");
                System.out.println("Start Time: " + hashmap.get(rs.getString("start_time_slot"))[0]);
                System.out.println("End Time: " + hashmap.get(rs.getString("end_time_slot"))[0]);
                System.out.println("\n---------------------------");
                i++;

            }while(rs.next());
        }

        System.out.println("\n1.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String view_schedule_value = view_schedule.nextLine();
        switch(view_schedule_value)
        {
            case "1":
                mechanicOptions(mechanic_id,sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewScedule(mechanic_id,sc_id);
                break;
        }
    }

    public void requestTimeOff(int mechanic_id, String sc_id) throws SQLException
    {
        Scanner request_time_off = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT timeoff_request_id FROM REQUEST_TIME_OFF WHERE '"+ mechanic_id +"' = MECHANIC_ID");

        
        if(rs.next())
        {
            System.out.println("\n-----Your requested time slots-----");

            do
            {

                System.out.println("\nRequest ID: " + rs.getString("timeoff_request_id"));
                System.out.println("Status: Pending");
                System.out.println("\n-------------------");

            }while(rs.next());
            rs.close();
        }
        

        System.out.print("\nWeek(1 to 4): ");
        String week = request_time_off.nextLine();
        System.out.print("Day(1 to 7): ");
        String day = request_time_off.nextLine();
        System.out.print("Slot start time ID(1 to 11): ");
        String slot_start_time = request_time_off.nextLine();
        System.out.print("Slot end time ID(1 to 11): ");
        String slot_end_time = request_time_off.nextLine();
        System.out.println();

        if(Integer.parseInt(week)<5 && Integer.parseInt(day)<8 && Integer.parseInt(slot_start_time)<12 && Integer.parseInt(slot_end_time)<12)
        {
            int id_counter = 1;

            ResultSet rs1 = stmt.executeQuery("SELECT MAX(timeoff_request_id) FROM REQUEST_TIME_OFF");
            rs1.next();
    
            if(rs1.getString("MAX(timeoff_request_id)") != null)
                id_counter = Integer.parseInt(rs1.getString("MAX(timeoff_request_id)")) + 1;
            
            rs1.close();
    
            System.out.println("1.  Send the Request");
            System.out.println("2.  Go Back");
    
            System.out.print("\nEnter your choice here: ");
            String request_time_off_value = request_time_off.nextLine();
    
            switch(request_time_off_value)
            {
                case "1":
                    try
                    {
                        stmt.execute("INSERT INTO request_time_off(mechanic_id, sc_id, week, day, start_time, end_time, timeoff_request_id) VALUES('"+ mechanic_id + "','"+ sc_id + "','"+ week + "','"+ day + "','"+ slot_start_time + "','"+ slot_end_time + "', '"+ id_counter +"')");
                        System.out.println("-----Request Status-----");
                        System.out.println("\nRequest ID: " + id_counter );
                        System.out.println("Status: Sent");
                        
                        System.out.print("\n---> Send another request? (Y/N) ");
                        String another_request = request_time_off.nextLine();
    
                        if(another_request == "Y")
                            requestTimeOff(mechanic_id, sc_id);
                        else
                            mechanicOptions(mechanic_id, sc_id);
    
                    }
                    catch(SQLException e)
                    {
                        System.out.println("----> FAILED: " + e);
                    }
                    break;
                case "2":
                    mechanicOptions(mechanic_id,sc_id);
                    break;    
                default:
                    System.out.println("\n\nInvalid Input");
                    requestTimeOff(mechanic_id,sc_id);
                    break;
            }
        }
        else
        {
            System.out.println("----> ERROR: Invalid Input");
            requestTimeOff(mechanic_id, sc_id);
        }

       
    }

    public void requestSwap(int mechanic_id, String sc_id) throws SQLException
    {
        Scanner request_swap = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT request_id, status FROM REQUEST_SWAP WHERE '"+ mechanic_id +"' = MECHANIC_ID_1");

        
        if(rs.next())
        {
            System.out.println("\n-----Your already requested time slots-----");

            do
            {

                System.out.println("\nRequest ID: " + rs.getString("request_id"));
                System.out.println("Status: " + rs.getString("STATUS"));
                System.out.println("\n-------------------");

            }while(rs.next());
            rs.close();
        }

        System.out.print("\n---TimeSlot range to swap---");
        System.out.print("\nWeek(1 to 4): ");
        String week1 = request_swap.nextLine();
        System.out.print("Day(1 to 7): ");
        String day1 = request_swap.nextLine();
        System.out.print("Slot starting time ID(1 to 11): ");
        String slot_starting_time1 = request_swap.nextLine();
        System.out.print("Slot ending time ID(1 to 11): ");
        String slot_ending_time1 = request_swap.nextLine();

        ResultSet rs6 = stmt.executeQuery("SELECT week, day, start_time_slot, end_time_slot FROM SCHEDULED_SERVICES WHERE mechanic_id = '"+ mechanic_id +"' AND sc_id = '"+ sc_id +"'");
        rs6.next();
        String week = rs6.getString("week");
        String day = rs6.getString("day");
        String start_time_slot = rs6.getString("start_time_slot");
        String end_time_slot = rs6.getString("end_time_slot");
        if(week.equals(week1) || day.equals(day1) || start_time_slot.equals(slot_starting_time1) || end_time_slot.equals(slot_ending_time1))
        {
            System.out.println("\nYou don't have shift on your requested timing.\n-----> Please enter the right shift timing");
            requestSwap(mechanic_id, sc_id);
        }
        rs6.close();

        
        System.out.print("\n---Employee ID of Mechanic with whom you want to swap: ---");
        System.out.print("\nEmployee ID: ");
        String employee_id = request_swap.nextLine();

        ResultSet rs4 = stmt.executeQuery("SELECT COUNT(*) FROM EMPLOYEE E, SERVICE_CENTER SC WHERE E.emp_id = '"+ employee_id +"' AND SC.sc_id = '"+ sc_id +"'");
        rs4.next();
        if(rs4.getInt("COUNT(*)") != 1)
        {
            System.out.println("\nThis mechanic does not exists in your service center\n-----> Please enter the right employee id");
            System.out.print("\nEmployee ID: ");
            employee_id = request_swap.nextLine();
        }
        rs4.close();

        System.out.print("\n---Interested timeslot range: ---");
            // System.out.print("\nWeek(1 to 4): ");
            // String week2 = request_swap.nextLine();
            // System.out.print("Day(1 to 7): ");
            // String day2 = request_swap.nextLine();
            System.out.print("\nSlot starting time ID(1 to 11): ");
            String slot_starting_time2 = request_swap.nextLine();
            System.out.print("Slot ending time ID(1 to 11): ");
            String slot_ending_time2 = request_swap.nextLine();
            System.out.println();
        

        ResultSet rs5 = stmt.executeQuery("SELECT week, day, start_time_slot, end_time_slot FROM SCHEDULED_SERVICES WHERE mechanic_id = '"+ employee_id +"' AND sc_id = '"+ sc_id +"'");
        rs5.next();
        if(week.equals(week1) || day.equals(day1) || start_time_slot.equals(slot_starting_time2) || end_time_slot.equals(slot_ending_time2))
        {
            System.out.println("\nThis mechanic does not have shift on your requested timing.\n-----> Please enter the right employee id");
            System.out.print("\nEmployee ID: ");
            employee_id = request_swap.nextLine();
            System.out.print("\n---Interested timeslot range: ---");
            // System.out.print("\nWeek(1 to 4): ");
            // String week2 = request_swap.nextLine();
            // System.out.print("Day(1 to 7): ");
            // String day2 = request_swap.nextLine();
            System.out.print("\nSlot starting time ID(1 to 11): ");
            slot_starting_time2 = request_swap.nextLine();
            System.out.print("Slot ending time ID(1 to 11): ");
            slot_ending_time2 = request_swap.nextLine();
            System.out.println();
        }
        rs5.close();

        if(Integer.parseInt(week1)<5 && Integer.parseInt(day1)<8 && Integer.parseInt(slot_starting_time1)<12 && Integer.parseInt(slot_ending_time1)<12 && Integer.parseInt(slot_starting_time2)<12 && Integer.parseInt(slot_ending_time2)<12)
        {
            int id_counter = 1;

        ResultSet rs1 = stmt.executeQuery("SELECT MAX(request_id) FROM REQUEST_SWAP");
        rs1.next();

        if(rs1.getString("MAX(request_id)") != null)
            id_counter = Integer.parseInt(rs1.getString("MAX(request_id)")) + 1;
        
        rs1.close();

        String request_id = String.valueOf(id_counter);

        System.out.println("1.  Send the Request");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String request_swap_value = request_swap.nextLine();
        switch(request_swap_value)
        {
            case "1":

            try
            {

                stmt.execute("INSERT INTO request_swap(request_id, mechanic_id_1, sc_id, week_1, day_1, start_time_1, end_time_1, mechanic_id_2, start_time_2, end_time_2, status) VALUES('"+ request_id +"', '"+ mechanic_id +"','"+ sc_id +"','"+ week1+"','"+ day1 +"','"+ slot_starting_time1 +"','"+ slot_ending_time1 +"', '"+ employee_id +"', '"+ slot_starting_time2 +"', '"+ slot_ending_time2 +"', '"+ "PENDING" +"')");
                System.out.println("-----Request Status-----");
                System.out.println("\nRequest ID: " + id_counter);
                System.out.println("Status: Sent");
                
                System.out.print("\n---> Send another request? (Y/N) ");
                String another_request = request_swap.nextLine();

                if(another_request == "Y")
                    requestSwap(mechanic_id, sc_id);
                else
                    mechanicOptions(mechanic_id, sc_id);

            }
            catch(SQLException e)
            {
                System.out.println("----> FAILED: " + e);
            }

                break;
            case "2":
                mechanicOptions(mechanic_id,sc_id);
                break;    
            default:
                System.out.println("\n\nInvalid Input");
                requestSwap(mechanic_id,sc_id);
                break;
        }
        }
        else
        {
            System.out.println("----> ERROR: Invalid Input");
            requestSwap(mechanic_id, sc_id);
        }

        
    }

    public void AcceptRejectSwap(int mechanic_id, String sc_id) throws SQLException
    {
        Scanner accept_reject_swap = new Scanner(System.in);

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        String accept_reject_swap_value;

        ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM REQUEST_SWAP RS, EMPLOYEE E WHERE RS.mechanic_id_1 = E.emp_id AND RS.sc_id = E.sc_id AND RS.mechanic_id_2 = '"+ mechanic_id +"' AND RS.sc_id = '"+ sc_id +"'");        
        rs1.next();
        String rid[] = new String[rs1.getInt("COUNT(*)")];
        rs1.close();

        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT RS.request_id, E.emp_name, RS.start_time_2, RS.end_time_2 FROM REQUEST_SWAP RS, EMPLOYEE E WHERE RS.mechanic_id_1 = E.emp_id AND RS.sc_id = E.sc_id AND RS.mechanic_id_2 = '"+ mechanic_id +"' AND RS.sc_id = '"+ sc_id +"' AND status = '"+ "PENDING" +"'");

        if(rs.next())
        {
            System.out.println("\n-----Swap Requests-----");
            do
            {
                rid[i] = rs.getString("request_id");
                System.out.println("Request ID: " + rs.getString("request_id"));
                System.out.println("Mechanic name: " + rs.getString("emp_name"));
                System.out.println("Time slot range: " + rs.getString("start_time_2") + " to " + rs.getString("end_time_2"));
                System.out.println("---------------");
                i++;

            }while(rs.next());

            System.out.println("\n1.  Manage Swap Request");
            System.out.println("2.  Go Back");

            System.out.print("\nEnter your choice here: ");
            accept_reject_swap_value = accept_reject_swap.nextLine();

            switch(accept_reject_swap_value)
            {
                case "1":
                    manageSwapRequest(mechanic_id,sc_id, rid);
                    break;
                case "2":
                    mechanicOptions(mechanic_id,sc_id);
                    break;    
                default:
                    System.out.println("\n\nInvalid Input");
                    AcceptRejectSwap(mechanic_id,sc_id);
                    break;
            }

        }
        else
        {
            System.out.println("\n-----> You don't have any swap request.");
            System.out.println("Go Back(Y/N)? ");
            System.out.print("\nEnter your choice here: ");
            accept_reject_swap_value = accept_reject_swap.nextLine();
            if(accept_reject_swap_value.equals("Y"))
                mechanicOptions(mechanic_id,sc_id);
            else
                AcceptRejectSwap(mechanic_id,sc_id);
        }
    }

    public void manageSwapRequest(int mechanic_id, String sc_id, String rid[]) throws SQLException
    {
        Scanner manage_swap_request = new Scanner(System.in);

        System.out.print("\nRequest ID: ");
        String request_id = manage_swap_request.nextLine();

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();

        int check = 0;

        //System.out.println(rid.length);

        for(int i=0; i<rid.length; i++)
        {
            //System.out.println(rid[i]);
            if(request_id.equals(rid[i]))
                check++;
        }

        if(check==0)
        {
            System.out.println("\n--->You entered wrong request ID.");
            manageSwapRequest(mechanic_id, sc_id, rid);
        }
        else
        {
            ResultSet rs = stmt.executeQuery("SELECT mechanic_id_1, start_time_1, end_time_1, start_time_2, end_time_2, week_1, week_2, day_1, day_2 FROM REQUEST_SWAP WHERE request_id = '"+ request_id +"'");
            rs.next();
            String mech_id = rs.getString("mechanic_id_1");
            String start_time_1 = rs.getString("start_time_1");
            String end_time_1 = rs.getString("end_time_1");
            String start_time_2 = rs.getString("start_time_2");
            String end_time_2 = rs.getString("end_time_2");
            String week1 = rs.getString("week_1");
            String week2 = rs.getString("week_2");
            String day1 = rs.getString("day_1");
            String day2 = rs.getString("day_2");
            System.out.println("\n1.  Accept Swap");
            System.out.println("2.  Reject Swap");
            System.out.println("3.  Go Back");

            System.out.print("\nEnter your choice here: ");
            String accept_reject_swap_value = manage_swap_request.nextLine();

            switch(accept_reject_swap_value)
            {
                case "1":
                    stmt.executeQuery("UPDATE SCHEDULED_SERVICES SET start_time_slot = '"+ start_time_1 +"', end_time_slot = '"+ end_time_1 +"' WHERE mechanic_id = '"+ mechanic_id +"' AND sc_id = '"+ sc_id +"' AND '"+ week2 +"' = week AND '"+ day2 +"' = day");
                    stmt.executeQuery("UPDATE SCHEDULED_SERVICES SET start_time_slot = '"+ start_time_2 +"', end_time_slot = '"+ end_time_2 +"' WHERE mechanic_id = '"+ mech_id +"' AND sc_id = '"+ sc_id +"'AND '"+ week1 +"' = week AND '"+ day1 +"' = day");
                    stmt.executeQuery("UPDATE REQUEST_SWAP SET status = '"+ "Accepted" +"' WHERE request_id = '"+ request_id +"'");
                    System.out.println("\n---> Request accepted successfully.");
                    AcceptRejectSwap(mechanic_id, sc_id);
                    break;
                case "2":
                    stmt.executeQuery("UPDATE REQUEST_SWAP SET status = '"+ "Rejected" +"' WHERE request_id = '"+ request_id +"'");
                    System.out.println("\n---> Request rejected successfully.");
                    AcceptRejectSwap(mechanic_id, sc_id);
                    break;
                case "3":
                    mechanicOptions(mechanic_id,sc_id);
                    break;    
                default:
                    System.out.println("\n\nInvalid Input");
                    manageSwapRequest(mechanic_id,sc_id, rid);
                    break;
            }
        }
    }
}

class Login
{
    public void loginOptions() throws SQLException
    {
        String global_username;
        Home home = new Home();
        Admin admin = new Admin();
        Customer customer = new Customer();
        Manager manager = new Manager();
        Mechanic mechanic = new Mechanic();
        Receptionist receptionist = new Receptionist();
        Scanner login_input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String username = login_input.nextLine();
        System.out.print("Password: ");
        String password = login_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Login");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        Connection connection = JDBC_Helper.getConnection();
        Statement stmt = connection.createStatement();
        

        String login_input_value = login_input.nextLine();
        switch(login_input_value)
        {
            case "1":
                ResultSet rs1 = stmt.executeQuery("SELECT EA.password, EA.username, EA.emp_id, EA.sc_id, EA.emp_role FROM EMPLOYEE_AUTH EA WHERE EA.username = '"+ username + "'");
                if(!rs1.next()){
                        ResultSet rs2 = stmt.executeQuery("SELECT C.c_id, C.sc_id, C.password, C.username FROM CUSTOMER C WHERE C.username = '"+ username + "'");
                        if(rs2.next()){
                                String cust_password = rs2.getString("password");
                                if(password.equals(cust_password)){
                                    int c_id = rs2.getInt("c_id");
                                    String sc_id = rs2.getString("sc_id");
                                    
                                    customer.customerOptions(c_id, sc_id);

                                }else{
                                    System.out.print("INVALID PASSWORD!");
                                }
                               
                            }else{
                                System.out.println("User does not exist!");
                            }
                        
                    }else{
                        String emp_password = rs1.getString("password");
                        if(password.equals(emp_password)){
                            String role = rs1.getString("emp_role");
                            if(role.equals("MANAGER")){
                                int manager_id = rs1.getInt("emp_id");
                                String sc_id = rs1.getString("sc_id");  
                                manager.managerOptions(manager_id, sc_id);

                            }else if(role.equals("MECHANIC")){
                                int mechanic_id = rs1.getInt("emp_id");
                                String sc_id = rs1.getString("sc_id");
                                mechanic.mechanicOptions(mechanic_id,sc_id);
                            }else if(role.equals("RECEPTIONIST")){
                                int receptionist_id = rs1.getInt("emp_id");
                                String sc_id = rs1.getString("sc_id");
                                receptionist.receptionistOptions(receptionist_id, sc_id);
                            }else{
                                System.out.print("Employee ROLE NOT FOUND!");
                            }
                        } else {
                            System.out.println("INVALID PASSWORD");
                        }
                        
                    
                }
                
                break;
            case "2":
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                loginOptions();
                break;
        }
    }
}

// class SignUp
// {
//     public void signUpOptions() throws SQLException
//     {
//         Home home = new Home();
//         Customer customer = new Customer();
//         Receptionist receptionist = new Receptionist();
//         Manager manager = new Manager();
//         Mechanic mechanic = new Mechanic();
//         Scanner signup_input = new Scanner(System.in);

//         System.out.print("\nUsername: ");
//         String username = signup_input.nextLine();
//         System.out.print("First Name: ");
//         String first_name = signup_input.nextLine();
//         System.out.print("Last Name: ");
//         String last_name = signup_input.nextLine();
//         System.out.println();
//         System.out.println("\n1. Manager\n2. Receptionist\n3. Mechanic\n4. Customer\n");
//         System.out.print("Choose your role from above: ");
//         String role = signup_input.nextLine();
//         System.out.println();
        
//         if(Integer.parseInt(role)<4)
//         {
//             System.out.println("\n1.  SignUp");
//             System.out.println("2.  Go Back");
//         }
//         else
//         {
//             System.out.println("\nInvalid Input");
//             signUpOptions();
//         }

//         System.out.print("\nEnter your choice here: ");

//         String signup_input_value = signup_input.nextLine();
//         switch(signup_input_value)
//         {
//             case "1":
//                 if(role.equals("1"))
//                     try {
//                         manager.managerOptions();
//                     } catch (SQLException e) {
//                         // TODO Auto-generated catch block
//                         e.printStackTrace();
//                     }
//                 else if(role.equals("2"))
//                         receptionist.receptionistOptions();

//                         else if(role.equals("3"))
//                             mechanic.mechanicOptions();

//                             else if(role.equals("4"))
//                                 //customer.customerOptions(c_id, sc_id);
//                 break;
//             case "2":
//                 home.homeOptions();
//                 break;
//             default:
//                 System.out.println("\n\nInvalid Input");
//                 signUpOptions();
//                 break;
//         }
//     }
// }

class Home
{
    public void homeOptions() throws SQLException
    {
        Login login = new Login();
        //SignUp signup = new SignUp();
        Admin admin = new Admin();
        Scanner home_input = new Scanner(System.in);

        System.out.println("\n1.  Login");
        System.out.println("2.  Login as admin");
        //System.out.println("2.  SignUp");
        System.out.println("3.  Exit");

        System.out.print("\nEnter your choice here: ");

        String home_input_value = home_input.nextLine();
        switch(home_input_value)
        {
            case "1":
                login.loginOptions();
                break;
            case "2":
                admin.adminOptions();
                break;
            case "3":
                System.out.println("\nYou are exited from the system.\n");
                System.exit(0);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                homeOptions();
                break;
        }
    }
}

class DBMSProject1Main
{
    public static void main(String[] args) throws SQLException
    {
        Home home = new Home();
        home.homeOptions();
    }
}