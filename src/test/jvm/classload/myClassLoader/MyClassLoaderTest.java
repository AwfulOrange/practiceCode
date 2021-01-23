package test.jvm.classload.myClassLoader;

/**
 * @Author chenxiangge
 * @Date 1/22/21
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader("/usr/local/AwfulOrange/practiceCode/src/test/jvm/classload/myClassLoader/");
        Class<?> aClass = myClassLoader.loadClass("ATestClass");

        MyClassLoader myClassLoader1 = new MyClassLoader("/usr/local/AwfulOrange/practiceCode/src/test/jvm/classload/myClassLoader/");
        Class<?> aClass1 = myClassLoader1.loadClass("ATestClass");

        //不同的类加载器，加载同一个类，会生成不同的class（类的命名空间）
        //在同一个命名空间中（类的加载器）类具有唯一性
        System.out.println(aClass1 == aClass);


        //        加载此类的类的加载器是:test.jvm.classload.myClassLoader.MyClassLoader
        // 可以看到当前类的加载器为自定义类加载器MyClassLoader
        System.out.println("加载此类的类的加载器是 aClass:" + aClass.getClassLoader().getClass().getName());
        //默认父加载器为Launcher$AppClassLoader
        //        加载此类的类的加载器的父类加载器是:sun.misc.Launcher$Launcher$AppClassLoader
        System.out.println("加载此类的类的加载器的父类加载器是aClass:" + aClass.getClassLoader().getParent().getClass().getName());
    }
}
