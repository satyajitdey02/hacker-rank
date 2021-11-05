package com.skill.test.discovery;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<MainC> st = new ArrayList<>();
        MainC obj = new MainC(1);
        st.add(obj);
        st.add(obj);
        st.add(obj);

        System.out.println(st);
    }

    private static class MainC {
        int a;
        MainC(int a) {
            this.a =a;
        }

        public int getA() {return a;}
    }
}
