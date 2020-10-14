package test.leetcode.dynamicprogramming;

/**
 * @Author chenxiangge
 * @Date 2020/4/15
 */
public class LC53 {
    /**
     * 动态规划方式实现
     * 分解成最优子问题
     * 写出状态转移方程
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            //记录中最高的累加和
            int maxSum = nums[0];
            //本次的累加和
            int sum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                sum = Math.max(nums[i] + sum, nums[i]);
                maxSum = Math.max(sum, maxSum);
            }
            return maxSum;

        }
    }

    public static void main(String[] args) {
        int[] sum = {-2,1,-3,4,-1,2,1,-5,4};

    }
}
