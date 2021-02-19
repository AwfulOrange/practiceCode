package test.leetcode.dynamicprogramming.LC60;

/**
 * 循环解法
 *
 * @Author chenxiangge
 * @Date 2/19/21
 */
public class loop {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        //将问题分解为最后走一步还是最后走2步
        //走一步解法f(n-1), 走2步解法f(n-2)
        int one = 2;
        int two = 1;
        int sum = 0;

        for (int i = 3; i < n + 1; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}
