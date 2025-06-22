import  java.util.*;
public class FinancialPrediction {
    public static double precdiction(double amt, double rate, int year) {
        if(year==0) return amt;
        return  precdiction(amt * (1 + rate), rate, year - 1);
    }
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        double  amt = S.nextDouble();
        double rate = S.nextDouble();
        int year = S.nextInt();
        double ans = precdiction(amt, rate, year);
        System.out.printf("%.2f", ans);
    }
}
