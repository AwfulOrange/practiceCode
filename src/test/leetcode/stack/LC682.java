package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2019/7/30
 */
public class LC682 {
    static class Solution {

        public int calPoints(String[] ops) {
            //已进行的操作
            Stack<Integer> finishOp = new Stack<>();
            int res = 0;
            for (int i = 0; i < ops.length; i++) {
                if (ops[i].equals("C")) {
                    res -= finishOp.pop();
                } else if (ops[i].equals("D")) {
                    res += finishOp.peek() * 2;
                    finishOp.push(finishOp.peek() * 2);
                } else if (ops[i].equals("+")) {
                    //上次的保存pop出去了，需要再push回来
                    int pushBackInt = finishOp.pop();
                    int pushInt = pushBackInt + finishOp.peek();
                    finishOp.push(pushBackInt);
                    res += pushInt;
                    finishOp.push(pushInt);
                } else {
                    res += Integer.parseInt(ops[i]);
                    finishOp.push(Integer.parseInt(ops[i]));
                }

            }
            return res;
        }
    }

    public static void main(String[] args) {
        //["5","2","C","D","+"]
//        ["5","-2","4","C","D","9","+","+"]
        String[] ops = new String[8];
        ops[0] = "5";
        ops[1] = "-2";
        ops[2] = "4";
        ops[3] = "C";
        ops[4] = "D";
        ops[5] = "9";
        ops[6] = "+";
        ops[7] = "+";

        Solution s = new Solution();
        System.out.println(s.calPoints(ops));
    }
}
