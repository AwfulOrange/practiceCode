package test.java8.forkjoin;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author chenxiangge
 * @Date 2020/10/14
 * <p>
 * RecursiveTask - compute() 有返回值
 * RecursiveAction - compute() 无返回值 void
 * <p>
 * 利用fork-join框架进行累加
 */
public class ForkJoinCalculator extends RecursiveTask<Long> {

    /**
     * 累加初始值、结束值
     */
    private final Long start;
    private final Long end;

    /**
     * 拆分大小
     * 假设THRESHOLD =100
     * 即：每100个数字进行拆分（100个数的累加作为子任务）
     */
    public static final long THRESHOLD = 10000;

    public ForkJoinCalculator(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = start - end;
        if (length <= THRESHOLD) {
            //小于临界值则进行累加（子任务的执行）
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //对半拆分
            Long middle = (start + end) / 2;
            //大于临界值-进行任务的拆分 递归地进行调用
            ForkJoinCalculator left = new ForkJoinCalculator(start, middle);
            ForkJoinCalculator right = new ForkJoinCalculator(middle + 1, end);

            /**
             * 拆分子任务，同时压入线程队列
             */
            left.fork();
            right.fork();

            return left.join() + right.join();
        }
    }

    public static void main(String[] args) {
        /**
         * fork-join框架
         */
        Instant forkStart = Instant.now();
        //fork-join任务需要放入在fork-join池中
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 拆分也需要时间，只有在达到一定量级的时候，才能体现出fork-join框架的优势
        ForkJoinCalculator forkJoinCalculator = new ForkJoinCalculator(0L, 1000000000L);
        Long forkJoinSum = forkJoinPool.invoke(forkJoinCalculator);
        Instant forkEnd = Instant.now();
        System.out.println("fork-join-sum:" + forkJoinSum + " costTime:" + Duration.between(
                forkStart, forkEnd).toMillis());


        /**
         * 普通循环
         */
        Instant normalStart = Instant.now();
        long sum = 0;
        for (int i = 0; i <= 1000000000L; i++) {
            sum += i;
        }

        Instant normalEnd = Instant.now();

        System.out.println("normal-sum:" + sum + " costTime:" +  Duration.between(normalStart, normalEnd).toMillis());
//

        Instant java8Start = Instant.now();

        /**
         * java8并行流
         * 公共的fork-join pool（不需要手动添加）
         */
        LongStream.rangeClosed(0,1000000000L)
                .parallel()
                .reduce(0,Long::sum);
        Instant java8End = Instant.now();

        System.out.println(" costTime:" +  Duration.between(java8Start, java8End).toMillis());


        /**
         * 最后结果，内置fork-join框架的java8并行流在当前环境下速度最快。（6CPU 12核心）
         */
//        fork-join-sum:500000000500000000 costTime:374
//        normal-sum:500000000500000000 costTime:704
//        java8-sum:500000000500000000 costTime:196
    }
}
