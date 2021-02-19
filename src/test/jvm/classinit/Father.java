package test.jvm.classinit;

/**
 *        3、父类的实例化方法
 *            * super()
 *            * 按顺序执行
 *            * 子类的无参构造器
 *        e.g.调用test(),实际是调用this.test(),而此时的this指的是正在创建的对象，
 *            如果是正在创建子类，那么此时的this.test()执行的是子类的方法（面向对象多态）
 *
 *
 *
 * @Author chenxiangge
 * @Date 2/19/21
 *
 *
 */
public class Father {
    private int i = test();
    private static int j = method();
    static {
        System.out.println("1");
    }


    public Father() {
        System.out.println("2");
    }

    {
        System.out.println("3");
    }

    public int test() {
        System.out.println("4");
        return 1;
    }

    public static int method() {
        System.out.println("5");
        return 1;
    }
}
