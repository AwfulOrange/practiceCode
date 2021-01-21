package test.jvm.classload;

/**
 * 类的显式加载&隐式加载
 *
 * @Author chenxiangge
 * @Date 1/16/21
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        //隐式加载
        ClassLoadTest classLoadTest = new ClassLoadTest();


        try {
            //显式加载-1
            Class aClass = Class.forName("test.jvm.classload.ClassLoadTestClass");
            //显式加载-2
            ClassLoader.getSystemClassLoader().loadClass("test.jvm.classload.ClassLoadTestClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class ClassLoadTestClass {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
