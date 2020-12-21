package test.leetcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author chenxiangge
 * @Date 2020/4/1
 */
public class MyInvocationHandler implements InvocationHandler {
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        Object ob = method.invoke(target,args);
        System.out.println("结束代理");
        return ob;
    }
}
