package test.java8.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java8线程日期转换类-线程安全
 *
 * @Author chenxiangge
 * @Date 2020/10/16
 */
public class TestDateTimeFormatter {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //创建任务（带返回值）
        Callable<LocalDate> task = () -> LocalDate.parse("2020-01-01",dateTimeFormatter);

        //创建返回结果list
        List<Future<LocalDate>> res = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            //多线程重复提交任务
            res.add(executorService.submit(task));
        }

        for (Future<LocalDate> re : res) {
            /**
             * SimpleDateFormat 线程安全，每个format返回的值不一样，有些甚至无法解析
             * 报错 Caused by: java.lang.NumberFormatException: multiple points
             */
            System.out.println(re.get());
        }

        executorService.shutdown();
    }
}
