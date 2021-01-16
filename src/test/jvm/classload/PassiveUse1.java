package test.jvm.classload;

/**
 * @Author chenxiangge
 * @Date 1/16/21
 * 关于类的被动使用，即不会进行类的初始化操作 （调用<clinit>()）
 * 1、通过子类调用父类的变量，不会引起子类的初始化，会引起父类的初始化
 * 2、以数组形式创建对象时，不会进行类的初始化操作，实际设置数组对象值时才会进行类的初始化操作
 */
public class PassiveUse1 {
    //1、test1
//    public static void main(String[] args) {

//        System.out.println(Son.num);
//    }


    //1、test2
    public static void main(String[] args) {
        //以数组形式创建对象时，不会进行类的初始化操作
        Parent[] parents = new Parent[10];
        System.out.println(parents.getClass());
        //数组的父类也是Object
        System.out.println(parents.getClass().getSuperclass());

        //实际设置数组对象值时才会展示
        parents[0] = new Parent();
        //<clinit>()方法只会执行一次
        parents[1] = new Parent();
    }
}

class Parent {
    static {
        System.out.println("parent-init");
    }

    public static int num = 1;
}

class Son extends Parent {
    static {
        System.out.println("son-init");
    }
}