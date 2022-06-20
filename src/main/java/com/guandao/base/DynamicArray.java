package com.guandao.base;

/**
 * 动态数组接口
 */
public interface DynamicArray<E> {

    /** 添加一个元素到末尾 */
    int add(E e);

    /** 在指定索引位置, 插入一个元素 */
    int insert(int idx, E e);

    /** 移除指定索引位置的元素 */
    E remove(int idx);

    /** 移除第一个遇到的元素 */
    int remove(E e);

    /** 将指定位置的元素改为指定值 */
    E set(int idx, E e);

    /** 获取指定位置的元素 */
    E get(int idx);

    /** 查询第一次出现该元素的索引位置 */
    int find(E e);

    /** 是否包含指定的元素 */
    boolean contains(E e);

    /** 数组元素总数 */
    int size();

    /** 数组是否为空 */
    boolean empty();
}
