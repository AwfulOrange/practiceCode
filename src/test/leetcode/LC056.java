package test.leetcode;

import java.util.Arrays;

/**
 * @Author chenxiangge
 * @Date 2020/4/16
 */
public class LC056 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //先排序
            Arrays.sort(intervals);
            int[][] res = new int[intervals.length][2];
            for (int i = 0; i < intervals.length - 1; i++) {
                int[] current = intervals[i];
                int[] next = intervals[i + 1];
                if (next[0] < current[1]) {
                    intervals[i + 1][0] = current[0];
                    intervals[i + 1][1] = next[1];
                }
            }
            return res;

        }
    }
}
