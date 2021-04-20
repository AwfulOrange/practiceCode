package test.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 2021/3/28
 */
public class LC1047 {
    public static String removeDuplicates(String S) {
            char[] chars = S.toCharArray();
            if (chars.length == 1) {
                return S;
            }
            List<Character> res = new ArrayList<>();
            if (chars[0] != chars[1]) {
                res.add(chars[0]);
                res.add(chars[1]);
            }
            for (int i1 = 2; i1 < chars.length; i1++) {
                if (res.size() > 0 && res.get(res.size() - 1) == chars[i1]) {
                    res.remove(res.size() - 1);
                }else{
                    res.add(chars[i1]);
                }
            }
            String resStr = "";
            for (Character re : res) {
                resStr += re.toString();
            }
            return resStr;

        }
}
