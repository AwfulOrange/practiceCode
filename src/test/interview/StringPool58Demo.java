package test.interview;

/**
 * @Author chenxiangge
 * @Date 2021/1/23
 */
public class StringPool58Demo {
    public static void main(String[] args) {
        /**
         * intern()方法-native方法
         * 若当前字符串存在字符串常量池中，则直接返回常量池中str，否则在常量池中新建当前字符串
         */
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
//        //？
        System.out.println(str1 == str1.intern());
//
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        //sun.misc.Version.init() 此方法会声明"java"字符串 该方法中的其他字符串也同理
        //加载sun.misc.Version类时会将"java"字符串加载到字符串常量池中（JDK自带）

        System.out.println(str2 == str2.intern());

    }
}
