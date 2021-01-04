package test.jvm.bytecode;

import java.io.File;

/**
 * @Author chenxiangge
 * @Date 2020/12/21
 */
public class NewTest {

    public void newInstance(){
        Object o = new Object();
        File file = new File("test");
    }

    public void sayHello(){
        System.out.println("hello");
    }

    public void setOrderId(){
        Order order = new Order();
        order.id = 1001;
        System.out.println(order.id);

        Order.name = "order";
        System.out.println(Order.name);
    }

    public void setArray(){
        int[] intArray = new int[10];
        intArray[3] = 20;
        System.out.println(intArray[1]);
    }
}

class Order{
    int id;
    static String name;
}