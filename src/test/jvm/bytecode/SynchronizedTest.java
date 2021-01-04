package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/12/28
 */
public class SynchronizedTest {
    private int i;

    public synchronized void add(){
        i++;
    }


    /**
     *  0 new #3 <java/lang/Object>
     *  3 dup
     *  4 invokespecial #1 <java/lang/Object.<init>>
     *  7 astore_1
     *  8 aload_1
     *  9 dup
     * 10 astore_2
     * 11 monitorenter
     * 12 aload_0
     * 13 dup
     * 14 getfield #2 <test/jvm/bytecode/SynchronizedTest.i>
     * 17 iconst_1
     * 18 iadd
     * 19 putfield #2 <test/jvm/bytecode/SynchronizedTest.i>
     * 22 aload_2
     * 23 monitorexit   -- 无论发生什么 都需要保证锁的释放
     * 24 goto 32 (+8)
     * 27 astore_3
     * 28 aload_2
     * 29 monitorexit -- 无论发生什么 都需要保证锁的释放 double-check
     * 30 aload_3
     * 31 athrow
     * 32 return
     */
    public void add2(){
        Object o = new Object();
        synchronized (o){
            i++;
        }
    }
}
