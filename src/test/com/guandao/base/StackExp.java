package com.guandao.base;

import org.junit.Assert;
import org.junit.Test;

public class StackExp {

    /**
     * 栈的典型应用场合
     *
     * 逆序遍历：conversion
     *  输出次序与处理过程颠倒，递归深度和输出长度不易预知
     *
     * 递归嵌套：stack permutation + parenthesis
     *  具有自相似性的问题可递归描述，但分支位置和嵌套深度不固定
     *
     * 延迟缓存：evaluation
     *  线性扫描算法模式中，在预读足够长之后，方能确定可处理的前缀
     *
     * 栈式计算：RPN
     *  基于栈结构的特定计算模式
     */



    /**
     * 进制转换: 如何将10进制转换成其他进制数 ？
     *  1, 将原数对进制数取模，余数记入栈
     *  2, 将原数对进制数取商
     *  3, 将商作为原数，重复进行 1,2 步骤, 直到商为0
     */
    public static String convert(int n, int base) {
        if (n == 0) return "0";

        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        Stack<Character> s = new Stack<>();

        while (n > 0) {
            s.push(digit[n % base]);
            n /= base;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    @Test
    public void convertTest() {
        int n = 15;

        System.out.println(convert(n, 16));
        System.out.println(convert(n, 8));
        System.out.println(convert(n, 2));

        Assert.assertEquals("30", convert(n, 5));
    }

    /**
     * 括号匹配 : 如何判断一个运算表达式中，括号是否合法 ？
     *  1, 每遇到一个左括号都入栈，
     *  2，若栈不为空，每遇到一个右括号都出栈; 若栈为空则不合法
     *  3, 最后判断栈是否为空
     *
     *  a, 为什么不直接采用计数器: 加1，减1, 最后判断是否为0呢？
     *     a1, 不好推广至多种括号的情况, 如: [ ( ] )
     *
     *     a2, 采用栈甚至可推广至非括号形式, 如: <html><p>...</p></html>
     *          即按约定"括号"的通用格式，而不必事先固定括号的类型与数目
     */
    public static boolean parenMatch(String exp) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if ('(' == c) s.push(c);
            else if (')' == c && !s.empty()) s.pop();
            else if (')' == c && s.empty()) return false;
        }

        return s.empty();
    }

    @Test
    public void parenMatchTest() {
        String exp = "3 + 4 + ((2 - 1) * (3 - 2)) + (3 + 3) + 4";
        Assert.assertTrue(parenMatch(exp));

        String exp1 = "(3 + (4 + ((2 - 1) * (3 - 2))) + (3 + 3) + 4)";
        Assert.assertTrue(parenMatch(exp1));
    }


    /**
     * 表达式求值
     */
    public static double calc(String exp) {

        Stack<Integer> opnd = new Stack<>();
        Stack<Character> optr = new Stack<>();

        boolean isNum = false;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            boolean digit = Character.isDigit(c);

            if (digit) {
                pushNum(opnd, isNum, c);

            } else {
                if (optr.empty()) optr.push(c);
                // order
            }

            isNum = digit;
        }

        return 0;
    }

    private static void pushNum(Stack<Integer> opnd, boolean isNum, char c) {
        if (opnd.empty()) opnd.push((int) c);

        if (isNum) {
            int n = opnd.pop() * 10 + (int) c;
            opnd.push(n);
        } else {
            opnd.push((int) c);
        }
    }

    private static char[][] priorityTable() {
        char[][] chars = new char[1][1];

        return chars;
    }

}
