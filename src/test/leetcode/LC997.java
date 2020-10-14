package test.leetcode;

import java.util.Arrays;

/**
 * @Author chenxiangge
 * @Date 2019/6/26
 */
class LC997 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }
}
