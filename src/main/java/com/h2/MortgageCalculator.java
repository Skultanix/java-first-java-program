package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
private long loanAmount;
private int termInYears;
private float annualRate;
private double monthlyPayment;

public MortgageCalculator (long loanAmount, int termInYears, float annualRate) {
    this.loanAmount = loanAmount;
    this.termInYears = termInYears;
    this.annualRate = annualRate;
    this.monthlyPayment = monthlyPayment;
}
private int getNumberOfPayments() {
    termInYears = termInYears * 12;
    return termInYears;
}
private float getMonthlyInterestRate () {
    float interestRate = annualRate / 100;
    return interestRate /12;
}
public void calculateMonthlyPayment() {
    double M = (((getMonthlyInterestRate() * Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments()))) / ((Math.pow(1 + getMonthlyInterestRate(), getNumberOfPayments()))-1));
}

public String toString() {
    DecimalFormat df = new DecimalFormat("###0.00");
    return "monthlyPayment: " +df.format(monthlyPayment);
}

public static void main(String[] args) {
    long loanAmount = Long.parseLong(args[0]);
    int termInYears = Integer.parseInt(args[1]);
    float annualRate = Float.parseFloat(args[2]);

    MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
    calculator.calculateMonthlyPayment();
    System.out.println(calculator.toString());
}
}
