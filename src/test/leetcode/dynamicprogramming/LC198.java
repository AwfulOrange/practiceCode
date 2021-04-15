package test.leetcode.dynamicprogramming;

/**
 * @Author chenxiangge
 * @Date 4/15/21
 */
public class LC198 {

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        /**
         * 常数值
         * f(0) = num[0];
         * f(1) = Math.max(num[0],num[1]);
         *
         * 状态转移方程（考虑第i个数字是否选择）
         * 1. 如果选择第i个数字，则不能选择 num[i-1] （根据题意，无法挑选相邻的值）
         * 先举例：f(2) = num[2] + num[0] = num[2] + f(0);
         * 2.如果不选择第i个数字
         * 先举例：f(2) = Math.max(num[0],num[1]) = f(1);
         *
         * 综上可得： f(2) = Math.max(num[2] + f(0),f(1));
         *
         * i的定义：前i个数组中的值按照题目要求得到的最大值
         * 据此推理得到状态转移方程：
         * f(i) = Math.max(num[i] + f(i-2),f(i-1));
         */
        int[] f = new int[length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            //判断是否要选择当前的这个值
            //如果选择 状态zh
            f[i] = Math.max((nums[i] + f[i - 2]), f[i - 1]);
        }
        return f[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

}
