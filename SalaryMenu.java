import java.text.DecimalFormat;
import java.util.Scanner;


public class SalaryMenu {

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void menuOptions(){
        System.out.println("Input '1 - 5' to change variables. Input '6' to EXIT. \n");
        System.out.println("1 - CHANGE Salary");
        System.out.println("2 - CHANGE Days Of Week Worked");
        System.out.println("3 - CHANGE Hours Per Day Worked");
        System.out.println("4 - CHANGE Pay By Hour");
        System.out.println("5 - CALCULATE new salary");
        System.out.println("6 - EXIT");
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void menu(double s, double m, double w, double d, double min, int dow, double hod, double pbh, double haw, int way){

        String yesNo;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("-----------------------------------------------------\n");
        System.out.println("Your STATS: \n");
        System.out.println("Hourly pay: $" + df.format(pbh));
        System.out.println("Weeks a year worked: " + way);
        System.out.println("Days a week worked: " + dow);
        System.out.println("Days a year worked: " + (dow*way));
        System.out.println("Hours a day worked: " + df.format(hod));
        System.out.println("Hours a week worked: " + df.format(haw));
        System.out.println("Hours a year worked: " + df.format((haw*way)) + "\n");
        System.out.println("-----------------------------------------------------\n");

        System.out.println("Your ANNUAL salary is: $" + df.format(s) + "\n");

        System.out.println("Amount you earn every MONTH: $" + df.format(m));
        System.out.println("Amount you earn every WEEK: $" + df.format(w));
        System.out.println("Amount you earn every DAY: $" + df.format(d));
        System.out.println("Amount you earn every HOUR: $" + df.format(pbh));
        System.out.println("Amount you earn every MINUTE: $" + df.format(min) +"\n");
        System.out.println("-----------------------------------------------------\n");

        menuOptions();
        
        Scanner choice= new Scanner(System.in);
        int menuChoice = choice.nextInt();

        switch (menuChoice) {
            case 1:
            s = PromptsandInput.inputValidationSalary();
            m = monthlyPay(s);
            w = weeklyPay(s, way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);
            
            menu(s, m, w, d, min, dow, hod, pbh, haw, way);

            break;

            case 2:
            dow = PromptsandInput.inputValidationDaysOfWeek();
            haw = hoursAweek(dow, hod);
            //s = PromptsandInput.inputValidationSalary();
            m = monthlyPay(s);
            w = weeklyPay(s,way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);

            menu(s, m, w, d, min, dow, hod, pbh, haw, way);
            
            break;

            case 3:
            hod = PromptsandInput.inputValidationHoursOfDay();
            haw = hoursAweek(dow, hod);
            //s = PromptsandInput.inputValidationSalary();
            m = monthlyPay(s);
            w = weeklyPay(s,way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);
        
            menu(s, m, w, d, min, dow, hod, pbh, haw, way);

            break;

            case 4:
            pbh=PromptsandInput.inputValidationPayByHour();
            m = monthlyPay(s);
            w = weeklyPay(s,way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);
            menu(s, m, w, d, min, dow, hod, pbh, haw, way);
            
   
            break;

            case 5:

            System.out.println("Do you know your annual salary?");
            yesNo = PromptsandInput.inputValidationYesNo();
    
            if (yesNo.equals("yes") || yesNo.equals("y")) {
                s = PromptsandInput.inputValidationSalary();
    
                System.out.println("Just to make sure, do you work a typical 9 - 5?  (5 days a week, 8 hours a day) ");
                yesNo = PromptsandInput.inputValidationYesNo();
    
                if (yesNo.equals("yes") || yesNo.equals("y")) {
                    dow = 5;
                    hod = 8;
                    haw = hoursAweek(dow, hod);
    
                    System.out.println("Finally, do you work 52 weeks of the year? ");
                    yesNo = PromptsandInput.inputValidationYesNo();
    
                    if (yesNo.equals("yes") || yesNo.equals("y")) {
                    way = 52;
                    }else{
    
                        way = PromptsandInput.inputValidationWeeksAYear();
                    }
    
                   
                }else{
                    dow = PromptsandInput.inputValidationDaysOfWeek();
                    hod = PromptsandInput.inputValidationHoursOfDay();
                    haw = hoursAweek(dow, hod);
    
                    System.out.println("Finally, do you work 52 weeks of the year? ");
                    yesNo = PromptsandInput.inputValidationYesNo();
                    if (yesNo.equals("yes") || yesNo.equals("y")) {
                        way = 52;
                        }else{
        
                            way = PromptsandInput.inputValidationWeeksAYear();
                        }
                }
                
            } else {
    
                dow = PromptsandInput.inputValidationDaysOfWeek();
                hod = PromptsandInput.inputValidationHoursOfDay();
                pbh =  PromptsandInput.inputValidationPayByHour();
    
                System.out.println("Do you work 52 weeks of the year? ");
                yesNo = PromptsandInput.inputValidationYesNo();
                    if (yesNo.equals("yes") || yesNo.equals("y")) {
                        way = 52;
                        }else{
        
                            way= PromptsandInput.inputValidationWeeksAYear();
                        }
    
                haw = hoursAweek(dow, hod);
                s = annualSalary(pbh, haw, way);
            }

            m = monthlyPay(s);
            w = weeklyPay(s, way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);

            menu(s, m, w, d, min, dow, hod, pbh, haw, way);
            break;

            case 6:
            System.out.println("Successfully exited the program. Thank you for using the Salary Calculator app!");
            break;

            default:
                System.out.println("Input Invalid. Please input '1-5' to calculate your earnings \n");
                menu(s, m, w, d, min, dow, hod, pbh, haw, way);
                break;
        }
    } 

//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static double monthlyPay (double x) {
        double monthly = x/12;
        return monthly;
    }

    public static double weeklyPay (double x, int y) {
        double weekly = x/y;
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

    public static double annualSalary (double x, double y, int z){
        double annualSalary = x * y;
        annualSalary = annualSalary * z;
        return annualSalary;
    }

    public static double hoursAweek (int x, double y){
        double hoursAWeek = x * y;
        return hoursAWeek;
    }

}
