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
                break;
            case "2":
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
                break;
            case "2":
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
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
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