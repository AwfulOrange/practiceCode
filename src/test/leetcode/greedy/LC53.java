package test.leetcode.greedy;

/**
 * @Author chenxiangge
 * @Date 2020/4/15
 */
public class LC53 {
    /**
     * 贪心算法的实现
     * 每步都预期是最好的
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
