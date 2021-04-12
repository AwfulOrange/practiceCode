package test.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 3/31/21
 */
public class LC078 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        //二进制解法
        //可以理解为举出位数为nums.length的二进制的所有可能性
        //e.g. 3位的二进制数有8种可能性
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            //每次开始直接清空
            temp.clear();
            //循环获取当前mask每一位的值（如果当前位为1，则放入temp中）
            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }
            //加入到结果集中
            res.add(temp);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        subsets(a);
    }
}
