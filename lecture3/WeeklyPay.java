class WeeklyPay {

 public static void pay(double basePay, int hours) {

    if (basePay < 8.0) {
        System.out.println("You must be paid at least $8.00/hour");
    } else if (hours > 60) {
        System.out.println("You can't work more than 60 hours a week");
    } else {
        int overtimeHours = 0;
        if (hours > 40) {
            overtimeHours = hours - 40;
            hours = 40;
        }    
        double pay = basePay * hours;
        pay += overtimeHours * basePay * 1.5;
        System.out.println("Pay this employee $" + pay);
    }
 }

 public static void main(String[] arguments) {

    pay(7.5, 35);
    pay(8.2, 47);
    pay(10.0, 73);
 }
}