package com.guandao.base;

import org.junit.Test;

public class VarrayTest {

    @Test
    public void test0() {

        Varray<Integer> data = new Varray<>();
        System.out.println("size:" + data.size() + ", " + data);

        for (int i = 0; i < 8; i++) {
            data.add(i);
        }

        System.out.println("size:" + data.size() + ", " + data);

        System.out.println(data.find(8) > -1);

        for (int i = 0; i < 5; i++) {
            data.remove(i);
        }
        System.out.println("size:" + data.size() + ", " + data);
    }

}
