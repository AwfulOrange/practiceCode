package test.interview.i2021;

import java.util.Arrays;

/**
 * 方法的参数传递机制
 * 1、基本数据类型传递值
 * 2、引用数据类型传递地址（String，包装类型不可变，一旦产生改变则会创建一个新的对象-地址发生改变）
 * @Author chenxiangge
 * @Date 2/19/21
 */
public class ParameterPassDemo {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer sum = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData myData = new MyData();

        change(i, str, sum, arr, myData);

        System.out.println(i);
        System.out.println(str);
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));
        System.out.println(myData.a);

        /**
         * 1
         * hello
         * 200
         * [2, 2, 3, 4, 5]
         * 11
         */


    }

    public static void change(int i, String str, Integer sum, int[] arr, MyData a) {
        i = i + 1;
        str += "world";
        sum += 1;
        arr[0] += 1;
        a.a += 1;
    }
}

class MyData {
    int a = 10;
}
