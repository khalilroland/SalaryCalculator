import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Magic behind the program, this classs does all the calculations and menu magic
 * Use "Main.java" to actually run propgram
 */

public class SalaryMenu {

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Just list menu options so it doesnt have to keep getting typed
    public static void menuOptions(){
        System.out.println("Input '1 - 5' to change variables. Input '6' to view budget.  Input '7' to EXIT. \n");
        System.out.println("1 - CHANGE Salary");
        System.out.println("2 - CHANGE Days A Week Worked");
        System.out.println("3 - CHANGE Hours Per Day Worked");
        System.out.println("4 - CHANGE Pay By Hour");
        System.out.println("5 - CHANGE Everything");
        System.out.println("6 - VIEW Budget");
        System.out.println("7 - EXIT");
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//the actual menu, takes initial variables from main java and recycles them depending on what options the user selects
    public static void menu(double s, double m, double w, double d, double min, int dow, double hod, double pbh, double haw, int way){
        /*
        s = annual salary
        m = monthly salary
        w = weekly salary 
        d = daily salary
        min - minutely salary
        dow = days of week worked
        hod = hours of day worked
        pbh = pay by the hour (hourly pay)
        haw = hours a week worked
        way = weeks a year worked
        */

        String yesNo; //stores users yes or no from prompts
        DecimalFormat df = new DecimalFormat("#.##"); //organizes decimals so its not infinite long numbers

        //shows user stats - or for nerds the variables that we will be working with
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

        //shows salary, monthly salary, weekly salary, etc.

        System.out.println("Your ANNUAL salary is: $" + df.format(s) + "\n");

        System.out.println("Amount you earn every MONTH: $" + df.format(m));
        System.out.println("Amount you earn every WEEK: $" + df.format(w));
        System.out.println("Amount you earn every DAY: $" + df.format(d));
        System.out.println("Amount you earn every HOUR: $" + df.format(pbh));
        System.out.println("Amount you earn every MINUTE: $" + df.format(min) +"\n");
        System.out.println("-----------------------------------------------------\n");

        //displays menu options
        menuOptions();
        
        //gets choice user inputed and does menu option based off choice entered
        Scanner choice= new Scanner(System.in);
        int menuChoice = choice.nextInt();

        //the actual menu in code
        switch (menuChoice) {

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Choice 1 - CHANGE Salary
            case 1:
            s = PromptsandInput.inputValidationSalary(); //prompts user with change salary input and changes vars based off salary entered
            m = monthlyPay(s);
            w = weeklyPay(s, way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);
            
            menu(s, m, w, d, min, dow, hod, pbh, haw, way);

            break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Choice 2 - CHANGE Days Of Week Worked
            case 2:

            dow = PromptsandInput.inputValidationDaysOfWeek(); //prompts user with change days of week input and changes vars based off dow entered
            haw = hoursAweek(dow, hod);
            m = monthlyPay(s);
            w = weeklyPay(s,way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);

            menu(s, m, w, d, min, dow, hod, pbh, haw, way);

            break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Choice 3 - CHANGE Hours Per Day Worked
            case 3:
            hod = PromptsandInput.inputValidationHoursOfDay(); //prompts user with hours of day input and changes vars based off hod entered
            haw = hoursAweek(dow, hod);
            m = monthlyPay(s);
            w = weeklyPay(s,way);
            d = dailyPay(w, dow);
            pbh = hourlyPay(d, hod);
            min = minutelyPay(pbh);
        
            menu(s, m, w, d, min, dow, hod, pbh, haw, way);

            break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Choice 4 - CHANGE Pay By Hour
            case 4:

            //incase the user doesnt know, changing the horuly pay will change everything based off the salary except for weeks worked, hours worked, etc
            System.out.println("Warning: Changing 'Pay By Hour' will change 'ANNUAL Salary'.");
            System.out.println("'Days a Week Worked' and 'Hours Per Day Worked' will remain the same. New Calculations will be made based off new 'STATS'.");
            System.out.println("Do you want to proceed?");


            yesNo = PromptsandInput.inputValidationYesNo();
            if (yesNo.equals("yes") || yesNo.equals("y")) {
    
            pbh=PromptsandInput.inputValidationPayByHour(); //prompts user with pay by hour input and changes vars based off pbh entered
            s = annualSalary(pbh, haw, way);
            m = monthlyPay(s);
            w = weeklyPay(s,way);
            d = dailyPay(w, dow);
            min = minutelyPay(pbh);
            menu(s, m, w, d, min, dow, hod, pbh, haw, way);
            }else{
                menu(s, m, w, d, min, dow, hod, pbh, haw, way);
            }
        
            
            break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
// Choice 5 - CALCULATE new salary
// Does exactly what initial prompt in main menu does, if user wanted to try a new salary
// changes vars to new vars user entered
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

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Choice 6 - VIEW Budget
            case 6:

        //displays daily, weekly, monthly and hour budgets based off the 20/30/50 rule

        System.out.println("-----------------------------------------------------\n");
        System.out.println("DAILY BUDGET");
        System.out.println("Income DAILY: $" + df.format(d));
        System.out.println("NEEDS (50%): $" + df.format(d*.5));
        System.out.println("WANTS (30%): $" + df.format(d*.3));
        System.out.println("SAVINGS/INVESTMENTS (20%): $" + df.format(d*.2)+"\n");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("WEEKLY BUDGET");
        System.out.println("Income WEEKLY: $" + df.format(w));
        System.out.println("NEEDS (50%): $" + df.format(w*.5));
        System.out.println("WANTS (30%): $" + df.format(w*.3));
        System.out.println("SAVINGS/INVESTMENTS (20%): $" + df.format(w*.2)+"\n");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("MONTHLY BUDGET");
        System.out.println("Income MONTHLY: $" + df.format(m));
        System.out.println("NEEDS (50%): $" + df.format(m*.5));
        System.out.println("WANTS (30%): $" + df.format(m*.3));
        System.out.println("SAVINGS/INVESTMENTS (20%): $" + df.format(m*.2)+"\n");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("YEARLY BUDGET");
        System.out.println("Income YEARLY: $" + df.format(s));
        System.out.println("NEEDS (50%): $" + df.format(s*.5));
        System.out.println("WANTS (30%): $" + df.format(s*.3));
        System.out.println("SAVINGS/INVESTMENTS (20%): $" + df.format(s*.2)+"\n");

        menu(s, m, w, d, min, dow, hod, pbh, haw, way);
        break;



//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Choice 7 - Exit case
            case 7: 
            System.out.println("Successfully exited the program. Thank you for using the Salary Calculator app!");
            break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Wrong Input case
            default:
                System.out.println("Input Invalid. Please input '1-5' to calculate your earnings \n");
                menu(s, m, w, d, min, dow, hod, pbh, haw, way);
                break;
        }
    } 

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Calculations for everything!

//Motnhly pay. x = salary
    public static double monthlyPay (double x) {
        double monthly = x/12;
        return monthly;
    }

//Weekly pay. x = salary, y = weeks a year
    public static double weeklyPay (double x, int y) {
        double weekly = x/y;
        return weekly;
    }

//Daily pay. x = Weekly pay, y = days of week 
    public static double dailyPay (double x, int y) {
        double daily = x/y;
        return daily;
    }

//hourly pay (pay by hour). x = daily pay, y = hours a day worked
    public static double hourlyPay (double x, double y) {
        double hourly = x/y;
        return hourly;

    }

//minutely pay. x = hourly pay (pay by hour)
    public static double minutelyPay (double x) {
        double minutelyPay = x/60;
        return minutelyPay;
    }

//Annual Salary. x = hourly pay (pay by hour), y = hours a Week, z = weeks A Year
    public static double annualSalary (double x, double y, int z){
        double annualSalary = x * y;
        annualSalary = annualSalary * z;
        return annualSalary;
    }

//Hours a week. x = days of week, y = hours a day
    public static double hoursAweek (int x, double y){
        double hoursAWeek = x * y;
        return hoursAWeek;
    }
}
