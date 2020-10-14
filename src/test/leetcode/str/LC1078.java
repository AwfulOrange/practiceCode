package test.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 2019/9/20
 */
public class LC1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] originText = text.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < originText.length - 2; i++) {
            if (originText[i].equals(first) && originText[i + 1].equals(second)) {
                result.add(originText[i + 2]);
            }
        }
        String[] resStr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resStr[i] = result.get(i);
        }
        return resStr;
    }
}
