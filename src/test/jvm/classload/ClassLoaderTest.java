package test.jvm.classload;

import sun.misc.Launcher;

import java.net.URL;
import java.security.Provider;

/**
 * @Author chenxiangge
 * @Date 1/18/21
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("********启动类加载器********");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
        ClassLoader classLoader = Provider.class.getClassLoader();
        //返回结果：null（使用的是引导类加载器，引导类加载器是JVM的一部分，并不是JAVA层面的代码，所以获取不到）
        System.out.println(classLoader);

        System.out.println("********拓展类加载器********");
        String property = System.getProperty("java.ext.dirs");
        String[] split = property.split(",");
        for (String s : split) {
            System.out.println(s);
        }

        //在打印路径中寻找随机找到一个拓展类加载器加载的类
        ClassLoader classLoader1 = com.sun.nio.zipfs.ZipDirectoryStream .class.getClassLoader();
        //打印结果：sun.misc.Launcher$ExtClassLoader@1d44bcfa
        System.out.println(classLoader1);

        //当前线程类加载器=AppClassLoader
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.currentThread().getContextClassLoader());


    }
}
