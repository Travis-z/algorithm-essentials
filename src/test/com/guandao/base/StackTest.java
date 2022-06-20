package com.guandao.base;

import org.junit.Test;

public class StackTest {

    @Test
    public void test0() {

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s);
    }

}
