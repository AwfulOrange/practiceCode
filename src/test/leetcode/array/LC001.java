package test.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenxiangge
 * @Date 2021/1/23
 */
public class LC001 {
    /**
     * 1、暴力解法
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (a + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                        break;
                    }
                }
            }
            return res;

        }
    }

    /**
     * 优化解法-一次循环（hash解法）
     *
     * nums = [2,7,11,15], target = 9
     */
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = target - nums[i];
                if (map.containsKey(num)) {
                    return new int[]{map.get(num), i};
                }
                map.put(nums[i], i);
            }
            //map中的值 key value
            //          2    0
            //          2    1
            return null;
        }
    }
}
