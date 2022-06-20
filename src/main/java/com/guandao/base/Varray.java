package com.guandao.base;

/**
 * 动态数组的实现
 */
public class Varray<E> implements DynamicArray<E> {

    // 定义一个最大的扩容阈值：当达到该阈值后，不再加倍扩容，而是直接给出数组最大大小
    private static final int MAX_REDOUBLE = 1 << 30;

    // 定义一个数组的初始容量：8
    private static final int INIT_CAPACITY = 8;

    // 数组中实际数据的大小
    int size;

    // 内部数组
    Object[] data;

    public Varray() {
        this(INIT_CAPACITY);
    }

    public Varray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity less than 0");
        this.size = 0;
        this.data = new Object[capacity];
    }

    @Override
    public int add(E e) {
        // 直接最佳到数组末尾
        return insert(size, e);
    }

    @Override
    public int insert(int idx, E e) {
        if (idx < 0 || idx > size) throw new ArrayIndexOutOfBoundsException();

        // 数据大小达到数组容量时，进行扩容
        if (size >= data.length) redouble();

        // 从指定索引位置开始，一直到数据总量处，全部数据后移一次
        for (int i = size - 1; i >= idx; i--) {
            data[i + 1] = data[i];
        }

        // 将新插入的数据存入指定索引处
        data[idx] = e;

        // 更新数据大小
        size++;

        return idx;
    }

    private void resize(int capacity) {
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /* 不能无限扩容，当达到最大倍增阈值时，直接取最大 Integer.MAX_VALUE */
    private void redouble() {
        if (data.length == Integer.MAX_VALUE) throw new OutOfMemoryError();
        int capacity = data.length < MAX_REDOUBLE ? (data.length << 1) : Integer.MAX_VALUE;
        resize(capacity);
    }

    /* 注意边界：数组不能无限缩，只有在大于初始容量时才可能会进行缩容 */
    private void reduce() {
        if (data.length > INIT_CAPACITY && data.length / size == 2) {
            resize(data.length / 2);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int idx) {
        if (idx < 0 || idx >= size) throw new ArrayIndexOutOfBoundsException();

        Object o = data[idx];

        // 从指定索引下一个元素位置处开始，全部元素向前移一次
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // 最后一个元素索引置为null
        data[--size] = null;

        // 如何缩容
        reduce();

        // 返回原索引处元素
        return (E) o;
    }

    @Override
    public int remove(E e) {
        int idx = find(e);
        if (idx != -1) remove(idx);
        return idx;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int idx, E e) {
        if (idx < 0 || idx >= size) throw new ArrayIndexOutOfBoundsException();

        Object o = data[idx];
        data[idx] = e;
        return (E) o;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int idx) {
        if (idx < 0 || idx >= size) throw new ArrayIndexOutOfBoundsException();
        return (E) data[idx];
    }

    @Override
    public int find(E e) {
        // 按序查找，找到返回该元素的索引位置
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) return i;
        }
        // 找不到返回-1
        return -1;
    }

    @Override
    public boolean contains(E e) {
        // 可直接调用 find 方法查找，能找到说明包含
        return find(e) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(get(i)).append(", ");
        }

        int len = sb.length();
        int end = len > 2 ? len - 2 : len;
        return "Varray : [" + sb.substring(0, end) + "]";
    }

}
