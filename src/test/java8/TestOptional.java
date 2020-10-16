package test.java8;

import test.java8.vo.TestVo;

import java.util.Optional;

/**
 *
 * Optional.of(null);
 * Optional.empty();
 * Optional.ofNullable(null);
 * isPresent();
 * orElse(T t);
 * orElseGet(Supplier s); 对象如果包含值，则返回对应值，若不包含值 返回supplier所产生的值
 * map(Function f); 如果有值，对其进行处理，并返回处理后的Optional 否则返回Optional.empty()
 * flatMap(Function f); 与map类似，要求返回值必须为Optional<>
 *
 * @Author chenxiangge
 * @Date 2020/10/16
 */
public class TestOptional {
    public static void main(String[] args) {
        Optional optional = Optional.of(new TestVo());

        /**
         * 快速定位空指针位置 - of不能构建null
         * */
//        Optional optionalNull = Optional.of(null);

        /**
         * empty 可以构建空，发生npe时可以快速知道错误位置
         */
//        Optional<Object> empty = Optional.empty();
//        System.out.println(empty.get());

        /**
         * ofNullable同 empty
         */
        Optional<Object> o = Optional.ofNullable(null);
        /**
         * isPresent
         */
        if (o.isPresent()) {
            System.out.println(o.get());
        }

        /**
         * orElseGet
         */
        Object o1 = o.orElseGet(TestVo::new);
        System.out.println(o1);


        Optional<TestVo> o2 = Optional.ofNullable(new TestVo(1,1,"name"));
        Optional<String> s = o2.map(t -> t.getName());
        System.out.println(s.get());

        Optional<String> s1 = o2.flatMap(flatMap -> Optional.ofNullable(flatMap.getName()));
        System.out.println(s1.get());



    }
}
