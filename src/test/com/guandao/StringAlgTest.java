package com.guandao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringAlgTest {

    @Test
    public void test2() {

        ArrayList<String> a = new ArrayList<>();

        boolean cc = a.add("cc");
        a.remove("cc");

    }


    @Test
    public void test1() {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println(1 << 30);
        System.out.println(Integer.toBinaryString(1 << 30));

        System.out.println(Integer.MAX_VALUE - (1 << 30));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE - (1 << 30)));

        System.out.println(1 << 31);
        System.out.println(1 << 32);
    }


    @Test
    public void test0() {

        // 给定一个单词列表，你想要返回另一个列表，显示每个单词中有几个字母
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        System.out.println(words);

        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);

        int a = 3;
        Stream<int[]> s1 = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});

        IntStream cc = IntStream.rangeClosed(1, 100);
        Stream<Integer> dd = IntStream.rangeClosed(1, 100).boxed();


        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(x -> IntStream.rangeClosed(x, 100)
                        .filter(y -> Math.sqrt(x * x + y * y) % 1 == 0)
                        .mapToObj(y -> new int[] { x, y, (int) Math.sqrt(x * x + y * y) })
                );
    }

}
