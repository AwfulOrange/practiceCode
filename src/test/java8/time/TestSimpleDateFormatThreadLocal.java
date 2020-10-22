package test.java8.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 * 如何防止simpleDateFormat多线程问题
 * 1、添加ThreadLocal，线程独享变量
 *
 * @Author chenxiangge
 * @Date 2020/10/16
 */
public class TestSimpleDateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> simpleDateFormatThreadLocal = new ThreadLocal<DateFormat>(){
        /**
         * 重写初始化方法，否则未初始化数据为空
         * @return
         */
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date convert(String dateStr) throws ParseException {
        return simpleDateFormatThreadLocal.get().parse(dateStr);
    }
}
