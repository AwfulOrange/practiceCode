package test.leetcode.greedy;

/**
 * @Author chenxiangge
 * @Date 2020/4/14
 */

/**
 * 贪心算法：最优解=局部最优解
 *
 * 在每一步总是做出在当前看来最好的选择。
 *      - 寄希望于这样能获得全局最优解
 *
 */
public class LC122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int result =0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    result += prices[i + 1] - prices[i];
                }
            }
            return result;

        }
    }
}
