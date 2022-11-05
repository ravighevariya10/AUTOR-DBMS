import java.util.Scanner;

class Admin
{
    public void adminOptions()
    {
        Home home = new Home();
        Scanner admin_input = new Scanner(System.in);

        System.out.println("\n1.  System Set up");
        System.out.println("2.  Add New Store");
        System.out.println("3.  Add New Service");
        System.out.println("4.  Logout");

        System.out.print("\nEnter your choice here: ");

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

    public void adminSystemSetUpOptions()
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

    public void adminAddNewStore()
    {
        Scanner admin_add_new_store_input = new Scanner(System.in);

        System.out.print("\nStore ID: ");
        String store_id = admin_add_new_store_input.nextLine();
        System.out.print("Address: ");
        String address = admin_add_new_store_input.nextLine();
        System.out.print("First Name: ");
        String first_name = admin_add_new_store_input.nextLine();
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

    public void adminAddNewService()
    {
        Scanner admin_add_new_service_input = new Scanner(System.in);

        System.out.print("\nEnter existing service category: ");
        String service_category = admin_add_new_service_input.nextLine();
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
    public void customerOptions()
    {
        Home home = new Home();
        Scanner customer_input = new Scanner(System.in);

        System.out.println("\n1.  View and Update Profile");
        System.out.println("2.  View and Schedule Service");
        System.out.println("3.  Invoices");
        System.out.println("4.  Logout");

        System.out.print("\nEnter your choice here: ");

        String customer_input_value = customer_input.nextLine();
        switch(customer_input_value)
        {
            case "1":
                customerProfile();
                break;
            case "2":
                viewScheduleService();
                break;
            case "3":
                break;
            case "4":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerOptions();
                break;
        }
    }

    public void customerProfile()
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
                customerViewProfile();
                break;
            case "2":
                customerAddNewCar();
                break;
            case "3":
                customerDeleteCar();
                break;
            case "4":
                customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerProfile();
                break;
        }
    }

    public void customerViewProfile()
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
                customerProfile();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerViewProfile();
                break;
        }
    }

    public void customerAddNewCar()
    {
        Scanner customer_add_car_input = new Scanner(System.in);

        System.out.print("\nVIN number: ");
        String vin_number = customer_add_car_input.nextLine();
        System.out.print("Car Manufacturer Name: ");
        String manufacturer_name = customer_add_car_input.nextLine();
        System.out.print("Current Mileage: ");
        String mileage = customer_add_car_input.nextLine();
        System.out.print("Year: ");
        String year = customer_add_car_input.nextLine();
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
                customerProfile();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerAddNewCar();
                break;
        }
    }

    public void customerDeleteCar()
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
                customerProfile();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerDeleteCar();
                break;
        }
    }

    public void viewScheduleService()
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
                viewServiceHistory();
                break;
            case "2":
                customerScheduleService();
                break;
            case "3":
                customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewScheduleService();
                break;
        }
    }

    public void viewServiceHistory()
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
                viewScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewServiceHistory();
                break;
        }
    }

    public void customerScheduleService()
    {
        Scanner customer_schedule_service_input = new Scanner(System.in);

        System.out.println("\n1.  Enter VIN Number of Car");
        String vin = customer_schedule_service_input.nextLine();
        System.out.println("\n1.  Enter Current Mileage of Car");
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
                customerScheduleMaintenance();
                break;
            case "2":
                customerScheduleRepair();
                break;
            case "3":
                customerViewCart();
                break;   
            case "4":
                viewScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleService();
                break;
        }
    }

    public void customerScheduleMaintenance()
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
                customerScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleMaintenance();
                break;
        }
    }

    public void customerScheduleRepair()
    {
        Scanner customer_schedule_repair_input = new Scanner(System.in);

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
                customerScheduleRepair();
                break;
        }
    }

    public void customerViewCart()
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
                customerScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerViewCart();
                break;
        }
    }
}

class Receptionist
{
    public void receptionistOptions()
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

    public void addNewCustomerProfile()
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

    public void findCustomerWithPendingInvoice()
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
    public void managerOptions()
    {
        Home home = new Home();
        Scanner manager_input = new Scanner(System.in);

        System.out.println("\n1.  Setup Store");
        System.out.println("2.  Add New Employee");
        System.out.println("3.  Logout");

        System.out.print("\nEnter your choice here: ");

        String manager_input_value = manager_input.nextLine();
        switch(manager_input_value)
        {
            case "1":
                managerSetUpStore();
                break;
            case "2":
                managerAddNewEmployees();
                break;
            case "3":
                System.out.println("\nYou are logged out.");
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerOptions();
                break;
        }
    }

    public void managerSetUpStore()
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
                managerAddEmployees();
                break;
            case "2":
                managerSetupOperationalHours();
                break;
            case "3":
                managerSetupServicePrices();
                break;
            case "4":
                managerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetUpStore();
                break;
        }
    }
    
    public void managerAddEmployees()
    {
        Scanner manager_add_employees_input = new Scanner(System.in);

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
        switch(manager_add_employees_input_value)
        {
            case "1":
                break;
            case "2":
                managerSetUpStore();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerAddEmployees();
                break;
        }
    }

    public void managerSetupOperationalHours()
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
                managerSetUpStore();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupOperationalHours();
                break;
        }
    }

    public void managerSetupServicePrices()
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
                managerSetupMaintenanceServicePrices();
                break;
            case "2":
                managerSetupRepairServicePrices();
                break;
            case "3":
                managerSetUpStore();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupServicePrices();
                break;
        }
    }

    public void managerSetupMaintenanceServicePrices()
    {
        Scanner manager_setup_maintenance_service_prices_input = new Scanner(System.in);

        System.out.print("\nSchedule A price: ");
        String schedule_a_price = manager_setup_maintenance_service_prices_input.nextLine();
        System.out.print("Schedule B price: ");
        String schedule_b_price = manager_setup_maintenance_service_prices_input.nextLine();
        System.out.print("Schedule C price: ");
        String schedule_c_price = manager_setup_maintenance_service_prices_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Setup Prices");
        System.out.println("2.  Go back");

        System.out.print("\nEnter your choice here: ");

        String manager_setup_maintenance_service_prices_input_value = manager_setup_maintenance_service_prices_input.nextLine();
        switch(manager_setup_maintenance_service_prices_input_value)
        {
            case "1":
                break;
            case "2":
                managerSetupServicePrices();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupMaintenanceServicePrices();
                break;
        }
    }

    public void managerSetupRepairServicePrices()
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
                managerSetupServicePrices();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerSetupRepairServicePrices();
                break;
        }
    }

    public void managerAddNewEmployees()
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
                managerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                managerAddNewEmployees();
                break;
        }
    }

}

class Mechanic
{
    public void mechanicOptions()
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

    public void viewScedule()
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

    public void requestTimeOff()
    {
        Scanner request_time_off = new Scanner(System.in);

        System.out.print("\nTime Slots when Mechanic wants off: ");
        String mechanic_time_off = request_time_off.nextLine();
        System.out.println();

        System.out.println("1.  Send the Request");
        String send_the_request = request_time_off.nextLine();
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

    public void requestSwap()
    {
        Scanner request_swap = new Scanner(System.in);

        System.out.print("\nTimeSlot range to swap: ");
        String time_slot_swap = request_swap.nextLine();
        System.out.print("\nEmployee ID of Mechanic that is requested for swap: ");
        String mechanic_requested_swap = request_swap.nextLine();
        System.out.print("\nTimeSlot range of the requested mechanic that is interested: ");
        String interested_mechanic = request_swap.nextLine();
        System.out.println();

        System.out.println("1.  Send the Request");
        String send_the_request = request_swap.nextLine();
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

    public void AcceptRejectSwap()
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

    public void manageSwapRequest()
    {
        Scanner manage_swap_request = new Scanner(System.in);

        System.out.print("\nRequest ID: ");
        String request_id = manage_swap_request.nextLine();
        System.out.println();

        System.out.println("1.  Accept Swap");
        String accept_swap = manage_swap_request.nextLine();
        System.out.println("2.  Reject Swap");
        String reject_swap = manage_swap_request.nextLine();
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
    public void loginOptions()
    {
        Home home = new Home();
        Admin admin = new Admin();
        Scanner login_input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String username = login_input.nextLine();
        System.out.print("Password: ");
        String password = login_input.nextLine();
        System.out.println();

        System.out.println("\n1.  Login");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String login_input_value = login_input.nextLine();
        switch(login_input_value)
        {
            case "1":
                admin.adminOptions();
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

class SignUp
{
    public void signUpOptions()
    {
        Home home = new Home();
        Customer customer = new Customer();
        Receptionist receptionist = new Receptionist();
        Manager manager = new Manager();
        Mechanic mechanic = new Mechanic();
        Scanner signup_input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String username = signup_input.nextLine();
        System.out.print("First Name: ");
        String first_name = signup_input.nextLine();
        System.out.print("Last Name: ");
        String last_name = signup_input.nextLine();
        System.out.println();
        System.out.println("\n1. Manager\n2. Receptionist\n3. Mechanic\n4. Customer\n");
        System.out.print("Choose your role from above: ");
        String role = signup_input.nextLine();
        System.out.println();
        
        System.out.println("\n1.  SignUp");
        System.out.println("2.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String signup_input_value = signup_input.nextLine();
        switch(signup_input_value)
        {
            case "1":
                if(role.equals("1"))
                    manager.managerOptions();

                    else if(role.equals("2"))
                        receptionist.receptionistOptions();

                        else if(role.equals("3"))
                            mechanic.mechanicOptions();

                            else if(role.equals("4"))
                                customer.customerOptions();
                break;
            case "2":
                home.homeOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                signUpOptions();
                break;
        }
    }
}

class Home
{
    public void homeOptions()
    {
        Login login = new Login();
        SignUp signup = new SignUp();
        Scanner home_input = new Scanner(System.in);

        System.out.println("\n1.  Login");
        System.out.println("2.  SignUp");
        System.out.println("3.  Exit");

        System.out.print("\nEnter your choice here: ");

        String home_input_value = home_input.nextLine();
        switch(home_input_value)
        {
            case "1":
                login.loginOptions();
                break;
            case "2":
            signup.signUpOptions();
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
    public static void main(String[] args)
    {
        Home home = new Home();
        home.homeOptions();
    }
}