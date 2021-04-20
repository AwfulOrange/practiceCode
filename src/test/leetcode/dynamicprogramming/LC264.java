package test.leetcode.dynamicprogramming;

/**
 * @Author chenxiangge
 * @Date 2021/4/10
 */
public class LC264 {
    public int nthUglyNumber(int n) {
        //动态规划解答
        //已知f(1) = 1
        //p2,p3,p5分别是当前的因数2，3，5所在的点
        //f(n) = min(f(p2)*2 + f(p3)*3+ f(p5)*5)
        //如果最小值未其中之一，则因数所对应的指针加1，并将其放入数组
        int[] a = new int[n];
        a[0] = 1;
        int p5 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 1; i < n; i++) {
            int fp2 = a[p2] * 2;
            int fp3 = a[p3] * 3;
            int fp5 = a[p5] * 5;
            a[i] = Math.min(Math.min(fp2, fp3), fp5);
            if (a[i] == fp2) {
                p2++;
            }
            if (a[i] == fp3) {
                p3++;
            }
            if (a[i] == fp5) {
                p5++;
            }
        }
        return a[n - 1];
    }
}
