package test.leetcode.stack;

/**
 * @Author chenxiangge
 * @Date 2019/8/1
 */
public class LC402 {
    public String removeKdigits(String num, int k) {
        if (num.length() < k) {
            return "0";
        }
        for (int i = 0; i < k; i++) {
            num = removeOneHigherDigit(num);
        }
        int zeroCount = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                break;
            }
            if (num.charAt(i) == '0') {
                zeroCount++;
            }
        }
        num = num.substring(zeroCount);
        if (num.length() == 0) {
            return "0";
        }
        return num;

    }

    private String removeOneHigherDigit(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                return num.substring(0, i) + num.substring(i + 1);//删掉i位置的字符
            }

        }
        return num.substring(0, num.length() - 1);

    }
}
