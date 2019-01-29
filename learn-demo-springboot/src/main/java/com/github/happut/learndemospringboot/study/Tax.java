package com.github.happut.learndemospringboot.study;

public class Tax {

    public static void main(String[] args) {
        int pay = 30000;
        int cost = 5000 + 4500 + 2000;

        double historyTax = 0;
        for (int i = 1; i <= 12; i++) {
            int yearPay = pay * i;
            System.out.println(yearPay);
            System.out.println(yearPay - cost * i);

            int readyToTax = yearPay - cost * i;
            if (readyToTax <= 36000) {
                double tax = (yearPay - cost * i) * 0.03 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            } else if (readyToTax > 36000 && readyToTax <= 144000) {
                double tax = (yearPay - cost * i) * 0.1 - 2520 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            } else if (readyToTax > 144000 && readyToTax <= 300000) {
                double tax = (yearPay - cost * i) * 0.2 - 16920 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            } else if (readyToTax > 300000 && readyToTax <= 420000) {
                double tax = (yearPay - cost * i) * 0.25 - 31920 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            } else if (readyToTax > 420000 && readyToTax <= 660000) {
                double tax = (yearPay - cost * i) * 0.3 - 52920 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            } else if (readyToTax > 660000 && readyToTax <= 960000) {
                double tax = (yearPay - cost * i) * 0.35 - 85920 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            } else if (readyToTax > 960000) {
                double tax = (yearPay - cost * i) * 0.45 - 181920 - historyTax;
                historyTax += tax;
                System.out.println("第" + i + "月，交" + tax + "元税");
            }
        }
    }
}
