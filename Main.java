import BackEnd.*;

//-----------------------------------------------------------------------------------------------------------------------------------------------------

/*
SalaryCalculator by Khalil Roland
This is the Main Class, Use this class to run the code!

Future updates: Take the code out of the console and make a mini app with it
 */

//-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Main {
    public static void main(String [] args){

        //Variables needed to actually calculate Salary

        int daysOfWeek = 0; //How many days of the week the user works
        int weeksAYear = 0; //How many weeks of the year the user works
        double hoursOfDay; //How many hours of the day the user works
        double payByHour =0;//How much the user makes an hour
        double hoursAWeek =0; //How many hours of the week the user works
        double salary=0; //users salary

//-----------------------------------------------------------------------------------------------------------------------------------------------------
//Initial questions to gather user data to store in variables


        System.out.println("Do you know your annual salary?");

        //yesNo string variable store the users choice (yes or no)
        //input validation makes it so user has to enter yes or y
        String yesNo = PromptsandInput.inputValidationYesNo();

        //if the user knows annual salary, prompts user to enter it
        //used yes and y, y just made it easier to type and test, secret developer easteregg
        if (yesNo.equals("yes") || yesNo.equals("y")) { 
            salary = PromptsandInput.inputValidationSalary(); 

            //if the user entered yes, prompts the user to make sure they work the default 9-5
            System.out.println("Just to make sure, do you work a typical 9 - 5?  (5 days a week, 8 hours a day) ");
            yesNo = PromptsandInput.inputValidationYesNo();

            //if yes, variables change to 9-5 variables
            if (yesNo.equals("yes") || yesNo.equals("y")) {
                daysOfWeek = 5;
                hoursOfDay = 8;

                //calculates the hours a week and stores it in variables
                hoursAWeek = SalaryMenu.hoursAweek(daysOfWeek, hoursOfDay);

                //finally, this prompt is to mkae sure the user works the average 52 weeks a year
                System.out.println("Finally, do you work 52 weeks of the year? ");
                yesNo = PromptsandInput.inputValidationYesNo();

                //if yes, stores it in var
                if (yesNo.equals("yes") || yesNo.equals("y")) {
                weeksAYear = 52;
                }else{
                    //if no, prompts user for their specific weeks worked
                    weeksAYear = PromptsandInput.inputValidationWeeksAYear();
                }

               
                //else statement for if the user hit no for 9-5, prompts uer to enter specific hours and days worked, ask next questions like before
            }else{
                daysOfWeek = PromptsandInput.inputValidationDaysOfWeek();
                hoursOfDay = PromptsandInput.inputValidationHoursOfDay();
                hoursAWeek = SalaryMenu.hoursAweek(daysOfWeek, hoursOfDay);

                System.out.println("Finally, do you work 52 weeks of the year? ");
                yesNo = PromptsandInput.inputValidationYesNo();
                if (yesNo.equals("yes") || yesNo.equals("y")) {
                    weeksAYear = 52;
                    }else{
    
                        weeksAYear = PromptsandInput.inputValidationWeeksAYear();
                    }
            }
            
            //else statement for if user didnt know salary, prompts for all 3 to calculate salary (daysOfWeek, hoursOfDay, payByHour)
            //continues with other questions like normal
        } else {

            daysOfWeek = PromptsandInput.inputValidationDaysOfWeek();
            hoursOfDay = PromptsandInput.inputValidationHoursOfDay();
            payByHour =  PromptsandInput.inputValidationPayByHour();

            System.out.println("Do you work 52 weeks of the year? ");
            yesNo = PromptsandInput.inputValidationYesNo();
                if (yesNo.equals("yes") || yesNo.equals("y")) {
                    weeksAYear = 52;
                    }else{
    
                        weeksAYear = PromptsandInput.inputValidationWeeksAYear();
                    }
            

            
            hoursAWeek = SalaryMenu.hoursAweek(daysOfWeek, hoursOfDay); //calculates hours worked a week and stores in var
            salary = SalaryMenu.annualSalary(payByHour, hoursAWeek, weeksAYear); // calculates salary and stores in var
        }

//-----------------------------------------------------------------------------------------------------------------------------------------------------

        //vars that calculate and store monthly pay, daily pay, weekly pay, etc based off salary
        double mothly = SalaryMenu.monthlyPay(salary);
        double weekly = SalaryMenu.weeklyPay(salary, weeksAYear);
        double daily = SalaryMenu.dailyPay(weekly, daysOfWeek);
        payByHour= SalaryMenu.hourlyPay(daily, hoursOfDay);
        double minutely = SalaryMenu.minutelyPay(payByHour);

//-----------------------------------------------------------------------------------------------------------------------------------------------------

        //uses stored vars for the actual salary menu
        SalaryMenu.menu(salary, mothly, weekly, daily, minutely, daysOfWeek, hoursOfDay, payByHour, hoursAWeek, weeksAYear);
    }


}