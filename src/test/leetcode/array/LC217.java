package test.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author chenxiangge
 * @Date 4/17/21
 */
public class LC217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean add = set.add(nums[i]);
            if (!add) {
                return true;
            }
        }
        return false;
    }

}
