package test.leetcode.dynamicprogramming.LC60;

/**
 * 递归解法(耗时太长-无法通过)
 *
 * f(1) = 1
 * f(2) = 2
 * <p>
 * f(3)=f(2)+f(1)
 * <p>
 * ...
 * f(n) = f(n-1)+f(n-2)
 *
 * @Author chenxiangge
 * @Date 2/19/21
 */
public class recursion {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
