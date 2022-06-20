package com.guandao.bit;

public class Solution01 {

    public static void main(String[] args) {
        System.out.println(getBinary(19, false));
        System.out.println(Integer.toBinaryString(19));

        System.out.println(getBinary(Integer.MAX_VALUE, false));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println(getBinary(Integer.MIN_VALUE, false));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }

    public static String getBinary(int n, boolean align) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int x  = (n & (1 << i)) >>> i;
            sb.append(x);
        }
        return sb.toString();
    }

}
