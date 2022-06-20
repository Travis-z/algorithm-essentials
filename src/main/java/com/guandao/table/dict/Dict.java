package com.guandao.table.dict;

import java.util.HashMap;
import java.util.Map;

public class Dict<K, V> {

    static final int DEFAULT_INITCAP = 16;

    static final int MAX_CAP = 1 << 30;

    static final float DEFAULT_FACTOR = 0.75f;

    static final int THRESHOLD = 8;


    int size;
    int initCap;
    int cap;
    float factor;
    int thrd;

    Node<K, V>[] tab;

    public Dict() {
        this(DEFAULT_INITCAP, DEFAULT_FACTOR);
    }

    public Dict(int initCap, float factor) {
        if (initCap < 0) throw new IllegalArgumentException();
        if (factor <= 0 || !Float.isFinite(factor)) throw new IllegalArgumentException();

        this.initCap = tabSize(initCap);

        this.factor = factor;
        this.size = 0;
        this.thrd = THRESHOLD;
        this.tab = new Node[initCap];
    }

    int tabSize(int cap) {
        int n = Integer.highestOneBit(cap);
        return n == 0 ? 1 :
                n >= MAX_CAP ? MAX_CAP :
                        cap <= n ? n : n << 1;
    }

    int idx(K k) {
        return (DEFAULT_INITCAP - 1) & hash(k);
    }

    /** K的hashCode：高16位 ^ 低16位 : 得到0~15的值 */
    int hash(K k) {
        int i;
        return k == null ? 0 : (i = k.hashCode()) ^ (i >>> 16);
    }


    public V put(K k, V v) {
        return null;
    }


    static class Node<K, V> {
        int hash;
        K k;
        V v;
        Node<K, V> next;

        public Node(int hash, K k, V v, Node<K, V> next) {
            this.hash = hash;
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> a = new HashMap<>();
        a.put("a", 1);
        System.out.println(a);
    }

}
