package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/11/4
 */
public class demo {
    private int num = 1;

    public int add() {
        num = num + 2;
        return num;
    }
}
