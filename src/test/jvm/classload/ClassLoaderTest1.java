package test.jvm.classload;

/**
 * @Author chenxiangge
 * @Date 1/18/21
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //sun.misc.Launcher$ExtClassLoader@6e0be858
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //null - 无法拿到启动类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //
        try {
            //系统类-null-bootstrap classloader
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            //自定义类：sun.misc.Launcher$AppClassLoader@18b4aac2
            ClassLoader classLoader2 = Class.forName("test.jvm.classload.ClassLoaderTest1").getClassLoader();
            System.out.println(classLoader2);

            //关于数组类型的加载
            String[] arr = new String[10];
            //系统类-null-bootstrap classloader(与数组当中元素类型的类加载器保持一致)
            System.out.println(arr.getClass().getClassLoader());

            //关于数组类型的加载
            ClassLoaderTest1[] arr1 = new ClassLoaderTest1[10];
            //sun.misc.Launcher$AppClassLoader@18b4aac2(与数组当中元素类型的类加载器保持一致)
            System.out.println(arr1.getClass().getClassLoader());

            //基本类型
            int[] arr3 = new int[10];
            //null-基本数据类型不需要类的加载器（没有类的加载器）
            System.out.println(arr3.getClass().getClassLoader());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
