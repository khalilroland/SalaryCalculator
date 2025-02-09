
public class Main {
    public static void main(String [] args){

       // SalaryMenu sm = new SalaryMenu();

       
        int daysOfWeek = 0;
        int weeksAYear = 0;

        double hoursOfDay;
        double payByHour =0;
        double hoursAWeek =0;
        double salary=0;


        System.out.println("Do you know your annual salary?");
        String yesNo = PromptsandInput.inputValidationYesNo();

        if (yesNo.equals("yes") || yesNo.equals("y")) {
            salary = PromptsandInput.inputValidationSalary();

            System.out.println("Just to make sure, do you work a typical 9 - 5?  (5 days a week, 8 hours a day) ");
            yesNo = PromptsandInput.inputValidationYesNo();

            if (yesNo.equals("yes") || yesNo.equals("y")) {
                daysOfWeek = 5;
                hoursOfDay = 8;
                hoursAWeek = SalaryMenu.hoursAweek(daysOfWeek, hoursOfDay);

                System.out.println("Finally, do you work 52 weeks of the year? ");
                yesNo = PromptsandInput.inputValidationYesNo();

                if (yesNo.equals("yes") || yesNo.equals("y")) {
                weeksAYear = 52;
                }else{

                    weeksAYear = PromptsandInput.inputValidationWeeksAYear();
                }

               
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

            hoursAWeek = SalaryMenu.hoursAweek(daysOfWeek, hoursOfDay);
            salary = SalaryMenu.annualSalary(payByHour, hoursAWeek);
        }

        double mothly = SalaryMenu.monthlyPay(salary);
        double weekly = SalaryMenu.weeklyPay(salary, weeksAYear);
        double daily = SalaryMenu.dailyPay(weekly, daysOfWeek);
        payByHour= SalaryMenu.hourlyPay(daily, hoursOfDay);
        double minutely = SalaryMenu.minutelyPay(payByHour);

        SalaryMenu.menu(salary, mothly, weekly, daily, payByHour, minutely, daysOfWeek, hoursOfDay, payByHour, hoursAWeek, weeksAYear);
    }


}