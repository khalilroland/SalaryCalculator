import java.util.Scanner;

public class PromptsandInput {
 
//-----------------------------------------------------------------------------------------------------------------------------------------------------
      public static String inputValidationYesNo(){
 
        Scanner yn = new Scanner (System.in);

        while (true){
            System.out.println("Please enter 'yes' or 'no' : ");
            String yesNo = yn.next().toLowerCase(); // Convert input to lowercase to make it case-insensitive
            
                if (yesNo.equals("yes") || yesNo.equals ("no")) {
                    return yesNo;
                }
            
            System.out.println("Invalid input. Please enter 'yes' or 'no': ");
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static int inputValidationDaysOfWeek(){

        System.out.println("Enter how many days of the week you work: ");
        
        Scanner dow = new Scanner (System.in);
        int daysOfWeek;

        while (true) {
            if (dow.hasNextInt()) {
                daysOfWeek = dow.nextInt();
                if (daysOfWeek <= 7 && daysOfWeek >= 1) { // Ensure valid range
                    return daysOfWeek;
                }
            } else {
                dow.next(); 
            }
            System.out.println("Error: Invalid Input. Must be a number between '1 - 7'. ");
            System.out.println("Enter how many days of the week you work: ");
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static double inputValidationHoursOfDay(){
 
        Scanner hod = new Scanner (System.in);

        System.out.println("Please enter how many hours per day you work: ");
        double hoursOfDay;

        //While(true) Runs forever unless break or return is used
        //Great for input validation and menus
        while (true) {
            if (hod.hasNextDouble()) {
                hoursOfDay = hod.nextDouble();
                if (hoursOfDay <= 24.0 && hoursOfDay >= 1.0) {
                    return hoursOfDay;
                }
            } else {
                hod.next(); 
            }
            System.out.println("Error: Invalid Input. Must be a number between '1.0 - 24.0' . ");
            System.out.println("Enter how many hours per day you work: ");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static double inputValidationPayByHour(){
 
        Scanner pbh = new Scanner (System.in);

        System.out.println("Please enter how much you get paid hourly: ");
        double payByHour;

        //While(true) Runs forever unless break or return is used
        //Great for input validation and menus
        while (true) {
            if (pbh.hasNextDouble()) {
                payByHour = pbh.nextDouble();
                    return payByHour;
            } else {
                pbh.next(); 
            }
            System.out.println("Error: Invalid Input. Must be a numerical variable. ");
            System.out.println("Please enter how much you get paid hourly: ");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static double inputValidationSalary(){
        System.out.println("Please enter your annual salary: ");

        Scanner input = new Scanner (System.in);
        double salary;

        //While(true) Runs forever unless break or return is used
        //Great for input validation and menus
        while (true) {
            if (input.hasNextDouble()) {
                salary = input.nextDouble();
                    return salary;
            } else {
                System.out.println("Error: Salary must be a numerical value.");
                System.out.println("Example: 75000, 750000.00, 75,000 or 75,000.00");
                input.next(); 
            }
            System.out.print("Please enter your annual salary (numerical values only): ");
        }
        
    
    }


    

}
