package com.helping.code;

public class ThreadTestImplRunnable implements Runnable {

    String name;

    public ThreadTestImplRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("This is running from: " + this.name);
    }

    public static void main(String[] args) {

        Runnable task = new ThreadTestImplRunnable("Runnable Thread!");
        Thread thread =  new Thread(task);
        thread.start();
    }
}
