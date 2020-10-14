package test.leetcode.dynamicprogramming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author chenxiangge
 * @Date 2020/4/15
 */
class Solution {
    /**
     * dp
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            //重点是推导出状态分析方程
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
    }
}
