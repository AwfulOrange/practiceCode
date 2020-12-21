package test.os;

import java.math.BigInteger;

/**
 * @Author chenxiangge
 * @Date 2020/12/1
 */
public class HexToBin {
    public static void main(String[] args) {
        String intVal ="00359141";
        String floatVal = "4a564504";
        System.out.println("int:"+ hex2bin(intVal));
        System.out.println("float:"+ hex2bin(floatVal));
        /**
         * 移动相对位置 使两者匹配的位数最多
         * 串中的什么部分匹配 什么部分不匹配？
         *        1101011001000101000001
         * 1001010010101100100010100000100
         */
    }

    private static String hex2bin(String s){
        return new BigInteger(s,16).toString(2);
    }
}
