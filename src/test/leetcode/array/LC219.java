package test.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 本题的重点在于快速求滑动窗口内的最大值和最小值。常见的方法有：
 *
 * 使用 multiset、TreeMap等数据结构；
 * 单调递增队列或者单调递减队列；
 *
 * @Author chenxiangge
 * @Date 4/17/21
 */
public class LC219 {

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;

    }


    /**
     * hash解法（维护长度为K的hashset，如果超过k个，就删除第一个 ）
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateByHash(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                //如果已存在，表示k个范围内有值
                return true;
            }
            set.add(nums[i]);
            //判断是否大于k个，如果大于k个，则删除第一个元素
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }


}
