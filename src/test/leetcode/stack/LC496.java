package test.leetcode.stack;

/**
 * @Author chenxiangge
 * @Date 2019/7/29
 */
// TODO: 2019/7/29 不太对，需要修改
public class LC496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] numRes = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if(nums1[i] < nums2[j]){
                        numRes[i] = nums2[j];
                        break;
                    }
                    if(nums1[i] >= nums2[j] && j == nums2.length){
                        numRes[i] = -1;
                    }
                }
            }
            return numRes;

        }
    }
}
