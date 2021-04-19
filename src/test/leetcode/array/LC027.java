package test.leetcode.array;

/**
 * @Author chenxiangge
 * @Date 4/19/21
 */
public class LC027 {

    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                //设置为99，再进行排序即可
                nums[i] = 99;
                length++;
            }
        }

        //冒泡进行排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums.length - length;

    }

}
