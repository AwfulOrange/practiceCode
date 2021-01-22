package test.jvm.classload.myClassLoader;

/**
 * @Author chenxiangge
 * @Date 1/22/21
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/ChenXiangge/Documents/leetcode/src/test/jvm/classload/myClassLoader/");
        Class<?> aClass = myClassLoader.loadClass("ATestClass");
        //        加载此类的类的加载器是:test.jvm.classload.myClassLoader.MyClassLoader
        // 可以看到当前类的加载器为自定义类加载器MyClassLoader
        System.out.println("加载此类的类的加载器是:" + aClass.getClassLoader().getClass().getName());
        //默认父加载器为Launcher$AppClassLoader
        //        加载此类的类的加载器的父类加载器是:sun.misc.Launcher$Launcher$AppClassLoader
        System.out.println("加载此类的类的加载器的父类加载器是:" + aClass.getClassLoader().getParent().getClass().getName());
    }
}
