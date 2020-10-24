package test.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

// TODO: 2020/10/24 弄个junit test包

/**
 * @Author chenxiangge
 * @Date 2020/10/22
 */
public class TestLocalDateTime {
    //1、localDate、LocalTime、localDateTime - 人读
    //2、Instant: 时间戳 （以Unix元年 1970年1月1好 00：00：00 到某个时间之间的毫秒数） -机器读
    //3、Duration 计算两个时间之间的间隔
    //4、Period 计算两个日期之间的间隔
    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//
//        LocalDateTime ofTime = LocalDateTime.of(2020, 1, 29, 1, 1);
//        System.out.println(ofTime);
//
//
//        Instant now1 = Instant.now(); //默认获取UTC时区（格林尼治时间）
//        System.out.println(now1);
//
//        //带偏移量的时间
//        OffsetDateTime offsetDateTime = now1.atOffset(ZoneOffset.ofHours(8));
//        //2020-10-22T20:46:59.641+08:00
//        System.out.println(offsetDateTime);
//
//        //毫秒显示
//        System.out.println(now1.toEpochMilli());
//
//        //修改毫秒数
//        Instant instant2= Instant.ofEpochMilli(100);
//        //1970-01-01T00:00:00.100Z - 相对于Unix元年的偏移量
//        System.out.println(instant2);
//
//
//        //计算两个时间戳之间的修改
//        Duration between = Duration.between(instant2, now1);
//        System.out.println(between.toMillis());
//
//        //两个时间之间的间隔
//        Duration between2 = Duration.between(now, ofTime);
//        System.out.println(between2.toMillis());
//        System.out.println(between2.getSeconds());
//
//
//        LocalDate now2 = LocalDate.now();
//        LocalDate now3 = now2.plusDays(1).plusYears(2);
//        Period period = Period.between(now2, now3);
//        //P2Y1D-新的标准格式
//        System.out.println(period);
//
//
//        //时间矫正器
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//
//        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(1);
//        System.out.println(localDateTime1);
//
//        //时间矫正器 - TemporalAdjuster - 函数式接口 可以使用lambda表达式
//        //时间矫正器 - 工具类 TemporalAdjusters
//
//        //通过工具类获取
//        LocalDateTime localDateTime3= localDateTime.with( TemporalAdjusters.lastDayOfYear());
//        System.out.println(localDateTime3);
//
//        //自定义日期矫正器
//        LocalDateTime dt = LocalDateTime.now();
//        //获取当前日期的下一个工作日
//        LocalDateTime nextWeekDay = dt.with((l) -> {
//            //with原始类型是TemporalAdjuster ，需要强转
//            LocalDateTime time = (LocalDateTime) l;
//
//            DayOfWeek dayOfWeek = time.getDayOfWeek();
//            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
//                return time.plusDays(3);
//            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
//                return time.plusDays(2);
//            } else {
//                return time.plusDays(1);
//            }
//        });
//        System.out.println(nextWeekDay);

        testZoneDate();
//        testDateTimeFormatter();


    }

    private static void testDateTimeFormatter() {
        //格式化日期/时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_WEEK_DATE;
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(dateTimeFormatter.format(localDateTime2));

        //转成str
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = dateTimeFormatter2.format(localDateTime2);
        System.out.println(format);

        //转成ldt
        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter2);
        System.out.println(parse);

    }

    /**
     * ZoneDate,ZonedTime,ZonedDateTime
     */
    private static void testZoneDate() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("SystemV/AST4"));
        //2020-10-23T23:53:19.012
        System.out.println(now);


        //2020-10-23T23:53:19.012-04:00[SystemV/AST4]
        //带偏移量 带时区的时间
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("SystemV/AST4"));
        System.out.println(zonedDateTime);
    }



}
