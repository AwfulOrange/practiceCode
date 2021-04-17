package test.leetcode.array;

import java.util.TreeSet;

/**
 * @Author chenxiangge
 * @Date 4/17/21
 */
public class LC220 {

    /**
     * 滑动窗口解法
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicateByData(int[] nums, int k, int t) {
        //相对于LC219，此时需要的不是相等的数据，而是<=t的数据，是一个区间，可以想到应该使用排序好的数据结构
        //1.维护一个size为k的滑动窗口
        //2.维护滑动窗口内数据（排序）
        //3.如果滑动窗口内的最小值<=t 则返回结果，否则继续进行

        //由暴力解法可得，题目所提供的数据会超过int上限，于是使用long
        TreeSet<Long> set = new TreeSet<>();
        //从小到大排序

        for (int i = 0; i < nums.length; i++) {
            //寻找滑动窗口中与1最接近的值
            //abs最小，即目的是找与1最接近的值
            if (set.size() > 0) {
                Long floor = set.floor(nums[i] * 1L);
                Long ceiling = set.ceiling(nums[i] * 1L);
                if (floor != null && Math.abs(floor - nums[i]) <= t) {
                    return true;
                }
                if (ceiling != null && Math.abs(ceiling - nums[i]) <= t) {
                    return true;
                }
            }
            set.add(new Long(nums[i]));
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        //Integer
        System.out
            .println(containsNearbyAlmostDuplicateByData(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
//        System.out.println(Integer.MAX_VALUE);
//
//        [1,2,3,1]
//        3
//        0
    }
}
