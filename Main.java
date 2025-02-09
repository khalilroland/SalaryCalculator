
public class Main {
    public static void main(String [] args){

       // SalaryMenu sm = new SalaryMenu();

       
        int daysOfWeek;
        double hoursOfDay;
        double payByHour =0;
        double hoursAWeek =0;
        double salary=0;

        System.out.println("Do you know your annual salary?");
        String yesNo = PromptsandInput.inputValidationYesNo();

        if (yesNo.equals("yes")) {
            salary = PromptsandInput.inputValidationSalary();

            System.out.println("Just to make sure, do you work a typical 9 - 5?  (5 days a week, 8 hours a day) ");
            yesNo = PromptsandInput.inputValidationYesNo();

            if (yesNo.equals("yes")) {
                daysOfWeek = 5;
                hoursOfDay = 8;
                
                /*hoursAWeek = daysOfWeek * hoursOfDay;
                salary = SalaryMenu.annualSalary(payByHour, hoursAWeek);*/
               
            }else{
                daysOfWeek = PromptsandInput.inputValidationDaysOfWeek();
                hoursOfDay = PromptsandInput.inputValidationHoursOfDay();

                /*hoursAWeek = daysOfWeek * hoursOfDay;
                salary = SalaryMenu.annualSalary(payByHour, hoursAWeek);*/
            }
            
        } else {

            daysOfWeek = PromptsandInput.inputValidationDaysOfWeek();
            hoursOfDay = PromptsandInput.inputValidationHoursOfDay();
            payByHour =  PromptsandInput.inputValidationPayByHour();
            hoursAWeek = daysOfWeek * hoursOfDay;
            salary = SalaryMenu.annualSalary(payByHour, hoursAWeek);
        }

        double mothly = SalaryMenu.monthlyPay(salary);
        double weekly = SalaryMenu.weeklyPay(salary);
        double daily = SalaryMenu.dailyPay(weekly, daysOfWeek);
        double hourly = SalaryMenu.hourlyPay(daily, hoursOfDay);
        double minutely = SalaryMenu.minutelyPay(hourly);

        SalaryMenu.menu(salary, mothly, weekly, daily, hourly, minutely, daysOfWeek, hoursOfDay, payByHour, hoursAWeek);
    }


}