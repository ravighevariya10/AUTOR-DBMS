import java.util.Scanner;

class AdminSystemSetUp
{
    public void adminSystemSetUpOptions()
    {
        Admin admin = new Admin();

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
                admin.adminOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                adminSystemSetUpOptions();
                break;
        }
    }
}

class AdminAddNewStore
{
    public void adminAddNewStore()
    {
        Admin admin = new Admin();

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
                admin.adminOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                adminAddNewStore();
                break;
        }
    }
}

class Admin
{
    public void adminOptions()
    {
        Home home = new Home();
        AdminSystemSetUp adminSystemSetUp = new AdminSystemSetUp();
        AdminAddNewStore adminAddNewStore =  new AdminAddNewStore();
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
                adminSystemSetUp.adminSystemSetUpOptions();
                break;
            case "2":
                adminAddNewStore.adminAddNewStore();
                break;
            case "3":
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