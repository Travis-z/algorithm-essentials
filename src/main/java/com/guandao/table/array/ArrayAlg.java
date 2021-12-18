package com.guandao.table.array;

public class ArrayAlg {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,2,2,3}));
    }

    /**
     * Remove Duplicates from Sorted Array
     *
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return
     * the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * For example, Given input array A = [1,1,2] ,
     * Your function should return length = 2, and A is now [1,2] .
     *
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    
}
