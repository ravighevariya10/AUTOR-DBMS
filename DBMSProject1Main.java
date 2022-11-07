import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;

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
                String sql2= "insert into manager(manager_id,sc_id,m_name,salary,username,password)values('"+ employee_id + "','" + store_id + "','" + name + "','" + salary + "','" + username + " ','" + password + "')";
                stmt.executeQuery(sql2);
                String sql3= "insert into employee(emp_id,sc_id,emp_name,salary,emp_address,emp_role)values('"+ employee_id + "','" + store_id + "','" + name + "','" + salary + "','" + address + " ','" + "MANAGER" + "')";
                stmt.executeQuery(sql3);
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
        System.out.print("\nCustomer ID: ");       
        System.out.print("First Name: ");      
        System.out.print("Last Name: ");    
        System.out.print("Address: ");     
        System.out.print("Email Address: ");     
        System.out.print("Phone Number: ");
        System.out.print("List of all Cars: ");

        System.out.println();
        System.out.println("1.  Go Back");

        System.out.print("\nEnter your choice here: ");
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

        System.out.print("\nVIN number: ");
        String vin_number = customer_delete_car_input.nextLine();
        System.out.print("Car Manufacturer Name: ");
        String manufacturer_name = customer_delete_car_input.nextLine();
        System.out.print("Current Mileage: ");
        String mileage = customer_delete_car_input.nextLine();
        System.out.print("Year: ");
        String year = customer_delete_car_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Select the car to delete");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String admin_add_delete_car_input_value = customer_delete_car_input.nextLine();
        switch(admin_add_delete_car_input_value)
        {
            case "1":
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
                customerScheduleMaintenance(c_id, sc_id);
                break;
            case "2":
                customerScheduleRepair(c_id, sc_id);
                break;
            case "3":
                customerViewCart(c_id, sc_id);
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

    public void customerScheduleMaintenance(int c_id, String sc_id) throws SQLException
    {
        System.out.println("\n1.  These are the list of services you are eligible for:");
        //--Display a message with the service schedule the customer is eligible for (A, B, or C) and the cost.

        Scanner customer_schedule_maintenance_input = new Scanner(System.in);

        System.out.println("\n1.  A");
        System.out.println("2.  B");
        System.out.println("2.  C");
        System.out.println("D.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_schedule_maintenance_input_value = customer_schedule_maintenance_input.nextLine();

        switch(customer_schedule_maintenance_input_value)
        {
            case "A":
                // home.customerOptions();
                break;
            case "B":
               // home.customerOptions();
                break;
            case "C":
               // home.customerOptions();
                break;    
            case "D":
                customerScheduleService(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleMaintenance(c_id, sc_id);
                break;
        }
    }

    public void customerScheduleRepair(int c_id, String sc_id)
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
                 //home.customerScheduleMaintenance();
                break;
            case "2":
               // home.customerOptions();
                break;
            case "3":
                //home.customerScheduleService();
                break;
            case "4":
                //home.customerScheduleService();
                break;
            case "5":
                //home.customerScheduleService();
                break;
            case "6":
                //home.customerScheduleService();
                break;
            case "7":
                //home.customerScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id);
                break;
        }
    }

    public void customerViewCart(int c_id, String sc_id) throws SQLException
    { 
        System.out.println("\n1.  These are the list of services in your cart. Do you wish to proceed to checkout?");
        //--list of services in cart

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
                customerViewCart(c_id, sc_id);
                break;
        }
    }

    public void customerEngineServices(int c_id, String sc_id)
    {
 
        System.out.println("For 'Engine Services', these are the services available");
        System.out.println("\n1. Belt Replacement");
        System.out.println("2. Engine Repair");
        System.out.println("3. Go Back");

        Scanner customer_engine_services_input = new Scanner(System.in);
        System.out.println("Enter your choice here: ");

        String customer_engine_services_input_value = customer_engine_services_input.nextLine();

        switch(customer_engine_services_input_value)
        {
            case "1":
                System.out.println("You've selected Belt Replacement. Added to cart. ");
                // Add to cart
                break;
            case "2":
                System.out.println("You've selected Engine Repair. Added to cart. ");
                // Add to cart
                break;
            case "3":
                customerScheduleRepair(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerEngineServices(c_id, sc_id);
                break;
        }
    }
    public void customerExhaustServices(int c_id, String sc_id)
    {
 
        System.out.println("For 'Exhaust Services', these are the services available");
        System.out.println("\n1. Catalytic Converter Repair");
        System.out.println("2. Muffler Repair");
        System.out.println("3. Go Back");

        Scanner customer_exhaust_services_input = new Scanner(System.in);
        System.out.println("Enter your choice here: ");

        String customer_exhaust_services_input_value = customer_exhaust_services_input.nextLine();

        switch(customer_exhaust_services_input_value)
        {
            case "1":
                System.out.println("You've selected Catalytic Converter Repair. Added to cart. ");
                // Add to cart
                break;
            case "2":
                System.out.println("You've selected Muffler Repair. Added to cart. ");
                // Add to cart
                break;
            case "3":
                customerScheduleRepair(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id);
                break;
        }
    }

    public void customerElectricalServices(int c_id, String sc_id)
    {
 
        System.out.println("For 'Electrical Services', these are the services available");
        System.out.println("\n1. Alternator Repair");
        System.out.println("2. Power Lock Repair");
        System.out.println("3. Go Back");

        Scanner customer_electrical_services_input = new Scanner(System.in);
        System.out.println("Enter your choice here: ");

        String customer_electrical_services_input_value = customer_electrical_services_input.nextLine();

        switch(customer_electrical_services_input_value)
        {
            case "1":
                System.out.println("You've selected Alternator Repair. Added to cart. ");
                // Add to cart
                break;
            case "2":
                System.out.println("You've selected Power Lock Repair. Added to cart. ");
                // Add to cart
                break;
            case "3":
                customerScheduleRepair(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id);
                break;
        }
    }

    public void customerTransmissionServices(int c_id, String sc_id)
    {
 
        System.out.println("For 'Transmission Services', these are the services available");
        System.out.println("\n1. Axle Repair");
        System.out.println("2. Transmission Flush");
        System.out.println("3. Go Back");

        Scanner customer_transmission_services_input = new Scanner(System.in);
        System.out.println("Enter your choice here: ");

        String customer_transmission_services_input_value = customer_transmission_services_input.nextLine();

        switch(customer_transmission_services_input_value)
        {
            case "1":
                System.out.println("You've selected Axle Repair. Added to cart. ");
                // Add to cart
                break;
            case "2":
                System.out.println("You've selected Transmission Flush. Added to cart. ");
                // Add to cart
                break;
            case "3":
                customerScheduleRepair(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id);
                break;
        }
    }

    public void customerTireServices(int c_id, String sc_id)
    {
 
        System.out.println("For 'Tire Services', these are the services available");
        System.out.println("\n1. Tire Balancing");
        System.out.println("2. Wheel Alignment");
        System.out.println("3. Go Back");

        Scanner customer_tire_services_input = new Scanner(System.in);
        System.out.println("Enter your choice here: ");

        String customer_tire_services_input_value = customer_tire_services_input.nextLine();

        switch(customer_tire_services_input_value)
        {
            case "1":
                System.out.println("You've selected Tire Balancing. Added to cart. ");
                // Add to cart
                break;
            case "2":
                System.out.println("You've selected Wheel Alignment. Added to cart. ");
                // Add to cart
                break;
            case "3":
                customerScheduleRepair(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id);
                break;
        }
    }

    public void customerHeatingACServices(int c_id, String sc_id)
    {
 
        System.out.println("For 'Heating and AC Services', these are the services available");
        System.out.println("\n1. Compressor Repair");
        System.out.println("2. Go Back");

        Scanner customer_heating_services_input = new Scanner(System.in);
        System.out.println("Enter your choice here: ");

        String customer_heating_services_input_value = customer_heating_services_input.nextLine();

        switch(customer_heating_services_input_value)
        {
            case "1":
                System.out.println("You've selected Compressor Repair. Added to cart. ");
                // Add to cart
                break;
            case "2":
                customerScheduleRepair(c_id, sc_id);
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleRepair(c_id, sc_id);
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
    public void receptionistOptions() throws SQLException
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
                addNewCustomerProfile();
                break;
            case "2":
                findCustomerWithPendingInvoice();
                break;
            case "3":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                receptionistOptions();
                break;
        }
    }

    public void addNewCustomerProfile() throws SQLException
    {
        Scanner add_new_customer_profile = new Scanner(System.in);

        System.out.print("\nCustomer Name: ");
        String customer_name = add_new_customer_profile.nextLine();
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
        System.out.println();

        System.out.println("1.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String add_new_customer_profile_value = add_new_customer_profile.nextLine();
        switch(add_new_customer_profile_value)
        {
            case "1":
                receptionistOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                addNewCustomerProfile();
                break;
        }
    }

    public void findCustomerWithPendingInvoice() throws SQLException
    {
        Scanner find_customer_with_pending_invoice = new Scanner(System.in);

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

        System.out.println("1.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String find_customer_with_pending_invoice_value = find_customer_with_pending_invoice.nextLine();
        switch(find_customer_with_pending_invoice_value)
        {
            case "1":
                receptionistOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                findCustomerWithPendingInvoice();
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

        System.out.print("\nName: ");
        String name = manager_add_employees_input.nextLine();
        System.out.print("Address: ");
        String address = manager_add_employees_input.nextLine();
        System.out.print("Email Address: ");
        String email_address = manager_add_employees_input.nextLine();
        System.out.print("Phone Number: ");
        String phone_number = manager_add_employees_input.nextLine();
        System.out.print("Role: ");
        String role = manager_add_employees_input.nextLine();
        System.out.print("Start Date: ");
        String start_date = manager_add_employees_input.nextLine();
        System.out.print("Compensation: ");
        String compensation = manager_add_employees_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_add_employees_input_value = manager_add_employees_input.nextLine();
        //String sql1 = "SELLECT SC_ID FROM MANAGER WHERE MANAGER_ID = "
        switch(manager_add_employees_input_value)
        {
            case "1":
                String sql1 = "INSERT INTO EMPLOYEE (EMP_NAME, EMP_EMAIL, EMP_ADDRESS, EMP_CONTACT, EMP_ROLE, EMP_STARTDATE, EMP_COMPENSATION)VALUES('"+ name + "','" + email_address + "','" + address + "','" + phone_number + "','" + role + " ','" + start_date + "' ,'" + compensation + "');";
                //stmt.executeQuery(sql1);
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

        System.out.print("\nOperational on Saturdays?: ");
        String operational_days = manager_setup_operational_hours_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Add");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_operational_hours_input_value = manager_setup_operational_hours_input.nextLine();
        switch(manager_setup_operational_hours_input_value)
        {
            case "1":
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

        
        ResultSet rs1 = stmt.executeQuery("SELECT MODEL_NAME FROM MODEL");
        ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM MODEL");

        rs2.next();
        String schedule_a_price[] = new String[rs2.getInt("COUNT(*)")];
        String schedule_b_price[] = new String[rs2.getInt("COUNT(*)")];
        String schedule_c_price[] = new String[rs2.getInt("COUNT(*)")];
        String model[] = new String[rs2.getInt("COUNT(*)")];

        while(rs1.next()){
            System.out.print("\nSchedule A price for " + rs1.getString("model_name" + ": "));
            schedule_a_price[i] = manager_setup_maintenance_service_prices_input.nextLine();
            System.out.print("\n");
            System.out.print("\nSchedule B price for " + rs1.getString("model_name" + ": "));
            schedule_b_price[i] = manager_setup_maintenance_service_prices_input.nextLine();
            System.out.print("\n");
            System.out.print("\nSchedule C price for " + rs1.getString("model_name" + ": "));
            schedule_c_price[i] = manager_setup_maintenance_service_prices_input.nextLine();
            System.out.print("\n");
            model[i] = rs1.getString("model_name" + ": ");
            i++;
        }

        System.out.println("\n1.  Setup Prices");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_maintenance_service_prices_input_value = manager_setup_maintenance_service_prices_input.nextLine();
        switch(manager_setup_maintenance_service_prices_input_value)
        {
            case "1":
                for(int m=0; m<schedule_a_price.length; m++){

                    ResultSet rs = stmt.executeQuery("SELECT S_NO FROM MAINTENANCE_DURATION WHERE SCHEDULE_NAME = '"+ "A" + "'");
                    int s_no = rs.getInt("s_no");
                    stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ model[i] + "', '"+ schedule_a_price[i] + "','"+ s_no + "')");
                }
                for(int j=0; j<schedule_b_price.length; j++){
                    ResultSet rs = stmt.executeQuery("SELECT S_NO FROM MAINTENANCE_DURATION WHERE SCHEDULE_NAME = '"+ "B" + "'");
                    int s_no = rs.getInt("s_no");
                    stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ model[i] + "', '"+ schedule_b_price[i] + "','"+ s_no + "')");
                }
                for(int k=0; k<schedule_c_price.length; k++){
                    ResultSet rs = stmt.executeQuery("SELECT S_NO FROM MAINTENANCE_DURATION WHERE SCHEDULE_NAME = '"+ "C" + "'");
                    int s_no = rs.getInt("s_no");
                    stmt.execute("INSERT INTO PRICE_CHECK(SC_ID,Manufacturer,price,s_no) VALUES('"+ sc_id + "','"+ model[i] + "', '"+ schedule_c_price[i] + "','"+ s_no + "')");
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

        System.out.print("\nBelt Replacement Price: ");
        String belt_replacement_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Engine Repair Price: ");
        String engine_repair_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Catalytic Converter Price: ");
        String catalytic_converter_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Muffler Repair Price: ");
        String muffler_repair_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Power Lock Repair Price: ");
        String power_lock_repair_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Axle Repair Price: ");
        String axle_repair_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Transmission Flush Repair Price: ");
        String transmission_flush_repair_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Tire Balancing Price: ");
        String tire_balancing_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Wheel Alignment Price: ");
        String wheel_alignment_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.print("Compressor Repair Price: ");
        String compressor_repair_price = manager_setup_repair_service_prices_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Setup Prices");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_repair_service_prices_input_value = manager_setup_repair_service_prices_input.nextLine();
        switch(manager_setup_repair_service_prices_input_value)
        {
            case "1":
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

        System.out.print("\nName: ");
        String name = manager_add_new_employees_input.nextLine();
        System.out.print("Address: ");
        String address = manager_add_new_employees_input.nextLine();
        System.out.print("Email Address: ");
        String email_address = manager_add_new_employees_input.nextLine();
        System.out.print("Phone Number: ");
        String phone_number = manager_add_new_employees_input.nextLine();
        System.out.print("Role: ");
        String role = manager_add_new_employees_input.nextLine();
        System.out.print("Start Date: ");
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
    public void mechanicOptions() throws SQLException
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
                viewScedule();
                break;
            case "2":
                requestTimeOff();
                break;
            case "3":
                requestSwap();
                break;
            case "4":
                AcceptRejectSwap();
                break;
            case "5":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                mechanicOptions();
                break;
        }
    }

    public void viewScedule() throws SQLException
    {
        Scanner view_schedule = new Scanner(System.in);

        System.out.print("\nList of Time Slot When Mechanic is Booked for Service: ");
        String mechanic_booked_time = view_schedule.nextLine();
        System.out.println();

        System.out.println("1.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String view_schedule_value = view_schedule.nextLine();
        switch(view_schedule_value)
        {
            case "1":
                mechanicOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewScedule();
                break;
        }
    }

    public void requestTimeOff() throws SQLException
    {
        Scanner request_time_off = new Scanner(System.in);

        System.out.println("\nTime Slots when Mechanic wants off: ");
        System.out.print("Week: ");
        String week = request_time_off.nextLine();
        System.out.print("Day: ");
        String day = request_time_off.nextLine();
        System.out.print("Slot start time: ");
        String slot_start_time = request_time_off.nextLine();
        System.out.print("Slot end time: ");
        String slot_end_time = request_time_off.nextLine();
        System.out.println();

        System.out.println("1.  Send the Request");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");
        String request_time_off_value = request_time_off.nextLine();

        switch(request_time_off_value)
        {
            case "1":
                break;
            case "2":
                mechanicOptions();
                break;    
            default:
                System.out.println("\n\nInvalid Input");
                requestTimeOff();
                break;
        }
    }

    public void requestSwap() throws SQLException
    {
        Scanner request_swap = new Scanner(System.in);

        System.out.print("\n---TimeSlot range to swap---");
        System.out.print("\nWeek: ");
        String week1 = request_swap.nextLine();
        System.out.print("Day: ");
        String day1 = request_swap.nextLine();
        System.out.print("Slot starting time: ");
        String slot_starting_time1 = request_swap.nextLine();
        System.out.print("Slot ending time: ");
        String slot_ending_time1 = request_swap.nextLine();
        
        System.out.print("\n---Employee ID of Mechanic that is requested for swap: ---");
        System.out.print("\nEmployee ID: ");
        String employee_id = request_swap.nextLine();
        
        System.out.print("\n---TimeSlot range of the requested mechanic that is interested: ---");
        System.out.print("\nWeek: ");
        String week2 = request_swap.nextLine();
        System.out.print("Day: ");
        String day2 = request_swap.nextLine();
        System.out.print("Slot starting time: ");
        String slot_starting_time2 = request_swap.nextLine();
        System.out.print("Slot ending time: ");
        String slot_ending_time2 = request_swap.nextLine();
        System.out.println();

        System.out.println("1.  Send the Request");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String request_swap_value = request_swap.nextLine();
        switch(request_swap_value)
        {
            case "1":
                break;
            case "2":
                mechanicOptions();
                break;    
            default:
                System.out.println("\n\nInvalid Input");
                requestSwap();
                break;
        }
    }

    public void AcceptRejectSwap() throws SQLException
    {
        Scanner accept_reject_swap = new Scanner(System.in);

        System.out.print("\nRequest ID: ");
        String request_id = accept_reject_swap.nextLine();
        System.out.print("\nRequestinf Mechanic's Name: ");
        String requesting_mechanic_name = accept_reject_swap.nextLine();
        System.out.print("\nTimeSlot range requested: ");
        String timeslot_range_requested = accept_reject_swap.nextLine();
        System.out.println();

        System.out.println("1.  Manage Swap Request");
        String manage_swap_request = accept_reject_swap.nextLine();
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String accept_reject_swap_value = accept_reject_swap.nextLine();
        switch(accept_reject_swap_value)
        {
            case "1":
                manageSwapRequest();
                break;
            case "2":
                mechanicOptions();
                break;    
            default:
                System.out.println("\n\nInvalid Input");
                AcceptRejectSwap();
                break;
        }
    }

    public void manageSwapRequest() throws SQLException
    {
        Scanner manage_swap_request = new Scanner(System.in);

        System.out.print("\nRequest ID: ");
        String request_id = manage_swap_request.nextLine();
        System.out.println();

        System.out.println("1.  Accept Swap");
        System.out.println("2.  Reject Swap");
        System.out.println("3.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String accept_reject_swap_value = manage_swap_request.nextLine();
        switch(accept_reject_swap_value)
        {
            case "1":
                break;
            case "2":
                break;
            case "3":
                mechanicOptions();
                break;    
            default:
                System.out.println("\n\nInvalid Input");
                manageSwapRequest();
                break;
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
                                int mechanic_Id = rs1.getInt("emp_id");
                                String sc_id = rs1.getString("sc_id");
                            }else if(role.equals("RECEPTIONIST")){
                                int receptionist_Id = rs1.getInt("emp_id");
                                String sc_id = rs1.getString("sc_id");
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
        SignUp signup = new SignUp();
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