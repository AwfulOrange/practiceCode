package test.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author chenxiangge
 * @Date 2020/4/14
 */
public class LC1346 {
    static class Solution {
        public boolean checkIfExist(int[] arr) {
            //排序数组
            Arrays.sort(arr);
            //新建set
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i] * 2) || ((arr[i] % 2 == 0) && set.contains(arr[i] / 2))) {
                    return true;
                }
                set.add(arr[i]);
            }
            return false;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {7,1,14,11};
        solution.checkIfExist(array);
    }
}
