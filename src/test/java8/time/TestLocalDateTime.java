package test.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2020/10/22
 */
public class TestLocalDateTime {
    //1、localDate、LocalTime、localDateTime - 人读
    //2、Instant: 时间戳 （以Unix元年 1970年1月1好 00：00：00 到某个时间之间的毫秒数）
    //3、Duration 计算两个时间之间的间隔
    //4、Period 计算两个日期之间的间隔
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime ofTime = LocalDateTime.of(2020, 1, 29, 1, 1);
        System.out.println(ofTime);


        Instant now1 = Instant.now(); //默认获取UTC时区（格林尼治时间）
        System.out.println(now1);

        //带偏移量的时间
        OffsetDateTime offsetDateTime = now1.atOffset(ZoneOffset.ofHours(8));
        //2020-10-22T20:46:59.641+08:00
        System.out.println(offsetDateTime);

        //毫秒显示
        System.out.println(now1.toEpochMilli());

        //修改毫秒数
        Instant instant2= Instant.ofEpochMilli(100);
        //1970-01-01T00:00:00.100Z - 相对于Unix元年的偏移量
        System.out.println(instant2);


        //计算两个时间戳之间的修改
        Duration between = Duration.between(instant2, now1);
        System.out.println(between.toMillis());

        //两个时间之间的间隔
        Duration between2 = Duration.between(now, ofTime);
        System.out.println(between2.toMillis());
        System.out.println(between2.getSeconds());


        LocalDate now2 = LocalDate.now();
        try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        LocalDate now3 = LocalDate.now();
        Period period = Period.between(now2, now3);
        System.out.println(period);



    }
}
