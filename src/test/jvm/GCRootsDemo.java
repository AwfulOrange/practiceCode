package test.jvm;

/**
 * @Author chenxiangge
 * @Date 2020/8/21
 * 可以作为GC Roots的对象
 * 1、虚拟机栈（栈帧中的局部变量区，也叫做局部变量表）中引用的对象
 * 2、方法区中类静态属性引用的对象
 * 3、方法区中常量引用的对象
 * 4、本地方法栈中JNI（ Navite方法）引用的对象-线程的start方法
 */
public class GCRootsDemo {
    //2、方法区中类静态属性引用的对象
    private static GCRootsDemo demo1;
    //3、方法区中常量引用的对象
    private static final GCRootsDemo demo2 = new GCRootsDemo();

    private static void method(){
        //1、虚拟机栈（栈帧中的局部变量区，也叫做局部变量表）中引用的对象
        GCRootsDemo gcRootsDemo = new GCRootsDemo();
    }

    public static void main(String[] args) {
        method();
    }

}
