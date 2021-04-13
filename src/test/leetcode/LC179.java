package test.leetcode;

import java.util.Arrays;

/**
 * @Author chenxiangge
 * @Date 4/12/21
 */
public class LC179 {
    public static String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "0";
        }
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        //本来想按照字典序倒序排
        //但是 e.g.30 & 3的情况下(长度不同，首位相同，但末位为0的情况下)，字典序排序得到 30>3,所以不能直接比较 要考虑组合之后的大小是怎么比较的，否则不能拿到最大值
        //Arrays.sort(array, Comparator.comparing(Object::toString).reversed());
        Arrays.sort(array, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);

        });
        //拼接数组
        //如果最大的值是0，则证明这个数据都是0，直接返回0
        if (array[0].equals("0")) {
            return "0";
        }
        String res = "";
        for (String s : array) {
            res += s;
        }
        return res;
    }
}
