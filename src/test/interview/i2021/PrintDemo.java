package test.interview.i2021;

/**
 * 张三李四王五，输出成
 * 三张
 * 四李
 * 五王
 *
 * @Author chenxiangge
 * @Date 2/23/21
 */
public class PrintDemo {
    public static void main(String[] args) {
        String origin = "张三，李四，王五";
        String[] split = origin.split("，");
        for (String s : split) {
            System.out.println(reverse(s));
        }
    }

    private static String reverse(String a) {
        char[] chars = a.toCharArray();
        String newStr = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            newStr += chars[i];
        }
        return newStr;
    }
}
