package com.helping.code;

public class ThreadTestExtendThread extends Thread{

    private String name;

    public ThreadTestExtendThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("This is running from thread: " + this.name);
    }

    public static void main(String[] args) {
        ThreadTestExtendThread test = new ThreadTestExtendThread("Demo");
        test.start();

    }
}
