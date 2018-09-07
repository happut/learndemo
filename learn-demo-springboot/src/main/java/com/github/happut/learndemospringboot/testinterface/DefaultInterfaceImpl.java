package com.github.happut.learndemospringboot.testinterface;

public class DefaultInterfaceImpl implements DefaultInterface {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        DefaultInterface calculator = new DefaultInterfaceImpl();
        System.out.println(calculator.addThree(1d, 2d, 3d));

        DefaultInterface.staticMethod();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaaaaaa");
            }
        }).start();

        new Thread(() -> {
            System.out.println("aaaaaaaaaaaaa");
        });


    }


}
