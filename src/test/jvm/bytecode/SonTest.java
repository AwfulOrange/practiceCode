package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/10/28
 *
 * 成员变量的初始化过程（按顺序）
 * 1、默认初始化
 * 2、显式初始化
 * 3、构造器中初始化/代码块中初始化
 * 4、有了对象之后（非静态），可以通过 【对象.属性】 【对象.方法】进行成员变量的赋值
 */
public class SonTest {
    public static void main(String[] args) {
        Father f = new Son();
//        Father f = new Father();
        System.out.println(f.x);
//
        //1、调用son的构造器前，需要调用父类的构造器
        //1.1 调用类父类的构造器
        //1.2 son类重写了father的print方法，此时执行的print方法以son类中重写的为准,所以打印：son.x=
        //1.3 此时son中的x还未被初始化，所以x=0


        //2、调用son类的print方法 此时x已被初始化
        //3、调用赋值之后的print方法（属性不存在多态性，实际打印的是father类中的变量）

        //1、son.x=0
        //2、son.x=30
        //3、20

    }
}

class Father {
    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("FAther.x = " + x);
    }
}

class Son extends Father{
    int x = 30;
    public Son(){
        //调用son的构造器前，需要调用父类的构造器
        //father调用father的print() 方法
        //son类重写了print()方法，但此时调用的时候 *x还未初始化*
        //调用的是son类的print方法
        this.print();
        x=40;
    }
    @Override
    public void print(){
        System.out.println("son.x="+x);
    }
}
