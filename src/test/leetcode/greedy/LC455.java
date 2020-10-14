package test.leetcode.greedy;

import java.util.Arrays;

/**
 * @Author chenxiangge
 * @Date 2020/4/14
 */
public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        //先排序
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length){
            if (g[child] <= s[cookie]) {
                child ++;
            }
            cookie++;
        }
        return child;

    }
}
