package test.juc.singleton;

/**
 *
 * 单例模式在多线程下可能会存在的问题
 * 懒汉式(延迟加载)的单例模式
 * @Author chenxiangge
 * @Date 2020/8/11
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance;

    //不允许外部直接调用
    private SingletonDemo() {
    }


    public static synchronized SingletonDemo getInstance() {
        //普通单例模式-存在线程安全问题
//        if (null == instance) {
//            System.out.println(Thread.currentThread().getName() + "：创建了SingletonDemo");
//            instance = new SingletonDemo();
//        }
//        return instance;

        //DCL double check lock模式（双端检锁机制）
        // 一旦已经存在instance，则无需再次加锁
        // (减少加锁次数 提高性能)
        //1、first check
        if (null == instance) {
            synchronized (SingletonDemo.class) {
                //2、second check（after synchronized lock）
                if (null == instance) {
                    System.out.println(Thread.currentThread().getName() + "：创建了SingletonDemo");
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程情况
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());


        /**
         * 多线程情况-按照这种写法单例模式并不单例
         * 解决方式1、getInstance方法用synchronized修饰 -
         *          重量级 单机版下可行 高并发情况下，整个代码块会被锁住（此种方法保证了数据的一致性，但并发性下降）
         * 解决方式2、DCL（double check lock）
         *          重量级 单机版下可行 高并发情况下，整个代码块会被锁住（此种方法保证了数据的一致性，但并发性下降）
         *          双端检锁机制不一定线程安全，原因是因为有指令重排的存在，加入volatile可以禁止指令重排
         *          instance = new SingletonDemo(); 实际可分为三步完成（伪代码）
         *             1、memory = allocate(); //分配对象内存空间
         *             2、instance(memory); // 初始化对象
         *             3、instance = memory //将初始化的对象指向被分配的内存地址，此时instance!=null
         *
         *             2、3步骤由于没有数据依赖关系，有可能被编译器进行指令重排，于是顺序可能为
         *               1、memory = allocate(); //分配对象内存空间
         *               3、instance = memory //将初始化的对象指向被分配的内存地址，此时instance=null(地址不为空，但是实际地址所对应的内容为空)
         *               2、instance(memory); // 初始化对象
         *
         * 解决方式3：在DCL模式上，使用volatile修饰instance,禁止指令重排
         *
         */
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();

        }


    }
}
