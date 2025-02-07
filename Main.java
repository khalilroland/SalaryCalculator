import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String [] args){

        double salary = inputValidation();

        double mothly = monthlyPay(salary);
        double weekly = weeklyPay(salary);
        double daily = dailyPay(weekly);
        double hourly = hourlyPay(daily);
        double minutely = minutelyPay(hourly);

        menu(salary, mothly, weekly, daily, hourly, minutely);
    }

    
    public static double inputValidation(){
        System.out.println("Please enter your annual salary (numerical values only): ");

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

    public static void menuOptions(){
        System.out.println("Input '1 - 5' to calculate your earnings. Input '6' to CHANGE salary. Input '7' to EXIT.");
        System.out.println("------------------------------------------------------------\n");
        System.out.println("1 - MONTHLY Earnings");
        System.out.println("2 - WEEKLY Earnings");
        System.out.println("3 - DAILY Earnings");
        System.out.println("4 - HOURLY Earnings");
        System.out.println("5 - MINUTELY Earnings");
        System.out.println("6 - CHANGE Salary");
        System.out.println("7 - EXIT");
    }

    public static void menu(double s, double m, double w, double d, double h, double min){


        DecimalFormat df = new DecimalFormat("#.##");
     
        System.out.println("The annual salary you've entered is: $" + df.format(s));
        menuOptions();
        
        Scanner choice= new Scanner(System.in);
        int menuChoice = choice.nextInt();

        switch (menuChoice) {
            case 1:
            System.out.println("The amount you earn every month is: $" + df.format(m) + "\n");
            menu(s, m, w, d, h, min);
            break;

            case 2:
            System.out.println("The amount you earn every week is: $" + df.format(w) + "\n");
            menu(s, m, w, d, h, min);
            break;

            case 3:
            System.out.println("The amount you earn every day is: $" + df.format(d) + "\n");
            menu(s, m, w, d, h, min);
            break;

            case 4:
            System.out.println("The amount you earn every hour is: $" + df.format(h) + "\n");
            menu(s, m, w, d, h, min);
            break;

            case 5:
            System.out.println("The amount you earn every minute is: $" + df.format(min) + "\n");
            menu(s, m, w, d, h, min);
            break;

            case 6:
            s = inputValidation();
            m = monthlyPay(s);
            w = weeklyPay(s);
            d = dailyPay(w);
            h = hourlyPay(d);
            min = minutelyPay(h);
            menu(s, m, w, d, h, min);
            break;

            case 7:
            System.out.println("Successfully exited the program. Thank you for using the Salary Calculator app!");
            break;

            default:
                System.out.println("Input Invalid. Please input '1-5' to calculate your earnings \n");
                menu(s, m, w, d, h, min);
                break;
        }
    } 


    public static double monthlyPay (double x) {
        double monthly = x/12;
        return monthly;
    }

    public static double weeklyPay (double x) {
        double weekly = x/52;
        return weekly;
    }

    public static double dailyPay (double x) {
        double daily = x/5;
        return daily;
    }

    public static double hourlyPay (double x) {
        double hourly = x/8;
        return hourly;

    }

    public static double minutelyPay (double x) {
        double minutelyPay = x/60;
        return minutelyPay;
    }
    
}