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
                home.customerProfile();
                break;
            case "2":
                home.viewScheduleService();
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
///-----------------Start Akruti Edits--------

class CustomerProfileOptions
{
    public void customerProfile()
    {
        Home home = new Home();
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
                home.customerViewProfile();
            case "2":
                home.customerAddNewCar();
            case "3":
                home.customerDeleteCar();
            case "4":
                home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerProfile();
                break;
        }
    }
}
class CustomerViewProfile
{
    public void customerViewProfile()
    {
        Home home = new Home();
        
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

        String customer_profile_input_value = customer_profile_input.nextLine();
        switch(customer_profile_input_value)
        {
            case "1":
                home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerViewProfile();
                break;
        }
    }
}

class CustomerAddCar
{
    public void customerAddNewCar()
    {
        Home home = new Home();

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

        System.out.println("\n1.  Save Information");
        System.out.println("2.  Cancel");

        System.out.print("\nEnter your choice here: ");

        String customer_add_car_input_value = customer_add_car_input.nextLine();
        switch(customer_add_car_input_value)
        {
            case "1":
                break;
            case "2":
                home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerAddNewCar();
                break;
        }
    }
}
class CustomerDeleteCar
{
    public void customerDeleteCar()
    {
        Home home = new Home();

        // Scanner customer_add_car_input = new Scanner(System.in);

        // System.out.print("\nVIN number: ");
        // String vin_number = customer_add_car_input.nextLine();
        // System.out.print("Car Manufacturer Name: ");
        // String manufacturer_name = customer_add_car_input.nextLine();
        // System.out.print("Current Mileage: ");
        // String mileage = customer_add_car_input.nextLine();
        // System.out.print("Year: ");
        // String year = customer_add_car_input.nextLine();
        // System.out.println();

        // System.out.println("\n1.  Save Information");
        // System.out.println("2.  Cancel");

        // System.out.print("\nEnter your choice here: ");

        // String admin_add_new_store_input_value = admin_add_new_store_input.nextLine();
        // switch(admin_add_new_store_input_value)
        // {
        //     case "1":
        //         break;
        //     case "2":
        //         home.customerOptions();
        //         break;
        //     default:
        //         System.out.println("\n\nInvalid Input");
        //         adminAddNewStore();
        //         break;
        }
    }

class CustomerViewScheduleServices
{
    public void viewScheduleService()
    {
        Home home = new Home();
        Scanner customer_view_schedule_service_input = new Scanner(System.in);

        System.out.println("\n1.  View Service History");
        System.out.println("2.  Schedule Service");
        System.out.println("3.  Go Back");

        System.out.print("\nEnter your choice here: ");

        String customer_view_schedule_service_input_value = customer_view_schedule_service_input.nextLine();
        switch(customer_view_schedule_service_input_value)
        {
            case "1":
                home.viewServiceHistory();
                break;
            case "2":
                home.customerScheduleService();
                break;
            case "3":
                home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewScheduleService();
                break;
        }
    }
}

class CustomerViewServiceHistory
{
    public void viewServiceHistory()
    {
        Home home = new Home();
        Scanner customer_view_service_input = new Scanner(System.in);

        System.out.println("\n1.  Enter VIN Number of Car");
        String customer_view_service_input_value = customer_view_service_input.nextLine();
//------------------SHOW HISTORY---------------------
        
        System.out.println("1.  Go Back");
        System.out.print("\nEnter your choice here: ");
        Scanner customer_go_back_service_input = new Scanner(System.in);
        String customer_go_back_service_input_value = customer_go_back_service_input.nextLine();

        switch(customer_go_back_service_input_value)
        {
            case "1":
                home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                viewServiceHistory();
                break;
        }
    }
}

class CustomerScheduleService
{
    public void customerScheduleService()
    {
        Home home = new Home();
        Scanner customer_schedule_service_input = new Scanner(System.in);

        System.out.println("\n1.  Enter VIN Number of Car");
        String customer_vin_input_value = customer_schedule_service_input.nextLine();
        System.out.println("\n1.  Enter Current Mileage of Car");
        String customer_mileage_input_value = customer_schedule_service_input.nextLine();

        Scanner customer_schedule_service_input2 = new Scanner(System.in);

        System.out.println("\n1.  Add Schedule Maintenance");
        System.out.println("2.  Add Schedule Repair");
        System.out.println("2.  View Cart and select Schedule Time");
        System.out.println("3.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_schedule_service_input2_value = customer_schedule_service_input2.nextLine();

        switch(customer_schedule_service_input2_value)
        {
            case "1":
                home.customerScheduleMaintenance();
                break;
            case "2":
                home.customerScheduleRepair();
                break;
            case "3":
                home.viewScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleService();
                break;
        }
    }
}

class CustomerScheduleMaintenance
{
    public void customerScheduleMaintenance()
    {
        Home home = new Home();

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
                home.customerScheduleService();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                customerScheduleMaintenance();
                break;
        }
    }
}

class CustomerScheduleRepair
{
    public void customerScheduleRepair()
    {
        Home home = new Home();
        Scanner customer_schedule_repair_input = new Scanner(System.in);

        System.out.println("\n1.  Engine Services");
        System.out.println("2.  Exhaust Services");
        System.out.println("3.  Electrical Services");
        System.out.println("4.  Transmission Services");
        System.out.println("5.  Tire Services");
        System.out.println("6.  Heating and AC Services");
        System.out.println("7.  Go Back");
        System.out.print("\nEnter your choice here: ");

        String customer_schedule_service_input2_value = customer_schedule_service_input2.nextLine();

        switch(customer_schedule_service_input2_value)
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
}


