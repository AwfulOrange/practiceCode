package test.leetcode.array;

/**
 * @Author chenxiangge
 * @Date 4/8/21
 */
public class LC153 {
    public static int findMin(int[] nums) {
        //特殊情况
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[1];
            } else {
                return nums[0];
            }

        }
        for (int i = 0; i < nums.length; i++) {
            int prev = i + 1;
            int next = i - 1;
            //头
            if (i == 0) {
                prev = nums.length - 1;
                next = i + 1;
            }
            //尾
            if (i == nums.length - 1) {
                prev = i - 1;
                next = 1;
            }
            //中
            if (nums[i] < nums[prev] && nums[i] < nums[next]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        for (int i = 0; i < 10; i++) {
            System.out.println(i++);
        }
    }
}
