package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/12/19
 */
public class ClassCastTest {
    public static void main(String[] args) {
        UpCast();
        downCast3();
    }

    //精度丢失问题
    public static void UpCast(){
        int i = 123123123;
        float f = i;
        //1.2312312E8 - 最后一位精度损失
        // -> 123123120
        System.out.println(f);
    }

    //byte/short类型转换为大容量类型
    //byte/short等类型被视为int类型
    public static void UpCast3(byte b){
        int i = b;
        long j = b;
        double d = b;
    }

    //窄化类型转换精度损失
    public static void downCast3(){
        int i =128;
        //-128
        byte b = (byte) i;
        System.out.println(b);
    }
}
