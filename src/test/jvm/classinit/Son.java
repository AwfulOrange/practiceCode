package test.jvm.classinit;

/**
 * 一、类的初始化过程
 *      1、类的初始化过程
 *      main方法所在的类需要先加载和初始化
 *      2、子类初始化时，需要先初始化父类
 *      3、一个类的初始化就是执行<clinit>()方法
 *      <clinit>()方法由静态类变量显式赋值代码和静态代码块组成
 *      两个代码块由书写顺序由上至下执行
 *      <clinit>()方法只执行一次
 *
 * 二、实例的初始化过程
 *      1、实例初始化过程就是执行<init>()方法
 *          <init>()支持重载，有几个构造器就有几个<init>()
 *          <init>()由非静态实例变量、显式赋值代码和非静态代码块，对应构造器代码组成
 *          构造器代码最后执行，其他代码按照从上倒下的顺序执行。
 *          每次创建实例对象，调用对应构造器，都执行一次<init>()方法
 *          <init>()方法的首行是super()or super(具体参数列表)，即对应父类的<init>()方法
 *      2、子类的实例化方法
 *          * super()
 *          * 按顺序执行
 *          * 子类的无参构造器
 *
 *
 *
 * @Author chenxiangge
 * @Date 2/19/21
 */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("6");
    }


    public Son() {
        //super()子类的构造器中一定会调用父类的构造器-隐式调用
        System.out.println("7");
    }

    {
        System.out.println("8");
    }

    @Override
    public int test() {
        System.out.println("9");
        return 1;
    }

    public static int method() {
        System.out.println("10");
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("after-init");
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();

    }
}
