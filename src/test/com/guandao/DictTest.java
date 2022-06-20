package com.guandao;

import org.junit.Test;

import java.util.HashMap;

public class DictTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void test() {
        HashMap<Object, Object> m = new HashMap<>();

        System.out.println("0  => " + tableSizeFor(0) + " => " + tabSize(0));
        System.out.println("1  => " + tableSizeFor(1) + " => " + tabSize(1));
        System.out.println("2  => " + tableSizeFor(2) + " => " + tabSize(2));
        System.out.println("3  => " + tableSizeFor(3) + " => " + tabSize(3));
        System.out.println("7  => " + tableSizeFor(7) + " => " + tabSize(7));
        System.out.println("8  => " + tableSizeFor(8) + " => " + tabSize(8));
        System.out.println("9  => " + tableSizeFor(9) + " => " + tabSize(9));
        System.out.println("16 => " + tableSizeFor(16) + " => " + tabSize(16));
        System.out.println("17 => " + tableSizeFor(17) + " => " + tabSize(17));
        System.out.println("1<<29   => " + tableSizeFor(1 << 29)        + " => " + tabSize(1 << 29));
        System.out.println("1<<29+1 => " + tableSizeFor((1 << 29) + 1)    + " => " + tabSize((1 << 29) + 1));
        System.out.println("1<<30   => " + tableSizeFor(1 << 30)        + " => " + tabSize(1 << 30));
        System.out.println("1<<30+1 => " + tableSizeFor((1 << 30) + 1)    + " => " + tabSize((1 << 30) + 1));
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static int tabSize(int cap) {
        int n = Integer.highestOneBit(cap);
        return n == 0 ? 1 :
                n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY :
                        cap <= n ? n : n << 1;
    }

}
