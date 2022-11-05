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
                break;
            case "2":
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