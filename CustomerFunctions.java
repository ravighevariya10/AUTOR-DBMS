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
                home.customerOptions();
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
                home.customerOptions();
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
                home.customerOptions();
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
            case "2":
                break;
            case "3":
                home.customerOptions();
                break;
            default:
                System.out.println("\n\nInvalid Input");
                home.customerOptions();
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
                home.customerOptions();
                break;
        }
    }
}
