package com.guandao.base;

public class Stacked<E> {

    DynamicArray<E> data;

    public Stacked() {
        this.data = new Varray<>();
    }

    public int push(E e) {
        return data.add(e);
    }

    public E peek() {
        int size = data.size();
        return data.get(size - 1);
    }

    public E pop() {
        int size = data.size();
        return data.remove(size - 1);
    }

    public int size() {
        return data.size();
    }

    public boolean empty() {
        return data.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i)).append(", ");
        }

        int len = sb.length();
        int end = len - 2 > 0 ? len - 2 : len;
        return "Stacked:[" + sb.substring(0, end) + "]";
    }

}
