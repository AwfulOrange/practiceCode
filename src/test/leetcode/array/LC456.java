package test.leetcode.array;

/**
 * @Author chenxiangge
 * @Date 2021/3/27
 */
public class LC456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] res = new int[]{0, 0, 0};
        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            int num2 = nums[i+1];
            int num3 = nums[i+1];
        }


    }
}
