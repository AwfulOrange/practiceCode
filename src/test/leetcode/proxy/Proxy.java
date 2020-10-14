package test.leetcode.proxy;

/**
 * @Author chenxiangge
 * @Date 2020/4/1
 */
public class Proxy implements Obj {
    private Obj obj;

    public Proxy() {
        System.out.println("代理类构造器");
//        obj = new ObjImpl();
    }

    @Override
    public void run() {
        System.out.println("开始代理");
        obj.run();
        System.out.println("结束代理");

    }
}
