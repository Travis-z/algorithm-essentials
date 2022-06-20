package com.guandao.base;

/**
 * Stack
 * @param <E>
 */
public class Stack<E> {

    private int idx;
    private final Varray<E> arr;

    public Stack() {
        this.idx = -1;
        this.arr = new Varray<>();
    }

    public void push(E e) {
        arr.set(++idx, e);
    }

    public E pop() {
        if (empty()) throw new ArrayIndexOutOfBoundsException();
        return arr.get(idx--);
    }

    public E peek() {
        if (empty()) throw new ArrayIndexOutOfBoundsException();
        return arr.get(idx);
    }

    public boolean empty() {
        return idx < 0;
    }

    public int size() {
        return idx + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
            sb.append(arr.get(i)).append(", ");
        }
        int len = sb.length();
        return "Stack:[" + sb.substring(0, len > 2 ? (len - 2) : len) + "]";
    }

}
