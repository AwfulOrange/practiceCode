package test.java8.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author chenxiangge
 * @Date 2020/10/16
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * simpleDateFormat多线程不安全问题
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //创建任务（带返回值）
        Callable<Date> task = () -> TestSimpleDateFormatThreadLocal.convert("2020-01-01");

        //创建返回结果list
        List<Future<Date>> res = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            //多线程重复提交任务
            res.add(executorService.submit(task));
        }

        for (Future<Date> re : res) {
            /**
             * SimpleDateFormat 线程安全，每个format返回的值不一样，有些甚至无法解析
             * 报错 Caused by: java.lang.NumberFormatException: multiple points
             */
            System.out.println(re.get());
        }

        executorService.shutdown();
    }
}
