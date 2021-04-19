package test.leetcode.array;

/**
 * @Author chenxiangge
 * @Date 4/19/21
 */
public class LC026 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //慢指针，记录新数组已更新的状态
        //快指针，记录当前已循环到数据的某个状态
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 1;

        /**
         * 都是一个意思 i=i+1
         * ++i，先加再赋值
         * i++ 先赋值再加
         * 最后都会加上
         *
         * 1、首先，单独拿出来说++i和i++，意思都是一样的，就是i=i+1。
         * 2、如果当做运算符来说，就是a=i++或者a=++i这样的形式。情况就不一样了。
         * 先说a=i++，这个运算的意思是先把i的值赋予a，然后在执行i=i+1；
         * 而a=++i，这个的意思是先执行i=i+1，然后在把i的值赋予a；
         * 举个例子来说，如果一开始i=4。
         * 那么执行a=i++这条语句之后，a=4，i=5；
         * 那么执行a=++i这条语句之后，i=5，a=5；
         *
         *
         */
        System.out.println(++i);
        System.out.println(j++);
        System.out.println(j);
//        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

}
