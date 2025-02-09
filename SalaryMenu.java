import java.text.DecimalFormat;
import java.util.Scanner;


public class SalaryMenu {

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void menuOptions(){
        System.out.println("Input '1 - 5' to calculate your earnings. Input '6 - 9' to change variables. Input '10' to calculate new salary. Input '11' to EXIT.");
        System.out.println("------------------------------------------------------------\n");
        System.out.println("1 - MONTHLY Earnings");
        System.out.println("2 - WEEKLY Earnings");
        System.out.println("3 - DAILY Earnings");
        System.out.println("4 - HOURLY Earnings");
        System.out.println("5 - MINUTELY Earnings");
        System.out.println("6 - CHANGE Salary");
        System.out.println("7 - CHANGE Days Of Week Worked");
        System.out.println("8 - CHANGE Hours Per Day Worked");
        System.out.println("9 - CHANGE Pay By Hour");
        System.out.println("10 - CALCULATE new salary");
        System.out.println("11 - EXIT");
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void menu(double s, double m, double w, double d, double h, double min, int dow, double hod, double pbh, double haw){


        DecimalFormat df = new DecimalFormat("#.##");
     
        System.out.println("Your annual salary is: $" + df.format(s));
        menuOptions();
        
        Scanner choice= new Scanner(System.in);
        int menuChoice = choice.nextInt();

        switch (menuChoice) {
            case 1:
            System.out.println("The amount you earn every month is: $" + df.format(m) + "\n");
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 2:
            System.out.println("The amount you earn every week is: $" + df.format(w) + "\n");
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 3:
            System.out.println("The amount you earn every day is: $" + df.format(d) + "\n");
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 4:
            System.out.println("The amount you earn every hour is: $" + df.format(h) + "\n");
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 5:
            System.out.println("The amount you earn every minute is: $" + df.format(min) + "\n");
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 6:
            s = PromptsandInput.inputValidationSalary();
            m = monthlyPay(s);
            w = weeklyPay(s);
            d = dailyPay(w, dow);
            h = hourlyPay(d, hod);
            min = minutelyPay(h);
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 7:
            dow = PromptsandInput.inputValidationDaysOfWeek();
            //s = PromptsandInput.inputValidationSalary();
            m = monthlyPay(s);
            w = weeklyPay(s);
            d = dailyPay(w, dow);
            h = hourlyPay(d, hod);
            min = minutelyPay(h);
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 8:
            hod = PromptsandInput.inputValidationHoursOfDay();
            //s = PromptsandInput.inputValidationSalary();
            m = monthlyPay(s);
            w = weeklyPay(s);
            d = dailyPay(w, dow);
            h = hourlyPay(d, hod);
            min = minutelyPay(h);
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 9:
            pbh=PromptsandInput.inputValidationPayByHour();
            m = monthlyPay(s);
            w = weeklyPay(s);
            d = dailyPay(w, dow);
            h = hourlyPay(d, hod);
            min = minutelyPay(h);
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
            break;

            case 10:
            dow = PromptsandInput.inputValidationDaysOfWeek();
            hod = PromptsandInput.inputValidationHoursOfDay();
            pbh =  PromptsandInput.inputValidationPayByHour();
            haw = dow * hod;
            s = SalaryMenu.annualSalary(pbh, haw);
            m = monthlyPay(s);
            w = weeklyPay(s);
            d = dailyPay(w, dow);
            h = hourlyPay(d, hod);
            min = minutelyPay(h);
            menu(s, m, w, d, h, min, dow, hod, pbh, haw);
    
            break;

            case 11:
            System.out.println("Successfully exited the program. Thank you for using the Salary Calculator app!");
            break;

            default:
                System.out.println("Input Invalid. Please input '1-5' to calculate your earnings \n");
                menu(s, m, w, d, h, min, dow, hod, pbh, haw);
                break;
        }
    } 

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static double monthlyPay (double x) {
        double monthly = x/12;
        return monthly;
    }

    public static double weeklyPay (double x) {
        double weekly = x/52;
        return weekly;
    }

    public static double dailyPay (double x, int y) {
        double daily = x/y;
        return daily;
    }

    public static double hourlyPay (double x, double y) {
        double hourly = x/y;
        return hourly;

    }

    public static double minutelyPay (double x) {
        double minutelyPay = x/60;
        return minutelyPay;
    }

    public static double annualSalary (double x, double y){
        double annualSalary = x * y;
        annualSalary = annualSalary * 52;
        return annualSalary;
    }

}
