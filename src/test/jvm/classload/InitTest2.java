package test.jvm.classload;

import java.util.Random;

/**
 * @Author chenxiangge
 * @Date 1/13/21
 * 使用staic final类型修饰的字段显式赋值的操作，到底是在哪个阶段进行的赋值？
 * 1、在链接阶段的准备环节赋值
 * 2、在初始化阶段赋值
 *
 * 结论：
 * 1、链接的准备阶段赋值
 *  * 基本类型，使用static final修饰，则显式赋值（不需要对象的创建，直接赋值常量）通常在链接的准备阶段赋值
 *  * 对于String类型，使用字面量的方式赋值，使用static final修饰，则显式赋值通常在链接的准备阶段赋值
 * 2、在初始化阶段赋值
 *  * 排除以上情况之外的情况
 *
 *  最终结论：使用static final修饰，则显式赋值（不需要对象的创建，直接赋值常量）基本数据类型orStirng类型 - 链接的准备阶段赋值
 */
public class InitTest2 {
    //初始化环节<clinit>()
    public static int a = 1;
    //准备环节
    public static final int cons_a = 10;

    //引用数据类型
    //初始化阶段<clinit>()
    public static final Integer b_cons = 1;
    //初始化阶段<clinit>()
    public static Integer b = 1;

    //链接阶段
    public static final String c_cons = "hello_world";
    //初始化阶段<clinit>()
    public static final String c1_cons = new String("hello_world1");

    //初始化阶段<clinit>()
    public static final int num1 = new Random().nextInt(10);
    //链接准备阶段
    public static final int num2 = 10;

}
