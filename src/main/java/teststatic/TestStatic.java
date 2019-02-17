package teststatic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class TestStatic {
    /**
     * 线程池的基本大小
     */
    private static int corePoolSize = 5;
    /**
     * 线程池最大数量
     */
    private static int maximumPoolSizeSize = 200;
    /**
     * 线程活动保持时间
     */
    private static long keepAliveTime = 0;
    /**
     * 任务队列
     */
    private static ArrayBlockingQueue workQueue = new ArrayBlockingQueue<Runnable>(1024);


    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("my-pool-%d").build();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSizeSize,
            keepAliveTime,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            namedThreadFactory);

    private static final Logger logger = LoggerFactory.getLogger(TestStatic.class);

    public void test(String name1, String name2) {


        CompletableFuture.supplyAsync(() -> {

            System.out.println(name1);
            System.out.println(executor.toString());
            return name1;
        }, executor);


        CompletableFuture.supplyAsync(() -> {
            System.out.println(name2);
            System.out.println(executor.toString());
            return name2;
        }, executor);


    }

    public void shutdown() {
        executor.shutdownNow();
    }


}
