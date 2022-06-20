package com.guandao.base;

import org.junit.Test;

public class StackTest {

    @Test
    public void test0() {
        Stack<Object> s = new Stack<>();

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
