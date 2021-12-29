package com.guandao.table.array;

public class ArrayAlg {

    public static void main(String[] args) {
//        System.out.println(removeDuplicates2_1(new int[] {1,1,2,2,2,2,3,3,4,5,5,5,5}));
//        System.out.println(removeDuplicates(new int[] {1,2,2,3}));
    }

    /**
     * Longest Consecutive Sequence
     *
     * 描述
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * For example, Given [100, 4, 200, 1, 3, 2] , The longest consecutive elements sequence is [1, 2, 3, 4] . Return its length: 4.
     * Your algorithm should run in O(n) complexity
     */
    public static int longestConsecutive(int[] nums) {
        return 0;
    }


    /**
     * 更简洁的版本。
     * 2-1版本的代码略长，不过扩展性好一些，例如将 occur < 2 改为 occur < 3，就变成了允许重复最多3次
     */
    public static int removeDuplicates2_2(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && i < n - 1 && nums[i] == nums[i - 1] && nums[i] == nums[i + 1])
                continue;
            nums[index++] = nums[i];
        }
        return index;
    }

    /**
     * 描述：
     * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
     * For example, given sorted array A = [1,1,1,2,2,3] , your function should return length = 5 , and A is now [1,1,2,2,3]
     *
     * 要求：
     *  排序数组中的元素，最多可以出现两次
     *
     * 思路：
     *  添加一个变量，记录元素出现的次数，避免同元素超过2次
     *  该变量在小于等于2时，不起作用;
     *  该变量在大于等于3时，会被重置;
     *  如果该变量就是常量2，则元素出现的次数不能大于它 ==>
     *  即 nums[idx+2] != nums[idx] ==> nums[idx] != nums[idx-2]
     *
     * 分析：
     *  加一个变量记录一下元素出现的次数即可。这题因为是已经排序的数组，所以一个变量即可解决。如果是
     *  没有排序的数组，则需要引入一个hashmap来记录出现次数
     *
     * 解决：
     *  Time complexity: O(n), Space Complexity: O(1)
     */
    public static int removeDuplicates2_1(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int index = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }


    /**
     * Remove Duplicates from Sorted Array
     *
     * 描述：
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * For example, Given input array A = [1,1,2] ,
     * Your function should return length = 2, and A is now [1,2] .
     *
     * 要求：
     *  对排期数组，进行去重，且不分配额外的空间: S(n) = O(1)
     *
     * 思路：
     *  1, 如果不分配额外的空间，那么去重后的新数组, 必然要覆盖原数组
     *  2, 那么新数组的长度, 必然要单独计算，避免采用原数组的长度 arr.length
     *
     * 解决：
     *  Time complexity: O(n)，Space complexity: O(1)
     */
    public static int removeDuplicates1_1(int[] nums) {
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
