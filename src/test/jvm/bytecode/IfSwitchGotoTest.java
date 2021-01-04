package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/12/26
 */
public class IfSwitchGotoTest {
    //case值连续的switch
    public void switch1(int select) {
        int num;
        /**
         *  1 tableswitch 1 to 3	1:  28 (+27)
         * 	2:  34 (+33)
         * 	3:  40 (+39)
         * 	default:  46 (+45)
         */

        switch (select) {
            case 1:
                num = 10;
                break;
            case 2:
                num = 20;
                break;
            case 3:
                num = 30;
                break;

            default:
                num = 40;
        }
    }

    //case值不连续的switch
    public void switch2(int select) {
        int num;
        /**
         * switch中不连续，字节码会从小到达连续排列
         *  1 lookupswitch 3
         * 	100:  36 (+35)
         * 	200:  48 (+47)
         * 	500:  42 (+41)
         * 	default:  54 (+53)
         */
        switch (select) {
            case 100:
                num = 10;
                break;
            case 500:
                num = 20;
                break;
            case 200:
                num = 30;
                break;

            default:
                num = 40;
        }
    }

    //jdk7新特性 switch引入string类型
    public void switch3(String season) {
        /**
         * 将string类型转换为hashcode再放入switch进行比较（实际上还是数字的比较）
         *
         *  invokevirtual #2 <java/lang/String.hashCode>
         *   8 lookupswitch 4
         * 	-1842350579:  52 (+44)
         * 	-1734407483:  94 (+86)
         * 	-1139657299:  66 (+58)
         * 	1941980694:  80 (+72)
         * 	default:  105 (+97)
         */

        switch (season) {
            case "SPRING":
                break;
            case "SUMMBER":
                break;
            case "AUTUMN":
                break;
            case "WINTER":
                break;
        }
    }

    //无条件跳转指令
    public void whileInt() {

        /**
         *  字节码指令没有循环，通过比较指令&无条件跳转指令实现循环
         *
         *  0 iconst_0
         *  1 istore_1
         *  2 iload_1
         *  3 bipush 100
         *  5 if_icmpge 17 (+12)
         *  8 ldc #8 <abc>
         * 10 astore_2
         * 11 iinc 1 by 1
         * 14 goto 2 (-12)
         * 17 return
         */
        int i = 0;
        while (i < 100) {
            String a = "abc";
            i++;
        }
    }

    public void printFor() {
        short j;
        for (j = 0; j < 100; j++) {
            String s = "abc";
        }
    }
}
