package com.guandao.base;

import org.junit.Test;

public class VarrayTest {

    @Test
    public void test0() {

        Varray<Integer> data = new Varray<>(6);
        System.out.println("size:" + data.size() + ", " + data);

        for (int i = 0; i < 5; i++) {
            data.add(i);
        }

        System.out.println("size:" + data.size() + ", " + data);

        System.out.println(data.find(2));
        System.out.println(data.find(6));

        for (int i = 0; i < 3; i++) {
            data.remove(0);
        }

        System.out.println("size:" + data.size() + ", " + data);

        System.out.println(data.get(1));

        System.out.println(data.contains(4));

        System.out.println(data.remove(Integer.valueOf(3)));
    }

}
