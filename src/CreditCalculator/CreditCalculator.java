package CreditCalculator;


public class CreditCalculator {

    static double lending, lendingPrincipal, monthNumber, paymentMonth, i, paymentDiff;
    static int over = 0;


    public static void main(String[] args) {
        String type = System.getProperty("type");
        String interest = System.getProperty("interest");
        String periods = System.getProperty("periods");
        String principal = System.getProperty("principal");
        String payment = System.getProperty("payment");

        if (type != null) {
            if (type.equals("annuity")) {
                if (principal != null && payment != null && interest != null) {
                    paymentMonth = Double.parseDouble(payment);
                    lendingPrincipal = Double.parseDouble(principal);
                    lending = Double.parseDouble(interest);
                    i = (lending / (12 * 100));
                    monthNumber = Math.log(paymentMonth / (paymentMonth - (i * lendingPrincipal))) / Math.log(1 + i);
                    int period = (int) Math.ceil(monthNumber), year = (period / 12), month = (period % 12);

                    if (year > 0 & month > 0) {
                        System.out.println("It will take " + year + " years and " + month + " month to repay this loan");
                    } else if (year == 0) {
                        System.out.println("It will take " + month + " month to repay this loan");
                    } else {
                        System.out.println("It will take " + year + " years to repay this loan");
                    }
                } else if (periods != null && payment != null && interest != null) {
                    monthNumber = Double.parseDouble(periods);
                    paymentMonth = Double.parseDouble(payment);
                    lending = Double.parseDouble(interest);
                    i = (lending / (12 * 100));

                    lendingPrincipal = paymentMonth / ((i * Math.pow((1 + i), monthNumber)) / (Math.pow((1 + i), monthNumber) - 1));
                    System.out.printf("Your loan principal = %.0f", lendingPrincipal);

                } else if (principal != null && periods != null && interest != null) {
                    lendingPrincipal = Double.parseDouble(principal);
                    monthNumber = Double.parseDouble(periods);
                    lending = Double.parseDouble(interest);
                    i = (lending / (12 * 100));

                    paymentMonth = lendingPrincipal * ((i * Math.pow((1 + i), monthNumber)) / (Math.pow((1 + i), monthNumber) - 1));
                    System.out.printf("Your monthly payment = %.0f", paymentMonth);
                } else {
                    System.out.println("Incorrect parameters.");
                    System.exit(0);
                }
        }else if (type.equals("diff")) {
                if (principal == null || periods == null || interest == null) {
                    System.out.println("Incorrect parameters!!!");
                    System.exit(0);
                }
                monthNumber = Double.parseDouble(periods);
                lendingPrincipal = Double.parseDouble(principal);
                lending = Double.parseDouble(interest);
                i = (lending / (12 * 100));
                for (int m = 1; m <= monthNumber; m++) {
                    paymentDiff = lendingPrincipal / monthNumber + i * (lendingPrincipal - ((lendingPrincipal * (m - 1)) / (monthNumber)));
                    paymentDiff = Math.ceil(paymentDiff);
                    over = (int) (over + (paymentDiff - (lendingPrincipal / monthNumber)));
                    System.out.println("Month " + m + ": payment is " + paymentDiff);
                }
                System.out.println("Overpayment = " + over);
            } else {
                System.out.println("Incorrect parameters!!!");
                System.exit(0);
            }
        }else {
            System.out.println("Incorrect parameters!!!");
            System.exit(0);
        }
    }
}



