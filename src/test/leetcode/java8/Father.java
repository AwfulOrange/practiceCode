package test.leetcode.java8;

/**
 * @Author chenxiangge
 * @Date 2020/6/24
 */
public class Father {

    private final String test = "test";
    private String a;

    public String getTest() {
        return test;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    private void method(){
        System.out.println("this is a private method");
    }
}

class Son extends Father{

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.getClass().getMethods());
    }
}



