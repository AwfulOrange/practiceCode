package test.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenxiangge
 * @Date 2019/9/20
 */
public class LC13 {
    static class Solution {
        private static final Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};

        public static int romanToInt(String s) {
            Integer result = 0;
            if (s.contains("IV")) {
                s = s.replace("IV", "");
                result += 4;
            }
            if (s.contains("IX")) {
                s = s.replace("IX", "");
                result += 9;
            }
            if (s.contains("XL")) {
                s = s.replace("XL", "");
                result += 40;
            }
            if (s.contains("XC")) {
                s = s.replace("XC", "");
                result += 90;
            }
            if (s.contains("CD")) {
                s = s.replace("CD", "");
                result += 400;
            }
            if (s.contains("CM")) {
                s = s.replace("CM", "");
                result += 900;
            }
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length && array.length > 0; i++) {
                result += map.get(String.valueOf(array[i]));
            }
            return result;
        }
    }
    public static void main(String[] args) {
        System.out.println(Solution.romanToInt("MCMXCIV"));
    }
}
