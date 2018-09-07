package com.github.happut.learndemospringboot.testinterface;

public class DefaultInterfaceImpl implements DefaultInterface {
    @Override
    public String a() {
        return "child:a";
    }

    @Override
    public String b() {
        return "child:b";
    }


    public static void main(String[] args) {
        DefaultInterface in = new DefaultInterfaceImpl();
        System.out.println(in.b());

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
