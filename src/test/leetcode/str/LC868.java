package test.leetcode.str;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author chenxiangge
 * @Date 2019/9/20
 */
public class LC868 {
    public static int binaryGap(int N) {
        String binaryStr = Integer.toBinaryString(N);
        char[] arrays = binaryStr.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == '1') {
                list.add(i);
            }
        }
        if (list.size() <= 1) {
            return 0;
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <= list.size() - 2; i++) {
            resultList.add(list.get(i + 1) - list.get(i));
        }
        resultList = resultList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return resultList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1010));
        System.out.println(binaryGap(1010));
    }
}
