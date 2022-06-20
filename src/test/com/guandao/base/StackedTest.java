package com.guandao.base;

import org.junit.Test;

public class StackedTest {

    @Test
    public void test0() {
        Stacked<Object> s = new Stacked<>();

        s.push("aa");
        s.push("bb");
        s.push("cc");
        System.out.println(s.size());
        System.out.println(s);

        Object p1 = s.peek();
        System.out.println(p1);

        Object p2 = s.pop();
        System.out.println(s);
    }

}
